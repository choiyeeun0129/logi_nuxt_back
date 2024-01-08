package kr.co.seoulit.erp.hr.affair.controller;

import java.util.ArrayList;

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

import kr.co.seoulit.erp.hr.affair.servicefacade.CertificateServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.CertificateTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/certificate/*")
public class CertificateController {
	
	@Autowired
	private CertificateServiceFacade certificateServiceFacade;
	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();

	@PostMapping("/insertCertificateRequest")
	public ModelMap registRequest(@RequestBody CertificateTO certificate) {
		try {
			System.out.println(certificate);
			certificateServiceFacade.registRequest(certificate);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}

	@GetMapping("/selectCertificateList")
	public ModelMap findCertificateList(@RequestParam String empCode, @RequestParam String startDate,
			@RequestParam String endDate) {
		System.out.println("재직증명서 조회 컨트롤러 진입 : " + startDate + endDate + empCode);

		try {
			ArrayList<CertificateTO> certificateList = certificateServiceFacade.findCertificateList(empCode, startDate,
					endDate);
			modelMap.put("certificateList", certificateList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}

	@PostMapping("/deleteCertificate")
	public ModelMap removeCertificateRequest(@RequestBody ArrayList<CertificateTO> certificateList) {

		try {
			System.out.println("try진입 데이터 : " + certificateList);
			certificateServiceFacade.removeCertificateRequest(certificateList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;

	}
}
