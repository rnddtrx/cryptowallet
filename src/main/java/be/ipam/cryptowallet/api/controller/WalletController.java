package be.ipam.cryptowallet.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.cryptowallet.api.WalletApi;
import be.ipam.cryptowallet.api.model.Wallet;
import be.ipam.cryptowallet.service.CryptoService;
import be.ipam.cryptowallet.service.WalletService;

@RestController
public class WalletController implements WalletApi {

	@Autowired
	WalletService walletService;
	
	@Override
	public ResponseEntity<Wallet> addWallet(@Valid Wallet wallet) {
		return walletService.addCrypto(wallet);
	}

	@Override
	public ResponseEntity<Void> deleteWalletById(long walletId) {
		walletService.deleteWallet(walletId);
		//No content 204
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Wallet> getWalletById(long walletId) {
		return walletService.getWalletById(walletId);
	}

	@Override
	public ResponseEntity<Void> updateWallet(long walletId, @Valid Wallet wallet) {
		// TODO Auto-generated method stub
		return WalletApi.super.updateWallet(walletId, wallet);
	}

}