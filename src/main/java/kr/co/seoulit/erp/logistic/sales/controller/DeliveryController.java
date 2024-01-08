package kr.co.seoulit.erp.logistic.sales.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.ContractInfoTO;
import kr.co.seoulit.erp.logistic.sales.to.DeliveryInfoTO;

@Api(value = "납품관리")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/sales/*", produces = "application/json")
public class DeliveryController {

	@Autowired
	private SalesServiceFacade salesSF;

	private ModelMap modelMap = new ModelMap();


	@RequestMapping("/searchDeliveryInfoList")
	public ModelMap searchDeliveryInfoList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {

			ArrayList<DeliveryInfoTO> deliveryInfoList = salesSF.getDeliveryInfoList();

			modelMap.put("gridRowJson", deliveryInfoList);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	// batchListProcess

	public ModelMap batchListProcess(HttpServletRequest request, HttpServletResponse response) {

//		String batchList = request.getParameter("batchList");

		try {

//			List<DeliveryInfoTO> deliveryTOList = gson.fromJson(batchList, new TypeToken<ArrayList<DeliveryInfoTO>>() {
//			}.getType());

//			HashMap<String, Object> resultMap = salesSF.batchDeliveryListProcess(deliveryTOList);
//
//			modelMap.put("result", resultMap);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	@ApiOperation(value = "납품 관리 검색")
	@RequestMapping("/searchDeliverableContractList")
	public ModelMap searchDeliverableContractList(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String searchCondition, @RequestParam String customerCode) {

		try {

			ArrayList<ContractInfoTO> deliverableContractList = null;

			if (searchCondition.equals("searchByDate")) {

				String[] paramArray = { startDate, endDate };
				deliverableContractList = salesSF.getDeliverableContractList("searchByDate", paramArray);

			} else if (searchCondition.equals("searchByCustomer")) {

				String[] paramArray = { customerCode };
				deliverableContractList = salesSF.getDeliverableContractList("searchByCustomer", paramArray);

			}

			modelMap.put("gridRowJson", deliverableContractList);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}


	/********************* 납품 2020-12-03 이숭규 **********************/

	@ApiOperation(value="납품")
	@RequestMapping(value = "delivery",method = RequestMethod.POST)
	public HashMap<String, String> deliver(@RequestBody DeliveryInfoTO contractDetailNo) {
		System.out.println("들어온 파라메터"+contractDetailNo.getContractDetailNo());

		HashMap<String, Object> resultMap = new HashMap<>(); // object 그대로 받으면 한글 깨짐

		HashMap<String, String> resultMap2 = new HashMap<>();
		try {

			resultMap = salesSF.deliver(contractDetailNo.getContractDetailNo());

			resultMap2.put("errorCode", resultMap.get("errorCode") + "");
			resultMap2.put("errorMsg", (String) resultMap.get("errorMsg"));

		} catch (Exception e2) {
			e2.printStackTrace();

			resultMap2.put("errorCode", "-2");
			resultMap2.put("errorMsg", e2.getMessage());

		}

		return resultMap2;
	}

	// ==========================================박미노=====================================
	@RequestMapping("/deliverDivisionUpdate")
	public void deliverDivisionUpdate(@RequestBody Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate) {

		HashMap<String, Object> resultMap = new HashMap<>();

		System.out.println("de@@@@@@@liverUpdate+deliverUpdate::::" + deliverUpdate);

		try {
			salesSF.deliverUpdate(deliverUpdate);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

	}
}
