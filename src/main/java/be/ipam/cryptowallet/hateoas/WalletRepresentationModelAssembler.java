package be.ipam.cryptowallet.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import be.ipam.cryptowallet.api.controller.CryptoController;
import be.ipam.cryptowallet.api.controller.WalletController;
import be.ipam.cryptowallet.api.model.Wallet;
import be.ipam.cryptowallet.entity.WalletEntity;
import be.ipam.cryptowallet.service.WalletService;

public class WalletRepresentationModelAssembler extends RepresentationModelAssemblerSupport<WalletEntity, Wallet> {

	WalletService walletService;

	public WalletRepresentationModelAssembler(WalletService walletSer) {
		super(WalletController.class, Wallet.class);
		this.walletService=walletSer;
	}
	
	@Override
	public Wallet toModel(WalletEntity entity) {
		
		Wallet resource = createModelWithId(entity.getWalletId(), entity);
		resource.removeLinks();
		BeanUtils.copyProperties(entity, resource);
	      	    
	    resource.add(linkTo(methodOn(CryptoController.class).getCryptoById(entity.getWalletId())).withSelfRel());
	    return resource;
	}

}
