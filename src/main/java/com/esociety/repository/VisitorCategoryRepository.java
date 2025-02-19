package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.VisitorCategoryEntity;

@Repository
public interface VisitorCategoryRepository extends JpaRepository<VisitorCategoryEntity, Integer> {

}
