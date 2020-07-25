package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.dto.MemberInfo;


public interface MemberService {

	//memberList
	public ArrayList<MemberInfo> memberList();

	//memberInsert
	public void memberInsert(Map pramMap);

	//memberSearch
	public ArrayList<MemberInfo> memberSearch(Map pramMap);
			
}
