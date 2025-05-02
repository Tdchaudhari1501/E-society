package com.esociety.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.esociety.entity.ComplaintEntity;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Integer> {
    List<ComplaintEntity> findByUserId(Integer userId);
 // For filtering by user, type, and status
    List<ComplaintEntity> findByUserIdAndTypeContainingAndStatusContaining(Integer userId, String type, String status);

}
