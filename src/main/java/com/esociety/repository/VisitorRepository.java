package com.esociety.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.esociety.entity.VisitorEntity;

@Repository
public interface VisitorRepository extends JpaRepository<VisitorEntity, Integer> {
	@Query(value = "select v.visitor_name,v.purpose,v.allowed,v.entry_time,v.exit_time,v.mobile_no,v.profile_photo,v.date,v.visitor_id from visitor v , users u where u.user_id = v.user_id and  v.user_id = :userId",nativeQuery = true)
 	List<Object[]>	getAll(Integer userId);
 	
 	@Query(nativeQuery = true,value = "select count(*) from visitor where month(date)=:month")
 	Integer countThisMonthVisitor(Integer month);
 	
 	 List<VisitorEntity> findByUserId(Integer userId);
     List<VisitorEntity> findByStatus(String status);

	List<VisitorEntity> findByMobileNo(String mobile);
 	
// 	@Query(nativeQuery = true,value = "select count(*) from visitor where month(date)=:month")
// 	Integer countThisDayVisitor(Integer day);
}
