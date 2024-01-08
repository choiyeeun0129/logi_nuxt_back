package kr.co.seoulit.erp.account.base.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.base.servicefacade.*;
import kr.co.seoulit.erp.account.base.to.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/base")
public class AccCustomerController {

	//====================================== 2020-09-01 조편백 거래처 관리  컨트롤러 생성 =====================================

	@Autowired
	private AccountServiceFacade accountServiceFacade;

	private ModelMap modelMap = new ModelMap();

	//일반 거래처 조회
	@GetMapping(value="/customers")
	public HashMap<String,Object> getCustomerList() {
		HashMap<String,Object> map=new HashMap<>();
		map.put("accountCustomerList", accountServiceFacade.getCustomerList());

		return map;
	}


	//거래처 삭제
	@RequestMapping(value="/deleteNormalCustormer", method = RequestMethod.DELETE)
	public void deleteNormalCustormer(@RequestParam String customerCode) {

		System.out.println("  ::::::: 일반거래처 삭제   :::::::  "+customerCode);
		System.out.println("되나");
		accountServiceFacade.deleteNormalCustormer(customerCode );
	}

	//거래처 저장
	@RequestMapping(value="/batchCustormerProcess", method = RequestMethod.POST)
	public void batchCustormerProcess(@RequestBody  HashMap<String,ArrayList<CustomerBean>> customerList) {

		// System.out.println("  ::::::: 일반거래처 저장   :::::::  "+customerList);
		accountServiceFacade.batchCustormerProcess(customerList );

	}
	@RequestMapping(value="/saveNewCustomer", method = RequestMethod.POST)
	public void saveNewCustomer(@RequestBody  CustomerBean newCustomer) {

		// System.out.println("  ::::::: 일반거래처 저장   :::::::  "+customerList);
		//accountServiceFacade.batchCustormerProcess(customerList );
		System.out.println("저장: "+newCustomer);

	}
}