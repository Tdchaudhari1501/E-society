package com.esociety.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.esociety.entity.FacilityBookingEntity;

public interface FacilityBookingRepository extends JpaRepository<FacilityBookingEntity, Integer> {
    List<FacilityBookingEntity> findByUserId(Integer userId);
    List<FacilityBookingEntity> findByFacilityNameAndBookingDate(String facilityName, Date bookingDate);
}
