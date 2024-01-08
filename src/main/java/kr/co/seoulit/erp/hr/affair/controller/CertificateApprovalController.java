package kr.co.seoulit.erp.hr.affair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import kr.co.seoulit.erp.hr.affair.servicefacade.CertificateServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.CertificateTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/certificate/*")
public class CertificateApprovalController {
	
	@Autowired
	private CertificateServiceFacade certificateServiceFacade;
	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();

	@GetMapping("/findCertificateListByDept")
	public ModelMap findCertificateListByDept(@RequestParam String deptName, @RequestParam String startDate,
			@RequestParam String endDate) {
		System.out.println(deptName);
		System.out.println(startDate);
		System.out.println(endDate);

		try {

			ArrayList<CertificateTO> certificateList = certificateServiceFacade.findCertificateListByDept(deptName,
					startDate, endDate);
			modelMap.put("certificateList", certificateList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}

		return modelMap;
	}

	@PostMapping("/modifyCertificateList")
	public ModelMap modifyCertificateList(@RequestBody HashMap<String, Object> checkData) {
		System.out.println("호출");
		String deptName = (String) checkData.get("deptName");
		String startDate = (String) checkData.get("startDate");
		String endDate = (String) checkData.get("endDate");
		System.out.println(deptName);
		System.out.println(startDate);
		System.out.println(endDate);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 파라미터Map에서 TO에 들어있지 않는 변수가 있어도
																					// 무시함.
		ArrayList<CertificateTO> certificateTO = mapper.convertValue(checkData.get("checkData"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, CertificateTO.class));

		System.out.println(certificateTO);

		try {

			ArrayList<CertificateTO> certificatelist = certificateServiceFacade.modifyCertificateList(certificateTO,
					deptName, startDate, endDate);
			modelMap.put("certificateList", certificatelist);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}

		return modelMap;
	}
}
