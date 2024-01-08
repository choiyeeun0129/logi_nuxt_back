package kr.co.seoulit.erp.hr.base.controller;


import java.util.ArrayList;
import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;
import kr.co.seoulit.erp.hr.base.to.HrCodeTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/base/*")
public class HrCodeListController{
	@Autowired
	private  HrBaseServiceFacade baseServiceFacade;

	//
	@RequestMapping(value="/detailCodeList", method=RequestMethod.GET)
	public ArrayList<HrDetailCodeTO> detailCodelist(@RequestParam("code") String code, Model model) {
		return baseServiceFacade.findDetailCodeList(code);
	}
	//@RequestMapping(value="/base/detailCodeListRest", method=RequestMethod.GET)
	@GetMapping("/detailCodeListRest")
	public ArrayList<HrDetailCodeTO> detailCodelistRest(@RequestParam("code1") String code1, @RequestParam("code2") String code2, @RequestParam("code3") String code3, Model model) {
		return baseServiceFacade.findDetailCodeListRest(code1,code2,code3);
	}
	
	@RequestMapping(value="/codeList", method=RequestMethod.GET)
	public ArrayList<HrCodeTO> codelist(){
		return baseServiceFacade.findCodeList();
	}
}


