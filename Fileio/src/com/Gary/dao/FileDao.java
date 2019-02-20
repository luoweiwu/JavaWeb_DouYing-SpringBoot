package com.Gary.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.Gary.domain.Lfile;

public class FileDao extends HibernateDaoSupport{

	public void addFile(Lfile lfile) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(lfile);
	}

	public List<Lfile> findAllLfile() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from lfile";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Lfile.class);
		List<Lfile> list = query.list();
		
		return list;
	}

	public int JudgeLfilename(String uploadFileName) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select count(*) from lfile where filename = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, uploadFileName);
		BigInteger result = (BigInteger) query.uniqueResult();
		
		return result.intValue();
	}


}
