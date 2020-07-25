package com.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;
import com.test.dto.MemberInfo;

@Repository
public class MemberDaoImple implements MemberDao{

	@Inject
	SqlSession session;
	
	@Override
	public ArrayList<MemberInfo> memberList() {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("memList.memberList");
	}

	//memberInsert
	@Override
	public void memberInsert(Map pramMap) {
		// TODO Auto-generated method stub
		session.insert("memList.memberInsert", pramMap);
		
	}

	@Override
	public ArrayList<MemberInfo> memberSearch(Map pramMap) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("memList.memberSearch", pramMap);
	}

}
