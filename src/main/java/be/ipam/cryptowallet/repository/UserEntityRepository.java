package be.ipam.cryptowallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.cryptowallet.entity.UserEntity;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {

}
