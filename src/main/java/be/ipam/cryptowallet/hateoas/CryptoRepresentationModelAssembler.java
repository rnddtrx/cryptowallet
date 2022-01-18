package be.ipam.cryptowallet.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.ipam.cryptowallet.api.controller.CryptoController;
import be.ipam.cryptowallet.api.controller.UserController;
import be.ipam.cryptowallet.api.model.Crypto;
import be.ipam.cryptowallet.api.model.User;
import be.ipam.cryptowallet.entity.CryptoEntity;
import be.ipam.cryptowallet.entity.UserEntity;
import be.ipam.cryptowallet.service.CryptoService;
import be.ipam.cryptowallet.service.UserService;



public class CryptoRepresentationModelAssembler extends RepresentationModelAssemblerSupport<CryptoEntity,Crypto> {

	CryptoService cryptoService;

	public CryptoRepresentationModelAssembler(CryptoService cryptoSer) {
		super(CryptoController.class, Crypto.class);
		this.cryptoService=cryptoSer;
	}
	
	@Override
	public Crypto toModel(CryptoEntity entity) {
		
		Crypto resource = createModelWithId(entity.getCryptoId(), entity);
		resource.removeLinks();
		BeanUtils.copyProperties(entity, resource);
	      	    
	    resource.add(linkTo(methodOn(CryptoController.class).getCryptoById(entity.getCryptoId())).withSelfRel());
	    return resource;
	}

}
