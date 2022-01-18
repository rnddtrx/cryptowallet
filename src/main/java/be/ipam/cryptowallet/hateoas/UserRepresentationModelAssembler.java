package be.ipam.cryptowallet.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.ipam.cryptowallet.api.controller.UserController;
import be.ipam.cryptowallet.api.model.User;
import be.ipam.cryptowallet.entity.UserEntity;
import be.ipam.cryptowallet.service.UserService;



public class UserRepresentationModelAssembler extends RepresentationModelAssemblerSupport<UserEntity,User> {

	UserService userService;

	public UserRepresentationModelAssembler(UserService userSer) {
		super(UserController.class, User.class);
		this.userService=userSer;
	}
	
	@Override
	public User toModel(UserEntity entity) {
		
		User resource = createModelWithId(entity.getUserId(), entity);
		resource.removeLinks();
		BeanUtils.copyProperties(entity, resource);
	      	    
	    resource.add(linkTo(methodOn(UserController.class).getUserById(entity.getUserId())).withSelfRel());
	    return resource;
	}

}
