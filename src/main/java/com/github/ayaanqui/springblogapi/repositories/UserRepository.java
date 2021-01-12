package com.github.ayaanqui.springblogapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.github.ayaanqui.springblogapi.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
