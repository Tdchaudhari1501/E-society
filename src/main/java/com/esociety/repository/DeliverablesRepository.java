package com.esociety.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esociety.entity.DeliverablesEntity;

@Repository
public interface DeliverablesRepository extends JpaRepository<DeliverablesEntity, Integer> {
	@Query(value = "select d.date,d.is_pickup,d.product_photo,d.deliverables_id from deliverables d , users u where u.user_id = d.user_id and  d.user_id = :userId",nativeQuery = true)
 	List<Object[]>	getAll(Integer userId);
 	
 	@Query(nativeQuery = true,value = "select count(*) from deliverables where month(date)=:month")
 	Integer countThisMonthDeliverable(Integer month);
}
