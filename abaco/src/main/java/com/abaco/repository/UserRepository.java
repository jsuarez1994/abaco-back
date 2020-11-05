package com.abaco.repository;

import com.abaco.entity.UserEntity;

public interface UserRepository extends AbstractRepository<UserEntity> {

	UserEntity findByEmailAndPassword(final String email, final String password);

}
