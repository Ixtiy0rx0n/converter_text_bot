package org.example.repository;

import org.example.entity.UserEntity;
import org.hibernate.annotations.processing.HQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @HQL("SELECT * from users where chat_id=?1")
    Optional<UserEntity> findByChatId(Long chatId);
}
