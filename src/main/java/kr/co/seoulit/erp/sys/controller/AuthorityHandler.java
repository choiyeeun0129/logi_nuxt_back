package kr.co.seoulit.erp.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.sys.serviceFacade.BaseServiceFacade;
import kr.co.seoulit.erp.sys.to.AuthorityTo;

@RestController
public class AuthorityHandler {

	@Autowired
	BaseServiceFacade baseServiceFacade;

	@RequestMapping("/sys/findAuthorityList")
	public List<AuthorityTo> findAuthorityList() {
		return baseServiceFacade.findAuthorityList();
	}

	// 받는 변수는 authorityCode를 map으로 받을거임
	@RequestMapping("/sys/findMenuAuthorityList")
	public List<AuthorityTo> findMenuAuthorityList(Map<String, Object> data) {
		return baseServiceFacade.findMenuAuthorityList(data);
	}
}