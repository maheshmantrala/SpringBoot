package com.mahesh.React.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.mahesh.React.model.User;
@EnableReactiveMongoRepositories
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

}
