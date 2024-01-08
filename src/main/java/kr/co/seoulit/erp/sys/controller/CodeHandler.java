package kr.co.seoulit.erp.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.sys.serviceFacade.BaseServiceFacade;
import kr.co.seoulit.erp.sys.to.SysCodeDetailTo;
import kr.co.seoulit.erp.sys.to.SysCodeTo;

@RestController
public class CodeHandler {

	@Autowired
	BaseServiceFacade baseServiceFacade;

	@CrossOrigin("*")
	@RequestMapping("/sys/findCodeList")
	public List<SysCodeTo> findCodeList() {
		return baseServiceFacade.findCodeList();
	};

//	@RequestMapping("/sys/findCodeDetailList")
//	public List<CodeDetailTo> findCodeDetailList(){
//		return baseServiceFacade.findCodeDetailList();
//	}

}
