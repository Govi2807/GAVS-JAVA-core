package com.example.demo.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository

public interface LoginRepository extends CrudRepository<User, Long> {

}
