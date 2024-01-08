package kr.co.seoulit.erp.logistic.purchase.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.logistic.purchase.servicefacade.PurchaseServiceFacade;
import kr.co.seoulit.erp.logistic.purchase.to.OrderDialogTempTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderInfoTO;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/purchase/*", produces = "application/json")
public class OrderController {

	@Autowired
	private PurchaseServiceFacade purchaseSF;

	private ModelMap modelMap = new ModelMap();

	//재고처리/발주필요목록 조회
	@RequestMapping("/getOrderList")
	public HashMap<String, Object> getOrderList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> resultMap = new HashMap<>();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		try {
			resultMap = purchaseSF.getOrderList(startDate, endDate);
			System.out.println("접근!!" + resultMap);
		} catch (Exception e2) {

			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

		return resultMap;

	}

	//모의재고처리 및 취합발주
	@RequestMapping("/showOrderDialog")
	public HashMap<String, Object> openOrderDialog(@RequestParam ArrayList<String> mrpNoList) {
		System.out.println("mrpGatheringNoListStr:" + mrpNoList);
//		String mrpGatheringNoListStr = request.getParameter("mrpGatheringNoList");
//		ArrayList<String> mrpGatheringNoListArr = gson.fromJson(mrpGatheringNoListStr, new TypeToken<ArrayList<String>>() {
//		}.getType());
		System.out.println("오잉");
		HashMap<String, Object> resultMap = new HashMap<>();

		try {

			resultMap = purchaseSF.getOrderDialogInfo(mrpNoList);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

		return resultMap;

	}

	//발주현황조회
	@RequestMapping("/showOrderInfo")
	public ModelMap showOrderInfo(HttpServletRequest request, HttpServletResponse response) {

		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try {

			ArrayList<OrderInfoTO> orderInfoList = purchaseSF.getOrderInfoList(startDate, endDate);
			modelMap.put("gridRowJson", orderInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "�꽦怨�");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	//오늘날짜로 입고
	@RequestMapping("/searchOrderInfoListOnDelivery")
	public ModelMap searchOrderInfoListOnDelivery(HttpServletRequest request, HttpServletResponse response) {

		try {

			ArrayList<OrderInfoTO> orderInfoListOnDelivery = purchaseSF.getOrderInfoListOnDelivery();
			modelMap.put("gridRowJson", orderInfoListOnDelivery);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "�꽦怨�");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	@RequestMapping(value = "/updateOrderInfo", method = RequestMethod.POST)
	public ModelMap updateOrderInfo(@RequestBody HashMap<String, ArrayList<OrderInfoTO>> map) {
		ArrayList<OrderInfoTO> list = map.get("orderUpdate");

		try {
			purchaseSF.updateOrderInfo(list);

			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "�꽦怨�");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}


	//현재 전개된 결과 발주 및 재고처리
	@RequestMapping("/order")
	public HashMap<String, Object> order(@RequestParam ArrayList<String> mrpGatheringNoList) {

		HashMap<String, Object> resultMap = new HashMap<>();

		try {

			resultMap = purchaseSF.order(mrpGatheringNoList);
			System.out.println(resultMap);
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

		return resultMap;
	}

	//임의발주
	@RequestMapping("/optionOrder")
	public HashMap<String, Object> optionOrder(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, Object> resultMap = new HashMap<>();

		try {

			String itemCode = request.getParameter("itemCode");
			String itemAmount = request.getParameter("itemAmount");

			resultMap = purchaseSF.optionOrder(itemCode, itemAmount);
			System.out.println(resultMap);
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}

		return resultMap;

	}


	//
	@RequestMapping("/getOrderDialog")
	public ModelMap getOrderDialog(HttpServletRequest request, HttpServletResponse response) {

		try {
			ArrayList<OrderDialogTempTO> orderDialogTempTOList = purchaseSF.getOrderDialog();
			System.out.println("접근!!" + orderDialogTempTOList);

			modelMap.put("gridRowJson", orderDialogTempTOList);
		} catch (Exception e2) {

			e2.printStackTrace();

		}

		return modelMap;
	}
}
