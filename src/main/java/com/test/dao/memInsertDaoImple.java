package com.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;
import com.test.dto.MemberInfo;
import com.test.service.memServiceImple;

@Repository
public class memInsertDaoImple implements memInsertDao{

	private static final Logger logger = LoggerFactory.getLogger(memInsertDaoImple.class);

	
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

	@Override
	public MemberInfo detailMem(String selNum) {
		// TODO Auto-generated method stub
		return  (MemberInfo) session.selectOne("memList.memDetail", selNum);
				//session.detailList("memList.memDeail", selNum);
	}

	@Override
	public void deleteMem(ArrayList delArr) {
		// TODO Auto-generated method stub
		logger.info("daoImple:" +delArr);
		session.update("memList.memDelete", delArr);
			
	}

	@Override
	public List searchMem(String searchTxt) {
		// TODO Auto-generated method stub
		return session.selectList("memList.memSearch", searchTxt);
	}
}
