package com.mahesh.springboot.CRUD.Repository;

import org.springframework.data.repository.CrudRepository;

import com.mahesh.springboot.CRUD.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
