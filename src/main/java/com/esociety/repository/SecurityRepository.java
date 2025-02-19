package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.SecurityEntity;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityEntity, Integer> {

}
