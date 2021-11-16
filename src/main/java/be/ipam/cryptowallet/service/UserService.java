package be.ipam.cryptowallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ipam.cryptowallet.entity.UserEntity;
import be.ipam.cryptowallet.repository.UserEntityRepository;

@Service
public class UserService {
	@Autowired
	UserEntityRepository userEntityRepository;
	
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
	
	
}
