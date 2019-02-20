package com.Gary.service;

import java.util.List;

import com.Gary.dao.FileDao;
import com.Gary.domain.Lfile;

public class FileService {

	private FileDao fileDao;
	
	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public void addFile(Lfile lfile) {
		fileDao.addFile(lfile);
		
	}

	public List<Lfile> findAllLfile() {
		
		return fileDao.findAllLfile();
	}

	//判断是否有相同同名的文件
	public boolean JudgeLfilename(String uploadFileName) {
		int num = fileDao.JudgeLfilename(uploadFileName);
		//如果num>0证明数据库中存在相同的文件名称
		if(num>0)
		{
			return false;
		}else {
			return true;
		}

	}

}
