package be.ipam.cryptowallet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Wallet")
public class WalletEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long walletId;
	private String name;
	private String addressEth;
	private String addressBtc;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private UserEntity user;
	
	@OneToMany(mappedBy="wallet")
	private List<TransactionEntity> transactions;
}
