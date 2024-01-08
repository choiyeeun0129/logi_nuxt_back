package kr.co.seoulit.erp.account.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.account.base.to.LedgerByAccountBean;
import kr.co.seoulit.erp.account.slip.to.GeneralAccountLedgerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.base.servicefacade.AccountServiceFacade;
import kr.co.seoulit.erp.account.base.to.AccountBean;
import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.base.to.PeriodBean;


@CrossOrigin("*")
@RestController
@RequestMapping("/acc/base")
public class 	AccountController {
	@Autowired
	private AccountServiceFacade accountServiceFacade;


	//민상

	//총계정원장
	@GetMapping("/accounts")
	public ResponseEntity<ArrayList<GeneralAccountLedgerBean>> findGeneralAccountLedgerList(@RequestParam("startDate") String fromDate,
																							@RequestParam("endDate") String toDate) {

		ArrayList<GeneralAccountLedgerBean> generalAccountLedgerList = accountServiceFacade.findGeneralAccountLedgerList(fromDate, toDate);
		if(generalAccountLedgerList.size()==0){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(generalAccountLedgerList);
	}


	//계정별원장조회
	@GetMapping( "/accounts/{accountCode}")
	public ResponseEntity<HashMap<String, Object>> getLedgerbyAccountInfo(@PathVariable String accountCode,
																		  @RequestParam("startDate") String startDate
			, @RequestParam("endDate") String endDate) {

		HashMap<String, Object> param = new HashMap<>();


		HashMap<String, Object> resultMap = accountServiceFacade.getLedgerbyAccountInfo(accountCode, startDate, endDate);

		List<LedgerByAccountBean> ledgerList= (List<LedgerByAccountBean>) resultMap.get("RESULT");
		if(ledgerList.size()==0){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(param);
		}
		param.put("accountLederList", ledgerList);
		return ResponseEntity.ok(param);

	}

	//계정코드 전체조회
	@GetMapping( "/accountCodes")
	public HashMap<String, Object> getAccountList() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("accoundCodeList", accountServiceFacade.getAccountList());
		return map;
	}

	//계정코드조회
	@GetMapping("/accountCodes/{accountCode}")
	public HashMap<String,Object> getAccount(@PathVariable("accountCode") String accountCode,
											 @RequestParam String accountName) {
		HashMap<String, Object> map = new HashMap<>();

		map.put("accoundCodeList",accountServiceFacade.getAccount(accountCode, accountName));

		return map;

	}

	//계정과목관리 삭제
	@DeleteMapping("/accountCodes/{accountInnerCode}")
	public ResponseEntity<HashMap<String,Object>> deleteAccountList(@PathVariable("accountInnerCode") String accountInnerCode) {
		HashMap<String,Object> map=new HashMap<>();
		try {
			accountServiceFacade.deleteAccountList(accountInnerCode);
			map.put("updateCodeNo", accountInnerCode);

			return ResponseEntity.ok(map);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// 계정과목관리 저장
	@PostMapping("/accountCodes")
	public ResponseEntity<HashMap<String,Object>> batchAccountList(@RequestBody AccountBean accountBean) {

		HashMap<String,Object> map=new HashMap<>();
		try{
			accountServiceFacade.registerAccountCode(accountBean);
			map.put("errorMsg","등록에 성공하셨습니다");
			return  ResponseEntity.ok(map);
		}catch(Exception ex){
			map.put("errorMsg","에러가 발생하였습니다");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}

	}




	// ===========================================2020-09-19 조편백 코드 조회 끝
	// =============================================

	@RequestMapping(value = "/account/getAccountListByName")
	public HashMap<String, Object> getAccountListByName(@RequestParam("accountName") String accountName) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<AccountBean> accountBean = accountServiceFacade.getAccountListByName(accountName);
			map.put("accountList", accountBean);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/account/findParentAccountList", method = RequestMethod.GET)
	public HashMap<String, Object> findParentAccountList() {
		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<AccountBean> accountBean = accountServiceFacade.findParentAccountList();
			map.put("accountList", accountBean);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/account/findDetailAccountList", method = RequestMethod.GET)
	public HashMap<String, Object> findDetailAccountList(@RequestParam("code") String code) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<AccountBean> accountBean = accountServiceFacade.findDetailAccountList(code);
			map.put("detailAccountList", accountBean);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");
			System.out.println(accountBean.get(1));

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/account/editAccount", method = RequestMethod.PUT)
	public void editAccount(@RequestParam HashMap<String, Object> param) {
		AccountBean accountBean = new AccountBean();
		accountBean.setAccountInnerCode((String) param.get("accountInnerCode"));
		accountBean.setAccountName((String) param.get("accountName"));
		accountServiceFacade.updateAccount(accountBean);
	}

	@RequestMapping(value = "/account/findPeriodNo")
	public String findPeriodNo(@RequestParam String toDay) {

		String periodNo = accountServiceFacade.findPeriodNo(toDay);
		return periodNo;
	}
	// ===================================== 2020-08-25 계정별 원장 조편백 시작
	// ====================================


	// ===================================== 2020-08-25 계정별 원장 조편백 끝
	// ====================================

	@RequestMapping(value = "/account/findDetailBudgetList")
	public HashMap<String, Object> findDetailBudgetList(@RequestParam("budgetCode") String code) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<AccountBean> budgetList = accountServiceFacade.findDetailBudgetList(code);
			map.put("detailBudgetList", budgetList);
			map.put("errorCode", 0);
			map.put("errorMsg", "조회완료");

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/account/findParentBudgetList")
	public HashMap<String, Object> findParentBudgetList() {
		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<AccountBean> parentBudgetList = accountServiceFacade.findParentBudgetList();
			map.put("parentBudgetList", parentBudgetList);
			map.put("errorCode", 0);
			map.put("errorMsg", "조회완료");

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/account/findAccountPeriodList")
	public HashMap<String, Object> findAccountPeriodList() {
		HashMap<String, Object> map = new HashMap<>();
		try {
			ArrayList<PeriodBean> accountPeriodList = accountServiceFacade.findAccountPeriodList();
			map.put("accountPeriodList", accountPeriodList);
			map.put("errorCode", 0);
			map.put("errorMsg", "조회완료");

		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;
	}

	//=====================================  2020-11-28 계정과목관리 유길현 시작  ==================================


	//=====================================  2020-11-28 계정과목관리 유길현 시작  ==================================
}