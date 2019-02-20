package com.Gary.shakes.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gary.shakes.domain.Video;
import com.Gary.shakes.repository.VideoRepository;
import com.Gary.shakes.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public void save(Video video) {
		videoRepository.save(video);
	}

	@Override
	public List<Video> findVideoByUserId(Long user_id) {
		
		return videoRepository.findVideoByUserId(user_id);
	}
	

}
