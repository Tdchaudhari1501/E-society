package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.HouseEntity;

@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Integer> {

}
