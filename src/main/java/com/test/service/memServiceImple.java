package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.dao.memInsertDao;
import com.test.dto.MemberInfo;
import com.test.member.HomeController;

@Service
public class memServiceImple implements memService{

	private static final Logger logger = LoggerFactory.getLogger(memServiceImple.class);
	
	@Inject
	memInsertDao meminsertdao;
	
	@Override
	public void insertMem(Map paramMap) {
		// TODO Auto-generated method stub
		meminsertdao.insertMem(paramMap);
	}

	@Override
	public List selectMem() {
		// TODO Auto-generated method stub
		return meminsertdao.selectMem();
	}

	@Override
	public MemberInfo detailMem(String selNum) {
		// TODO Auto-generated method stub
		return meminsertdao.detailMem(selNum);
	}

	@Override
	public void deleteMem(ArrayList delArr) {
		// TODO Auto-generated method stub
		logger.info("serviceImple:" +delArr);
		meminsertdao.deleteMem(delArr);
	}
	

}
