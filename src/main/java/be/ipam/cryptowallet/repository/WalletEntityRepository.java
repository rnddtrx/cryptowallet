package be.ipam.cryptowallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.cryptowallet.entity.WalletEntity;

@Repository
public interface WalletEntityRepository extends CrudRepository<WalletEntity, Long> {

}
