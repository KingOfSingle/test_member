package com.test.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.dao.memInsertDao;

@Service
public class memServiceImple implements memService{

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

}
