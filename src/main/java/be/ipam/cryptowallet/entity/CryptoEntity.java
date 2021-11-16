package be.ipam.cryptowallet.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="Crypto")
public class CryptoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cryptoId;
	private String name;
	private String symbol;
	private double lastPrice;
}
