package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.VisitorEntity;

@Repository
public interface VisitorRepository extends JpaRepository<VisitorEntity, Integer> {

}
