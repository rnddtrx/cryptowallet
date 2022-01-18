package be.ipam.cryptowallet.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.cryptowallet.api.CryptoApi;
import be.ipam.cryptowallet.api.model.Crypto;
import be.ipam.cryptowallet.service.CryptoService;

@RestController
public class CryptoController implements CryptoApi{

	@Autowired
	CryptoService cryptoService;
	
	@Override
	public ResponseEntity<Crypto> addCrypto(@Valid Crypto crypto) {
		return cryptoService.addCrypto(crypto);
	}

	@Override
	public ResponseEntity<Void> deleteCryptoById(long cryptoId) {
		cryptoService.deleteCrypto(cryptoId);
		//No content 204
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Crypto> getCryptoById(long id) {
		return cryptoService.getCryptoById(id);
	}

	@Override
	public ResponseEntity<Void> updateCrypto(Integer cryptoId, @Valid Crypto crypto) {
		// TODO
		return CryptoApi.super.updateCrypto(cryptoId, crypto);
	}

}
