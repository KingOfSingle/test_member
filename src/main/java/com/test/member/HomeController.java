package com.test.member;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.dto.MemberInfo;
import com.test.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		ArrayList<MemberInfo> memList = memberService.memberList();
		
		/*
		 * for(int i=0; i<memList.size(); i++) { 
		 * 		Map map = (Map)memList.get(i);
		 * 
		 * 		int num = (Integer) map.get("num"); 
		 * 		String name = (String)map.get("name");
		 * 		String level = (String)map.get("level");
		 * 
		 * 		logger.debug("fjefi: " +num +" " +name +" " +level); }
		 * 
		 * 		logger.debug("mapsize: " +memList.size());
		 */
		
		model.addAttribute("memList", memList);
		
		return "test1";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Locale locale) {
		
		return "insert";
	}
	
	@RequestMapping(value = "/newmem", method = RequestMethod.POST)
	public String newmem(Locale locale, HttpServletRequest request) {
		
		//getParameter id 아닌 name으로 값 넘김
		String memName = request.getParameter("memName");
		String memLevel = request.getParameter("memLevel");
		String memDept = request.getParameter("memDept");
		
		System.out.println("Controller: " 
							+"memName: " +memName +" " 
							+"memLevel: " +memLevel +" " 
							+"memDept: " +memDept);
		
		Map pramMap = new HashMap();
		pramMap.put("memName", memName);
		pramMap.put("memLevel", memLevel);
		pramMap.put("memDept", memDept);
		
		memberService.memberInsert(pramMap);
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(Locale locale, HttpServletRequest request, ModelAndView model) {
		
		//getParameter id 아닌 name으로 값 넘김
		String searchT = request.getParameter("searchT");
		String selectP = request.getParameter("selectP");

		System.out.println("Controller: " 
							+"searchT: " +searchT +" " 
							+"selectP: " +selectP);
		
		Map pramMap = new HashMap();
		pramMap.put("searchT", searchT);
		pramMap.put("selectP", selectP);
		
		ArrayList<MemberInfo> memList = memberService.memberSearch(pramMap);
		
		model.addObject("memList", memList);
		model.setViewName("test1");
		
		return model;
	}
	
	
}
