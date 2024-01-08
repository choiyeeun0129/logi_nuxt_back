package kr.co.seoulit.erp.logistic.purchase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.purchase.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.logistic.purchase.servicefacade.PurchaseServiceFacade;
import kr.co.seoulit.erp.logistic.purchase.to.StockLogTO;
import kr.co.seoulit.erp.logistic.purchase.to.StockTO;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/purchase/*", produces = "application/json")

public class StockController {

	@Autowired
	private PurchaseServiceFacade purchaseSF;

	private ModelMap modelMap = new ModelMap();

	//재고목록 조회
	@RequestMapping("/searchStockList")
	public ModelMap searchStockList(HttpServletRequest request, HttpServletResponse response) {

		try {

			ArrayList<StockTO> stockList = purchaseSF.getStockList();

			modelMap.put("gridRowJson", stockList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	//재고 로그 목록 조회
	@RequestMapping("/searchStockLogList")
	public ModelMap searchStockLogList(HttpServletRequest request, HttpServletResponse response) {

		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		try {

			ArrayList<StockLogTO> stockLogList = purchaseSF.getStockLogList(startDate, endDate);

			modelMap.put("gridRowJson", stockLogList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	//현재 체크된 발주품목 입고
	@RequestMapping("/warehousing")
	public HashMap<String, Object> warehousing(@RequestParam ArrayList<String> orderNoList) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap = purchaseSF.warehousing(orderNoList);
			System.out.println(resultMap);
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

		return resultMap;
	}

	//현재 체크된 발주품목 원재료 검사
	@RequestMapping(method = RequestMethod.PUT, value = "/inspection")
	public void inspection(@RequestBody Map<String, Object> params) {

		System.out.println(params.get("sendData"));

		purchaseSF.inspection(params.get("sendData").toString());

	}

	//230403 추가
	//창고관리-창고상세조회
	@RequestMapping(value="/warehouseStockList" , method=RequestMethod.GET)
	public ModelMap searchWarehouseStockList(@RequestParam String warehouseCode) {
//      String warehouseCode  = request.getParameter("warehouseCode");
		modelMap = new ModelMap();
		System.out.println("warehouseCode:::");
		System.out.println(warehouseCode);

		try {
			ArrayList<StockTO> stockList = purchaseSF.getWarehouseStockList(warehouseCode);
			System.out.println("stockList:::"+stockList);

			modelMap.put("gridRowJson", stockList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}
		return modelMap;
	}


}
