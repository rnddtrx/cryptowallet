package be.ipam.cryptowallet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="UserApp")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	private String lastname;
	private String firstname;
	private String mail;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<WalletEntity> wallets;
}
