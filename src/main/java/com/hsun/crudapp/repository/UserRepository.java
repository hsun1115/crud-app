package com.hsun.crudapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hsun.crudapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
