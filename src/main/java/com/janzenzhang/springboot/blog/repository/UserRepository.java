package com.janzenzhang.springboot.blog.repository;

import com.janzenzhang.springboot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {



}
