package com.test.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;

@Repository
public class memInsertDaoImple implements memInsertDao{

	@Inject
	SqlSession session;
	
	@Override
	public void insertMem(Map paramMap) {
		// TODO Auto-generated method stub
		session.insert("memList.memInsert", paramMap);
	}

	@Override
	public List selectMem() {
		// TODO Auto-generated method stub
		return session.selectList("memList.memSelect");
	}
}
