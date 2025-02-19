package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.DeliverablesEntity;

@Repository
public interface DeliverablesRepository extends JpaRepository<DeliverablesEntity, Integer> {

}
