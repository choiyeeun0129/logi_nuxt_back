package kr.co.seoulit.erp.logistic.outsourcing.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.outsourcing.servicefacade.OutsourcServiceFacade;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/logi/outsourc/*")
public class ForwardController {

	@Autowired
	private OutsourcServiceFacade outsourcSF;
	
	private ModelMap modelMap = new ModelMap();
	
	@RequestMapping("/showReleaseDialog")
	public HashMap<String, Object> showReleaseDialog(HttpServletRequest request, HttpServletResponse response) {

		String mrpGatheringNo = request.getParameter("mrpGatheringNo");
		String id = request.getParameter("id");
		String seq = request.getParameter("seq");
		
		System.out.println(mrpGatheringNo+"확인1111111111");
		System.out.println(id+"확인1111111111");
		System.out.println(seq+"확인1111111111");
		
		HashMap<String,Object> resultMap = new HashMap<>();

		try {
			resultMap = outsourcSF.getReleaseSimulationList(mrpGatheringNo, id, seq);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}
		return resultMap;
	}
	
	@RequestMapping("/updateStock")
	public ModelMap updateStock(HttpServletRequest request, HttpServletResponse response) {
		String mrpGatheringNo = request.getParameter("mrpGatheringNo");
		String itemCode = request.getParameter("itemCode");
		String id = request.getParameter("id");
		String seq = request.getParameter("seq");

		System.out.println(mrpGatheringNo+"확인222222");
		
	   outsourcSF.updateStock(itemCode,mrpGatheringNo, id, seq);

		return modelMap;
	}

	@PostMapping("/updateForwardStatus")
	public void updateForwardStatus(@RequestBody OutsourcTO outsourcTO) {

		System.out.println(outsourcTO);
		outsourcSF.updateForwardStatus(outsourcTO.getOutsourcNo());

	}

	
	@GetMapping("/searchForwardableList")
	public ModelMap searchForwardableList(HttpServletRequest request, HttpServletResponse response) {
	
		ArrayList<OutsourcTO> searchForwardableList = null;
		
		String searchDateCondition = request.getParameter("searchDateCondition");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
	
		try {
	
			searchForwardableList = outsourcSF.searchForwardableList(searchDateCondition, startDate, endDate);
	
			modelMap.put("gridRowJson", searchForwardableList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", " 성공");
	
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
	
		}
		return modelMap;
}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/forwardTempDelete")
	public ModelMap forwardTempDelete(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String seq = request.getParameter("seq");
		
		System.out.println(id+"확인222222");
		System.out.println(seq+"확인222222");
		
		outsourcSF.forwardTempDelete(id, seq);

		return modelMap;
	}
			
}