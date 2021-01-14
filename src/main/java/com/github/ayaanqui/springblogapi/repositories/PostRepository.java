package com.github.ayaanqui.springblogapi.repositories;

import com.github.ayaanqui.springblogapi.models.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
