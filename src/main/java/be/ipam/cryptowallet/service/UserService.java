package be.ipam.cryptowallet.service;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import be.ipam.cryptowallet.api.model.User;
import be.ipam.cryptowallet.entity.UserEntity;
import be.ipam.cryptowallet.hateoas.UserRepresentationModelAssembler;
import be.ipam.cryptowallet.repository.UserEntityRepository;



@Service
public class UserService {
	@Autowired
	UserEntityRepository userEntityRepository;
	
	UserRepresentationModelAssembler assembler;
	
	public UserService(){
		this.assembler = new UserRepresentationModelAssembler(this);
	}
	
	public UserEntity getUserByID(long userId){
		Optional<UserEntity> ue = userEntityRepository.findById(userId);
		if(ue.isPresent())
			return userEntityRepository.findById(userId).get();
		else
			return null;
	}
	
	public UserEntity addUser(UserEntity ue) {
		return userEntityRepository.save(ue);
	}
	
	public ResponseEntity<User> addUser(User user) {
		UserEntity ue = this.toEntity(user);
		ue = this.addUser(ue);
		return Optional.of(ue).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	public UserEntity toEntity(User model) {
		UserEntity entity = new UserEntity();		
		entity.setFirstname(model.getFirstname());
		entity.setLastname(model.getFirstname());
		entity.setMail(model.getMail());
		entity.setPassword(model.getPassword());
		return entity;
	}
	
	
	
}
