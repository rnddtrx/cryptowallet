package be.ipam.cryptowallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.cryptowallet.entity.TransactionEntity;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, Long> {

}
