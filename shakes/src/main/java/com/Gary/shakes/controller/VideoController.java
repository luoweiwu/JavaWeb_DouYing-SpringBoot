package com.Gary.shakes.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Gary.shakes.domain.User;
import com.Gary.shakes.domain.Video;
import com.Gary.shakes.serviceimpl.VideoServiceImpl;
import com.Gary.shakes.utils.Signature;

@RestController
public class VideoController {

	@Autowired
	private VideoServiceImpl videoServiceImpl;
	
	@RequestMapping("/findVideo")
	public ModelAndView findVideo(HttpServletRequest request,Model model) 
	{
		//得到用户id
		User user = (User) request.getSession().getAttribute("loginUser");
		Long user_id = user.getId();
		//准备list
		List<Video> videoList = videoServiceImpl.findVideoByUserId(user_id);
		
		//将list放入model中
		model.addAttribute("videoList",videoList);
		
		System.out.println(videoList.get(0));
		return new ModelAndView("/register-add-music.html","videoModel",model);
	}
	
	
	@RequestMapping("addVideo")
	public ModelAndView addVideo(Video video,HttpServletRequest request)
	{

		//封装User
		User user = (User) request.getSession().getAttribute("loginUser");
		
		//添加Video
		video.setUser(user);
		videoServiceImpl.save(video);
		
		return new ModelAndView("redirect:/findVideo");
		
	}
	
	//给页面一个加密后的字符串
	@RequestMapping("/sign")
	@ResponseBody
	public String sign()
	{
		//得到加密后的字符串sign
		Signature sign = new Signature();
		//id
		sign.setSecretId("AKIDkNsDQWZOYYVSHu49kDh9Uh1FSo3BsnLm");
		//key
		sign.setSecretKey("XDn1a3NWzN0Tp4vH3zpSp5fEX2Rq9KYg");
		//当前的时间
		sign.setCurrentTime(System.currentTimeMillis()/1000);
		//随机数
		sign.setRandom(new Random().nextInt(Integer.MAX_VALUE));
		//xxx
		sign.setSignValidDuration(3600*24*2);
		//得到sign
		
		String signature = null;
		try {
			signature = sign.getUploadSignature();
			System.out.println("signature："+signature);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return signature;
	}
}
