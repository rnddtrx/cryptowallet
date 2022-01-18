package be.ipam.cryptowallet.service;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import be.ipam.cryptowallet.api.model.Wallet;
import be.ipam.cryptowallet.entity.WalletEntity;
import be.ipam.cryptowallet.hateoas.WalletRepresentationModelAssembler;
import be.ipam.cryptowallet.repository.WalletEntityRepository;

@Service
public class WalletService {
	@Autowired
	WalletEntityRepository walletEntityRepository;
		
	WalletRepresentationModelAssembler assembler;
	
	public WalletService(){
		this.assembler = new WalletRepresentationModelAssembler(this);
	}
	
	
	//Sauve l'entité dans la db.
	public WalletEntity addCrypto(WalletEntity ce) {
		return walletEntityRepository.save(ce);
	}
	
	//Sauve l'objet après l'avoir transformé en objet entité
	public ResponseEntity<Wallet> addCrypto(Wallet wallet) {
		WalletEntity walletentity = this.toEntity(wallet);
		//Sauve dans la DB
		walletentity = this.addCrypto(walletentity);
		return Optional.of(walletentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	//de objet à entité
	public WalletEntity toEntity(Wallet model) {
		WalletEntity entity = new WalletEntity();		
		entity.setWalletId(model.getWalletId());
		entity.setName(model.getName());
		entity.setAddressBtc(model.getAddressBtc());
		entity.setAddressEth(model.getAddressEth());
		return entity;
	}
	
	//delete
	public void deleteWallet(long id) {
		walletEntityRepository.deleteById(id);;
	}	
	
	//get
	public ResponseEntity<Wallet> getWalletById(long id) {
		WalletEntity walletentity = walletEntityRepository.findById(id).get();
		return Optional.of(walletentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	//get
	public WalletEntity getWalletEntityById(long id) {
		return walletEntityRepository.findById(id).get();		
	}
	
	public ResponseEntity<Wallet> updateCrypto(long id ,Wallet wallet) {
		WalletEntity modifiedWalletentity = this.toEntity(wallet);
		WalletEntity walletEntity = walletEntityRepository.findById(id).get();
		BeanUtils.copyProperties(modifiedWalletentity,walletEntity);
		walletEntity = walletEntityRepository.save(walletEntity);
		return Optional.of(walletEntity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		
	}
}
