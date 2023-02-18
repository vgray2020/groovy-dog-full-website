package com.javaform11.javaform.repository;

import com.javaform11.javaform.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional<UsersModel> findByLoginAndPassword(String login, String password);


}
