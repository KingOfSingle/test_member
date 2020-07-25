package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.dao.MemberDao;
import com.test.dto.MemberInfo;

@Service
public class MemberServiseImple implements MemberService {

	@Inject
	MemberDao memberDao;
	
	@Override
	public ArrayList<MemberInfo> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}

	
	//memberInsert
	@Override
	public void memberInsert(Map pramMap) {
		// TODO Auto-generated method stub
		memberDao.memberInsert(pramMap);
	}


	@Override
	public ArrayList<MemberInfo> memberSearch(Map pramMap) {
		// TODO Auto-generated method stub
		return memberDao.memberSearch(pramMap);
	}

}
