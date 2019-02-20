package com.Gary.shakes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ToController {

	@RequestMapping("/toindex")
	public ModelAndView index() {
		return new ModelAndView("/index.html");
	}
	
	@RequestMapping("/tologin")
	public ModelAndView login() {
		return new ModelAndView("/login.html");
	}
	
	@RequestMapping("/toregister")
	public ModelAndView register() {
		return new ModelAndView("/register.html");
	}
	
	@RequestMapping("/tomusic-people")
	public ModelAndView musicPeople() {
		return new ModelAndView("/music-people.html");
	}
	
	@RequestMapping("/toregister-add-music")
	public ModelAndView toregisterAddMusic()
	{
		return new ModelAndView("/register-add-music.html");
	}
	
	@RequestMapping("/toregister-add-music-in")
	public ModelAndView toregisterAddMusicIn()
	{
		return new ModelAndView("/register-add-music-in.htm");
	}
	
	@RequestMapping("/toregister-finish")
	public ModelAndView toregisterAddMusicFinish()
	{
		return new ModelAndView("/register-finish.html");
	}
	
	
}
