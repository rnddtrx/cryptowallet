package be.ipam.cryptowallet.api.controller;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import be.ipam.cryptowallet.api.UserApi;
import be.ipam.cryptowallet.api.model.User;
import be.ipam.cryptowallet.service.UserService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

	@Autowired 
	UserService userSer;
	
	@Override
	public ResponseEntity<User> addUser(@Valid User user) {
		return userSer.addUser(user);
	}

	@Override
	public ResponseEntity<Void> deleteUserById(long userId) {
		// TODO Auto-generated method stub
		return UserApi.super.deleteUserById(userId);
	}

	@Override
	public ResponseEntity<User> getUserById(long userId) {
		// TODO Auto-generated method stub
		return UserApi.super.getUserById(userId);
	}

	@Override
	public ResponseEntity<Void> updateUser(long userId, @Valid User user) {
		// TODO Auto-generated method stub
		return UserApi.super.updateUser(userId, user);
	}

}
