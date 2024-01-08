package kr.co.seoulit.erp.logistic.production.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.seoulit.erp.logistic.production.domain.SalesPlan;

import kr.co.seoulit.erp.logistic.production.servicefacade.MpsServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;

@Api(description = "주생산계획(MPS)")
@SuppressWarnings("unused")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class MpsController {

	/**
	 * 75기 23.5.10. ~  1차 프로젝트
	 * MPS/MRP 분리, 필드 주입 대신 생성자 주입
	 * HttpServlet 제거, 스파게티 소스 의존성 제거, Controller에서의 비즈니스 로직 제거, ApplicationService 제거
	 * JSON Type 응답, salesPlan : JPA 적용
	 */

	private final MpsServiceFacade mpsSF;
	private final ModelMap modelMap = new ModelMap();

	@Autowired
	public MpsController(MpsServiceFacade mpsSF) {
		this.mpsSF = mpsSF;
	}


	/*****************************
		 MPS 등록가능 수주 조회
	 *****************************/
	@ApiOperation(value = "MPS 등록가능 수주 조회")
	@RequestMapping("/searchContractDetailInMpsAvailable")
	@ResponseBody
	public Map<String, Object> searchContractDetailListInMpsAvailable(@RequestParam String startDate,
																	  @RequestParam String endDate,
																	  @RequestParam String searchCondition) {

		Map<String, Object> result = mpsSF.getContractDetailListInMpsAvailable(searchCondition, startDate, endDate);


		return result;
	}

	/*****************************
	  MPS 등록가능 판매계획 조회(JPA)
	 *****************************/
	@ApiOperation(value = "MPS 등록가능 판매계획 조회(JPA)")
	@RequestMapping(value = "/searchSalesPlan", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SalesPlan>> searchSalesPlan(@RequestParam String startDate,
														   @RequestParam String endDate
														   ) {
		List<SalesPlan> salesPlans = mpsSF.searchSalesPlan(startDate, endDate);
		return new ResponseEntity<>(salesPlans, HttpStatus.OK);
	}


	/*****************************
	 			MPS 등록
	 *****************************/
	@ApiOperation(value = "MPS 등록")
	@RequestMapping(value = "/convertContractDetailToMps", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> convertContractDetailToMps(@RequestBody ContractDetailInMpsAvailableTO contract) {

		HashMap<String, Object> resultMap = mpsSF.convertContractDetailToMps(contract);

		return resultMap;
	}
	@RequestMapping(value = "/convertSalesPlanToMps", method = RequestMethod.POST)
	@ResponseBody
	public void convertSalesPlanToMps(@RequestBody SalesPlan salesPlan) {
		mpsSF.convertSalesPlanToMps(salesPlan);
	}


	/*****************************
	 차트용 MPS 테이블 조회
	 *****************************/
	@ApiOperation(value = "차트용 MPS 테이블 조회")
	@RequestMapping(value = "/searchMpsList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> searchMpsList() {
		HashMap<String, Object> resultMap = mpsSF.searchMpsList();
		return resultMap;
	}

}

