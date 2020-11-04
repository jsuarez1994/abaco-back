package com.abaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abaco.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
