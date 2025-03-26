package com.esociety.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esociety.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	@Query(value = "select u.user_Id , m.membername , m.age ,m.profile_photo from users u , member m where u.user_id = m.user_id and m.member_id = :userId", nativeQuery = true)
	List<Object[]> getMember(Integer userId);
	
 	@Query(value = "select m.membername,m.age,m.profile_photo from member m , users u where u.user_id = m.user_id and m.user_id = :userId",nativeQuery = true)
 	List<Object[]>	getAll(Integer userId);
}
 