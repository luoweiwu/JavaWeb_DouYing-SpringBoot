package com.Gary.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.Gary.domain.Lfile;
import com.Gary.service.FileService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport{

	//上传的文件
	private File upload;
	//文件的类型
	private String uploadContentType;
	//文件的名称
	private String uploadFileName;
	
	private FileService fileService;
	
	private String test;
	
	public String fileTestAjax() throws Exception{
		
		System.out.println(upload);
		System.out.println(uploadContentType);
		System.out.println(uploadFileName);
		
		//保存到数据库
		
		//文件保存到项目
		//文件保存位置
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		//创建一个file文件
		File file = new File(path);
		//路径如果不存在，要手动make一下
		if(!file.exists())
		{
			file.mkdir();
		}
		//文件拷贝的格式
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		System.out.println(path);
		
		//保存到数据库
		Lfile lfile = new Lfile();
		lfile.setFilename(uploadFileName);
		lfile.setFiletype(uploadContentType);
		lfile.setUrl(path+"\\"+uploadFileName);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		String createtime = format.format(date);
		
		lfile.setCreatetime(createtime);
		
		//判断数据库中是否存在相同名字的文件
		boolean success =fileService.JudgeLfilename(uploadFileName);
		//如果有相同的filename我们就不进行插入
		if(success) {
			fileService.addFile(lfile);
		}
		
		ServletActionContext.getResponse().getWriter().write("{\"success\":"+true+"}");
		return null;
	}
	
	
	public String fileTest() throws Exception{
		System.out.println(upload);
		System.out.println(uploadContentType);
		System.out.println(uploadFileName);
		
		
		return "index";
	}
	
	//带参数的ajax跨域炒作
	public String ajax() throws Exception{
		
		System.out.println(test);
		
		ServletActionContext.getResponse().getWriter().write("{\"success\":"+true+"}");
		return null;
	}
	

	//实现跨域请求  是否可以调用这个函数
	public String test() throws Exception
	{
		System.out.println("跨域请求！！");
		System.out.println(test);
		return "index";
	}
	
	//查找所有的文件
	public String getData() throws Exception {
	
		List<Lfile> list =  fileService.findAllLfile();
		
		ActionContext.getContext().put("list", list);
		
		return "index";
	
	}
	
	
	public String addFile() throws Exception {
		
//		System.out.println(upload);
//		System.out.println(uploadContentType);
//		System.out.println(uploadFileName);
		
		//保存到数据库
		
		//文件保存到项目
		//文件保存位置
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		//创建一个file文件
		File file = new File(path);
		//路径如果不存在，要手动make一下
		if(!file.exists())
		{
			file.mkdir();
		}
		//文件拷贝的格式
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		System.out.println(path);
		
		//保存到数据库
		Lfile lfile = new Lfile();
		lfile.setFilename(uploadFileName);
		lfile.setFiletype(uploadContentType);
		lfile.setUrl(path+"\\"+uploadFileName);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		String createtime = format.format(date);
		
		lfile.setCreatetime(createtime);
		
		//判断数据库中是否存在相同名字的文件
		boolean success =fileService.JudgeLfilename(uploadFileName);
		//如果有相同的filename我们就不进行插入
		if(success) {
			fileService.addFile(lfile);
		}
		
		
		return "default";
	}

	
	public FileService getFileService() {
		return fileService;
	}


	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
