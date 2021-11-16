package be.ipam.cryptowallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.cryptowallet.entity.CryptoEntity;

@Repository
public interface CryptoEntityRepository extends CrudRepository<CryptoEntity, Long> {

}
