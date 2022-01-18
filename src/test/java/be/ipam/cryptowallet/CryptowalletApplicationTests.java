package be.ipam.cryptowallet;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.ipam.cryptowallet.api.model.Crypto;
import be.ipam.cryptowallet.api.model.Transaction;
import be.ipam.cryptowallet.api.model.Wallet;
import be.ipam.cryptowallet.entity.CryptoEntity;
import be.ipam.cryptowallet.entity.TransactionEntity;
import be.ipam.cryptowallet.entity.WalletEntity;
import be.ipam.cryptowallet.repository.UserEntityRepository;
import be.ipam.cryptowallet.service.CryptoService;
import be.ipam.cryptowallet.service.TransactionService;
import be.ipam.cryptowallet.service.WalletService;


@SpringBootTest
class CryptowalletApplicationTests {

	@Autowired
	UserEntityRepository urep;
	@Autowired
	TransactionService trser;
	@Autowired
	WalletService wser;
	@Autowired
	CryptoService cser;
	
	private static final Logger log = LoggerFactory.getLogger(CryptowalletApplicationTests.class);

	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testUser() {
		urep.findAll().forEach(u->log.info(u.getFirstname()));			
	}
	
	

	@Test
	void testTransaction() {
		TransactionEntity tr= new TransactionEntity();
		CryptoEntity cr = cser.getCryptoEntityById(1);
		WalletEntity wa = wser.getWalletEntityById(1);
		tr.setCrypto(cr);;
		tr.setWallet(wa);
		tr.setDate(new Date());
		tr.setPrice(189);
		tr.setQuantity(5);
		trser.addTransaction(tr);		
	}

}
