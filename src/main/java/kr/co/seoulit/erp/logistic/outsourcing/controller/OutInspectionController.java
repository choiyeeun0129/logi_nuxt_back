package kr.co.seoulit.erp.logistic.outsourcing.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.outsourcing.servicefacade.OutsourcServiceFacade;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutInspectionTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/logi/outsourc/*")
public class OutInspectionController {

	@Autowired
	private OutsourcServiceFacade outsourcSF;

	private ModelMap modelMap = new ModelMap();

	@GetMapping("outInspectionInfoList")
	public HashMap<String, Object> outInspectionInfoList(){

		ArrayList<OutInspectionTO> outInspectionInfoList = null;

		try {

			outInspectionInfoList = outsourcSF.getOutInspectionInfoList();

			modelMap.put("gridRowJson", outInspectionInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", " 성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	@PostMapping("/outInspectionCompletion")
	public HashMap<String, Object> outInspectionCompletion(@RequestBody OutsourcTO outsourcTO) {

//		String outsourcNo = request.getParameter("outsourcNo");
//		String actualCompletionAmount = request.getParameter("actualCompletionAmount");
		HashMap<String, Object> resultMap = new HashMap<>();

		try {

			resultMap = outsourcSF.outInspectionCompletion(outsourcTO.getOutsourcNo()
//					, actualCompletionAmount
			);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}
		return resultMap;
	}

}