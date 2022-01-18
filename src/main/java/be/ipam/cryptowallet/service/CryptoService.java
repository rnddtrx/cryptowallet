package be.ipam.cryptowallet.service;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import be.ipam.cryptowallet.api.model.Crypto;
import be.ipam.cryptowallet.api.model.User;
import be.ipam.cryptowallet.entity.CryptoEntity;
import be.ipam.cryptowallet.entity.UserEntity;
import be.ipam.cryptowallet.hateoas.CryptoRepresentationModelAssembler;
import be.ipam.cryptowallet.hateoas.UserRepresentationModelAssembler;
import be.ipam.cryptowallet.repository.CryptoEntityRepository;

@Service
public class CryptoService {
	@Autowired
	CryptoEntityRepository cryptoEntityRepository;
		
	CryptoRepresentationModelAssembler assembler;
	
	public CryptoService(){
		this.assembler = new CryptoRepresentationModelAssembler(this);
	}
	
	
	//Sauve l'entité dans la db.
	public CryptoEntity addCrypto(CryptoEntity ce) {
		return cryptoEntityRepository.save(ce);
	}
	
	//Sauve l'objet après l'avoir transformé en objet entité
	public ResponseEntity<Crypto> addCrypto(Crypto crypto) {
		CryptoEntity cryptoentity = this.toEntity(crypto);
		//Sauve dans la DB
		cryptoentity = this.addCrypto(cryptoentity);
		return Optional.of(cryptoentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	//de objet à entité
	public CryptoEntity toEntity(Crypto model) {
		CryptoEntity entity = new CryptoEntity();		
		entity.setCryptoId(model.getCryptoId());
		entity.setName(model.getName());
		entity.setSymbol(model.getSymbol());
		entity.setLastPrice(model.getLastPrice());
		return entity;
	}
	
	//delete
	public void deleteCrypto(long id) {
		cryptoEntityRepository.deleteById(id);;
	}	
	
	//get
	public ResponseEntity<Crypto> getCryptoById(long id) {
		CryptoEntity cryptoentity = cryptoEntityRepository.findById(id).get();
		return Optional.of(cryptoentity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());		
	}
	
	//get
	public CryptoEntity getCryptoEntityById(long id) {
		return cryptoEntityRepository.findById(id).get();	
	}
	
	
	public ResponseEntity<Crypto> updateCrypto(long id ,Crypto crypto) {
		CryptoEntity modifiedCryptoentity = this.toEntity(crypto);
		CryptoEntity cryptoEntity = cryptoEntityRepository.findById(id).get();
		BeanUtils.copyProperties(modifiedCryptoentity,cryptoEntity);
		cryptoEntity = cryptoEntityRepository.save(cryptoEntity);
		return Optional.of(cryptoEntity).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		
	}
	

}