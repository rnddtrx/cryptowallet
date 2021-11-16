package be.ipam.cryptowallet.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Transaction")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long TransactionId;
	private double quantity;
	private Date date;
	private double price;
	private long operation;
	
	@ManyToOne
	@JoinColumn(name="WalletId")
	private WalletEntity wallet;
	@ManyToOne
	@JoinColumn(name="CryptoId")
	private CryptoEntity crypto;
}
