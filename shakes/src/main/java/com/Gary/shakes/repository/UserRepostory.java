package com.Gary.shakes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Gary.shakes.domain.User;

public interface UserRepostory extends CrudRepository<User,Long>{

	@Query(value = "select * from user where telephone = ?1",nativeQuery = true)
	//只有修改的时候才会加modefy注解
	List<User> judgeTelephone(String telephone);

	@Query(value = "select * from user where telephone = ?1",nativeQuery = true)
	User findUserByTelephone(String telephone);

}
