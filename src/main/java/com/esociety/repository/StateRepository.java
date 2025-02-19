package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer> {
    
}
