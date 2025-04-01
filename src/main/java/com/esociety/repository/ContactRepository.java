package com.esociety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esociety.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}