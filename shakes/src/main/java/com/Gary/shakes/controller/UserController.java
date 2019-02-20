package com.Gary.shakes.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Gary.shakes.domain.User;
import com.Gary.shakes.serviceimpl.UserServiceImpl;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;


@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		//在session域中的User 具有前四个属性 无wechat card name username
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		//user 没id 有wechat card name username
		loginUser.setWechat(user.getWechat());
		loginUser.setCard(user.getCard());
		loginUser.setName(user.getName());
		loginUser.setUsername(user.getUsername());
		
		userServiceImpl.save(loginUser);
		
		response.getWriter().write("{\"success\":"+true+"}");
		return null;
	}
	
	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request)
	{
		//在session域中移除loginUser
		request.getSession().removeAttribute("loginUser");
		return new ModelAndView("redirect:/tomusic-people");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(User user,HttpServletRequest request , Model model)
	{
//		System.out.println(user.getCode());
//		System.out.println(user.getTelephone());
		
		//获得session域中的验证码
		String sms = (String) request.getSession().getAttribute("sms");
		System.out.println(sms);
		System.out.println(user.getCode());
		//用session域中的验证码于user输入的验证码相比对
		if(sms.equals(user.getCode()))
		{
			//成功
			user.setState(1);
			System.out.println("成功！");
			//判断是否有相同的电话
			if(userServiceImpl.judgeTelephone(user.getTelephone()))
			{
				//有相同的电话不用做任何事，直接return
				
			}else {
				//在数据库中添加数据
				userServiceImpl.save(user);
			}
			User loginUser = userServiceImpl.findUserByTelephone(user.getTelephone());
			//在session域中放置User
			request.getSession().setAttribute("loginUser",loginUser);
			System.out.println(loginUser);
			//telephone
			//code
			return new ModelAndView("redirect:/toregister");
		}else {
			//失败
			model.addAttribute("message","验证码错误！！");
			return new ModelAndView("/login.html","userModel",model);
		}
		
	}

	@RequestMapping("/sms")
	public ModelAndView sms(String telephone,HttpServletResponse response,HttpServletRequest request) throws Exception, JSONException, IOException
	{
		
		System.out.println("我已经到达！");
		//发送手机验证码
		int appid = 1400184301;
		String appkey = "58f61b731363faba756087b9504bff46";
		
		int templateId = 275243;
		
		String sign = "Garyd公众号";
		
		//要发送的验证码
		Random r = new Random();
		String sms = ""+r.nextInt(10)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10);		
		//将sms验证码存储到session域中
		request.getSession().setAttribute("sms", sms);
		
		String[] params = new String[1];
		params[0] = sms;
		System.out.println("验证码："+sms);
		//通过sender去发送
		SmsSingleSender ssender = new SmsSingleSender(appid,appkey);
		
		//国际号码	电话	短信模板id	验证码  签名
		SmsSingleSenderResult result = ssender.sendWithParam("86", telephone, templateId, params, sign, "", "");
		//System.out.println(result);
		
		//代表页面已经成功了
		response.getWriter().write("{\"success\":"+true+"}");
		
		return null; 
	}
	
}
