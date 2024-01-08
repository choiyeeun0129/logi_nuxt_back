package kr.co.seoulit.erp.logistic.transport.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.company.to.DepartmentTO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.transport.servicefacade.TransportServiceFacade;
import kr.co.seoulit.erp.logistic.transport.to.TransportTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/logi/transport")
public class TransportController {
	@Autowired
	private TransportServiceFacade transportServiceFacade;
	private ModelMap modelMap = new ModelMap();
	
	@RequestMapping("/searchTransportList")
	public ModelMap searchTransportListInfo(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("sdsdsdsdsd");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		System.out.println("!!!!!!!!!!!!!!!!" + startDate);
		System.out.println("@@@@@@@@@@@@@@@@" +  endDate);

		try {
			ArrayList<TransportTO> TransportTOList = transportServiceFacade.searchTransportList(startDate, endDate);

			modelMap.put("gridRowJson", TransportTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return modelMap;
	}
	

	@GetMapping("/getCommercialVehicleList")
	public ModelMap searchCommercialVehicleList(HttpServletResponse response) {

		ArrayList<TransportTO> transportList = null;

		try {	
			transportList = transportServiceFacade.searchCommercialVehicleList();
			modelMap.put("gridRowJson", transportList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}
	
	@GetMapping("/searchDeliveryList")
	public ModelMap searchTransportAbleList(HttpServletResponse response) {

		ArrayList<TransportTO> transportList = null;
	
		try {	
			transportList = transportServiceFacade.searchTransportAbleList();
			modelMap.put("gridRowJson", transportList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		System.out.println("!!!!!!!!!!!!!!!!!" + modelMap);
		return modelMap;
	}

	
//@RequestMapping(value = "/batchTransportProcess")
//	public void insertTransportList(
//			@RequestParam("contractNo") String contractNo,
//			@RequestParam("transportStatus") String transportStatus, 
//			@RequestParam("dueDateOfContract") String dueDateOfContract, 
//			@RequestParam("commercialVehicle") String commercialVehicle,
//			@RequestParam("driver") String driver, 
//			@RequestParam("customerBasicAddress") String customerBasicAddress,
//			@RequestParam("customerDetailAddress") String customerDetailAddress, 
//			@RequestParam("memo") String memo,
//			@RequestParam("reportingDate") String reportingDate,
//			@RequestParam("errorCode") String errorCode,
//			@RequestParam("errorMsg") String errorMsg,
//			@RequestParam("status") String status,
//			@RequestParam("chk") String chk
//			) {		
//			 
//			transportServiceFacade.insertTransportList(transportStatus, contractNo, dueDateOfContract, commercialVehicle,
//					driver, customerBasicAddress, customerDetailAddress, memo, reportingDate
//					);
//	}

@RequestMapping(value = "/batchTransportProcess", method = RequestMethod.POST)
public void batchTransportProcess(@RequestBody Map<String, String> list) {
	
	String transportStatus = list.get("transportStatus");
	String contractNo = list.get("contractNo");
	String dueDateOfContract = list.get("dueDateOfContract");
	String commercialVehicle = list.get("commercialVehicle");
	String driver = list.get("driver");
	String customerBasicAddress = list.get("customerBasicAddress");
	String customerDetailAddress = list.get("customerDetailAddress");
	String memo = list.get("memo");
	String reportingDate = list.get("reportingDate");
   
   transportServiceFacade.updateTransportList(transportStatus, contractNo, dueDateOfContract, commercialVehicle,
			driver, customerBasicAddress, customerDetailAddress, memo, reportingDate
			);
}

//입차관리
@GetMapping("/getCommercialVehicleInList")
public ModelMap searchCommercialVehicleInList(HttpServletResponse response) {

	ArrayList<TransportTO> transportList = null;

	try {	
		transportList = transportServiceFacade.searchCommercialVehicleInList();
		modelMap.put("gridRowJson", transportList);
		modelMap.put("errorCode", 1);
		modelMap.put("errorMsg", "성공");

	} catch (Exception e2) {
		e2.printStackTrace();
		modelMap.put("errorCode", -2);
		modelMap.put("errorMsg", e2.getMessage());

	}
	return modelMap;
}

//입차업데이트
@RequestMapping(value = "/modifyCommercialVehicleInList", method = RequestMethod.POST)
public ModelMap modifyCommercialVehicleInList(@RequestBody HashMap<String, ArrayList<TransportTO>> rowData) {
	// TODO Auto-generated method stub
	
	System.out.println("commercialVehicleList::" + rowData);

	try {
		ArrayList<TransportTO> commercialVehicleList = rowData.get("rowData");
		modelMap.put("commercialVehicleList", commercialVehicleList);
		transportServiceFacade.modifyCommercialVehicleInList(modelMap);
		modelMap.put("restAttdList", modelMap.get("result"));
	} catch (Exception ioe) {
		modelMap.clear();
		modelMap.put("errorMsg", ioe.getMessage());
	}
	return modelMap;
}





}
