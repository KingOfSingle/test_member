package com.test.member;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.dto.MemberInfo;
import com.test.service.memService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	memService service2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List memList = service2.selectMem();
		
		for(int i=0; i<memList.size(); i++) {
			Map map = (Map)memList.get(i);
			
			int num = (Integer) map.get("num");
			String name = (String)map.get("name");
			String level = (String)map.get("level");
			
			logger.debug("fjefi: " +num +" " +name +" " +level);
		}
		
		logger.debug("mapsize: " +memList.size());
		
		model.addAttribute("memList", memList);
		
		return "test1";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {
		
		
		return "insert";
	}
	
	@RequestMapping(value = "/newmem", method = RequestMethod.POST)
	public String newMem(HttpServletRequest request) {
		
		logger.info("fejiteseji");
		
		String memNm = request.getParameter("memNm");
		String memLev = request.getParameter("memLev");
		String memDept = request.getParameter("memDept");
		
		logger.info("fefefw" +memNm);
		logger.info(memLev);
		logger.info(memDept);
		
		Map paramMap = new HashMap();
		paramMap.put("memNm", memNm);
		paramMap.put("memLev", memLev);
		paramMap.put("memDept", memDept);
		
		service2.insertMem(paramMap);		
		
		return "test1";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String detail(HttpServletRequest request, Model model) {
		
		String selNum = request.getParameter("selNum");
		
		
		MemberInfo memberInfo = service2.detailMem(selNum);
		
		logger.info("testesttest: "+memberInfo.getDept());
		
		
		model.addAttribute("memberInfo", memberInfo);
		
		return "detail";
	}
	
	@RequestMapping(value = "/deleteMem", method = RequestMethod.POST)
	public String deleteMem(HttpServletRequest request) {
		
		String delNum = request.getParameter("delNumArr");
		String subNum = delNum.substring(1);
		String[] splNum = subNum.split(","); //splNum[i] = i
		
		ArrayList delArr = new ArrayList(Arrays.asList(splNum));
		
		service2.deleteMem(delArr);
		
		logger.info("delNum: " +delArr);
		
		
		return "redirect:";
	}
	
}
