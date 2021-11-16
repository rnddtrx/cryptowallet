package be.ipam.cryptowallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.cryptowallet.entity.UserEntity;

public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {

}
