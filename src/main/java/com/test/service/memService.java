package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.dto.MemberInfo;

public interface memService {
	
	//insert member
	public void insertMem(Map paramMap);
	
	//select member
	public List selectMem();
	
	//detail member
	public MemberInfo detailMem(String selNum);
	
	//delete member
	public void deleteMem(ArrayList delArr);

}
