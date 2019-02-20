package com.Gary.shakes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Gary.shakes.domain.Video;

public interface VideoRepository extends CrudRepository<Video,Long>{

	@Query(value="select * from video where user_id = ?1",nativeQuery=true)
	List<Video> findVideoByUserId(Long user_id);

	
}
