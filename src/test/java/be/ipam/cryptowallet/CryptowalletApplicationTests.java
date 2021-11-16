package be.ipam.cryptowallet;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.ipam.cryptowallet.repository.UserEntityRepository;


@SpringBootTest
class CryptowalletApplicationTests {

	@Autowired
	UserEntityRepository urep;
	
	private static final Logger log = LoggerFactory.getLogger(CryptowalletApplicationTests.class);

	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testUser() {
		urep.findAll().forEach(u->log.info(u.getFirstname()));			
	}

}
