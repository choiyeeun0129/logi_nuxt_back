package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

@CrossOrigin("*")
@RequestMapping("/hr/salary/*")
@RestController
public class SocialInsureController {
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	HashMap<String, Object> map = new HashMap<>();

	@RequestMapping(value = "/socialInsure", method = RequestMethod.GET)
	public HashMap<String, Object> findBaseInsureList(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		String searchYear = request.getParameter("searchYear");

		try {
			ArrayList<SocialInsureTO> baseInsureList = salaryServiceFacade.findBaseInsureList(searchYear);
			map.clear();
			map.put("baseInsureList", baseInsureList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
}
