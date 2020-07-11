package com.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.dto.MemberInfo;

public interface memInsertDao {
	
	//member insert
	public void insertMem(Map paramMap);

	//member select
	public List selectMem();

	//member detail
	public MemberInfo detailMem(String selNum);
	
	//member delete
	public void deleteMem(ArrayList delArr);

	//member search
	public List searchMem(String searchTxt);
	
}
