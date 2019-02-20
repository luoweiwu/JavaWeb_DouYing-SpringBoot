package com.Gary.shakes.service;

import java.util.List;

import com.Gary.shakes.domain.Video;

public interface VideoService {

	void save(Video video);
	List<Video> findVideoByUserId(Long user_id);
}
