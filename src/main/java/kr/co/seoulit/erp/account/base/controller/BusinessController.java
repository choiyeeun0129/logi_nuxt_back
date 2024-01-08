package kr.co.seoulit.erp.account.base.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.base.servicefacade.*;
import kr.co.seoulit.erp.account.base.to.*;

@CrossOrigin("*")
@Controller
@RequestMapping("/acc/*")
public class BusinessController  {

	@Autowired
	private BusinessServiceFacade businessServiceFacade;
	
    @RequestMapping(value="/company/getBusinessList", method=RequestMethod.GET)
	public ArrayList<BusinessBean> getBusinessList(HttpServletRequest request, HttpServletResponse response) {

		return businessServiceFacade.getBusinessList();	

	}
	
    @RequestMapping(value="/company/getDetailBusiness", method=RequestMethod.GET)
	public ArrayList<DetailBusinessBean> getDetailBusiness(@RequestParam("businessCode")String businessCode) {

			//modelAndView.addObject("detailBusinessList",detailBusinessList);
			//modelAndView.addObject("errorCode", 0);
			
			return businessServiceFacade.getDetailBusiness(businessCode);
	}

}
