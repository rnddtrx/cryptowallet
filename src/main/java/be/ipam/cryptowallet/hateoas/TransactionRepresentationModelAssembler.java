package be.ipam.cryptowallet.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import be.ipam.cryptowallet.api.controller.TransactionController;
import be.ipam.cryptowallet.api.model.Transaction;
import be.ipam.cryptowallet.api.model.Wallet;
import be.ipam.cryptowallet.entity.TransactionEntity;
import be.ipam.cryptowallet.entity.WalletEntity;
import be.ipam.cryptowallet.service.TransactionService;



public class TransactionRepresentationModelAssembler extends RepresentationModelAssemblerSupport<TransactionEntity, Transaction> {
	TransactionService transactionService;

	public TransactionRepresentationModelAssembler(TransactionService transactionSer) {
		super(TransactionController.class, Transaction.class);
		this.transactionService=transactionSer;
	}
	
	@Override
	public Transaction toModel(TransactionEntity entity) {
		
		Transaction resource = createModelWithId(entity.getTransactionId(), entity);
		resource.removeLinks();
		BeanUtils.copyProperties(entity, resource);
	      	    
	    resource.add(linkTo(methodOn(TransactionController.class).getTransactionById(entity.getTransactionId())).withSelfRel());
	    return resource;
	}
}
