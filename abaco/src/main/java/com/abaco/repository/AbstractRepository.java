package com.abaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abaco.entity.BaseEntity;

public interface AbstractRepository<ENTITY extends BaseEntity> extends JpaRepository<ENTITY, Long> {

}
