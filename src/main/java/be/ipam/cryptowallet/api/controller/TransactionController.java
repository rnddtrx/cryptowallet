package be.ipam.cryptowallet.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.cryptowallet.api.TransactionApi;
import be.ipam.cryptowallet.api.model.Transaction;
import be.ipam.cryptowallet.service.CryptoService;
import be.ipam.cryptowallet.service.TransactionService;

@RestController
public class TransactionController implements TransactionApi {

	@Autowired
	TransactionService transactionService;
	
	@Override
	public ResponseEntity<Transaction> addTransaction(@Valid Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@Override
	public ResponseEntity<Void> deleteTransactionById(long transactionId) {
		// TODO Auto-generated method stub
		return TransactionApi.super.deleteTransactionById(transactionId);
	}

	@Override
	public ResponseEntity<Transaction> getTransactionById(long l) {
		// TODO Auto-generated method stub
		return TransactionApi.super.getTransactionById(l);
	}

	@Override
	public ResponseEntity<Void> updateTransaction(long transactionId, @Valid Transaction transaction) {
		// TODO Auto-generated method stub
		return TransactionApi.super.updateTransaction(transactionId, transaction);
	}

}
