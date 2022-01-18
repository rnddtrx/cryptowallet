package be.ipam.cryptowallet.service;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import be.ipam.cryptowallet.api.model.Transaction;
import be.ipam.cryptowallet.entity.TransactionEntity;
import be.ipam.cryptowallet.hateoas.TransactionRepresentationModelAssembler;
import be.ipam.cryptowallet.repository.TransactionEntityRepository;



@Service
public class TransactionService {
	@Autowired
	TransactionEntityRepository transactionEntityRepository;
	@Autowired
	CryptoService cryptoService;
	@Autowired
	WalletService walletService;
		
	TransactionRepresentationModelAssembler assembler;
	
	public TransactionService(){
		this.assembler = new TransactionRepresentationModelAssembler(this);
	}
	
	
	//Sauve l'entité dans la db.
	public TransactionEntity addTransaction(TransactionEntity ce) {
		return transactionEntityRepository.save(ce);
	}
	
	//Sauve l'objet après l'avoir transformé en objet entité
	public ResponseEntity<Transaction> addTransaction(Transaction transaction) {
		TransactionEntity transactionentity = this.toEntity(transaction);
		//Sauve dans la DB
		transactionentity = this.addTransaction(transactionentity);
		return Optional.of(transactionentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	//de objet à entité
	public TransactionEntity toEntity(Transaction model) {
		TransactionEntity entity = new TransactionEntity();		
		entity.setTransactionId(model.getTransactionId());
		entity.setQuantity(model.getNumber());
		entity.setPrice(model.getPrice());
		entity.setCrypto(cryptoService.getCryptoEntityById(model.getCrypto().getCryptoId()));
		entity.setWallet(walletService.getWalletEntityById(model.getWallet().getWalletId()));
		return entity;
	}
	
	//delete
	public void deleteTransaction(long id) {
		transactionEntityRepository.deleteById(id);;
	}	
	
	//get
	public ResponseEntity<Transaction> getTransactionById(long id) {
		TransactionEntity transactionentity = transactionEntityRepository.findById(id).get();
		return Optional.of(transactionentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	public ResponseEntity<Transaction> updateCrypto(long id ,Transaction transaction) {
		TransactionEntity modifiedTransactionentity = this.toEntity(transaction);
		TransactionEntity transactionEntity = transactionEntityRepository.findById(id).get();
		BeanUtils.copyProperties(modifiedTransactionentity,transactionEntity);
		transactionEntity = transactionEntityRepository.save(transactionEntity);
		return Optional.of(transactionEntity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		
	}
}
