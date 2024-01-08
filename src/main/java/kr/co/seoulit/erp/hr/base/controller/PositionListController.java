package kr.co.seoulit.erp.hr.base.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/base/*")
public class PositionListController {
	@Autowired
	private HrBaseServiceFacade baseServiceFacade;
	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();
	
	@RequestMapping("/positionList")
	public Map<String, Object> findPositionList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
	
			   
				ArrayList<BaseSalaryTO> positionList = baseServiceFacade.findPositionList();
				BaseSalaryTO positionTO = new BaseSalaryTO();
				
				map.put("positionList", positionList);
				map.put("emptyPositionBean", positionTO);
				map.put("errorCode",0);
				map.put("errorMsg","success");
			
		
			
			return map;
	}
	
	public ModelAndView modifyPosition(HttpServletRequest request, HttpServletResponse response){
//		String sendData = request.getParameter("sendData");
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			 //간편하고 성능좋은 gson으로 변경 
			
		    //ArrayList<BaseSalaryTO> positionList = gson.fromJson(sendData, new TypeToken<ArrayList<BaseSalaryTO>>(){}.getType());
			
			//baseServiceFacade.modifyPosition(positionList);
			modelMap.put("errorMsg","success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
			modelMap.put("errorCode", -2);
		} 
		modelAndView = new ModelAndView("jsonView", modelMap);
		return modelAndView;
	}	

}
