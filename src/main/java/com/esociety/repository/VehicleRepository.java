package com.esociety.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esociety.entity.VehicleEntity;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
	@Query(value = "select v.* , u.first_name , u.last_name from users u , vehicle v where v.user_id = u.user_id", nativeQuery = true)
 	List<Object[]> getAll();
 
 	@Query(value = "select v.* , u.first_name , u.last_name from users u , vehicle v where v.user_id = u.user_id and v.vehicle_id = :vehicleId", nativeQuery = true)
 	List<Object[]> getByVehicleId(Integer vehicleId);
}
