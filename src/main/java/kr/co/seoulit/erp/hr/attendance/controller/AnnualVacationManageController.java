package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.attendance.servicefacade.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.annualVacationMgtTO;


@RestController
@CrossOrigin("*")
@RequestMapping("/hr/attendance/*")
public class AnnualVacationManageController {
	
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	HashMap<String, Object> map = new HashMap<>();
	private ModelMap modelMap = new ModelMap();

	// ��ȸ
	@RequestMapping(value = "/findAnnualVacationMgtList", method = RequestMethod.GET)
	public ModelMap findAnnualVacationMgtList(@RequestParam String applyYearMonth) {
		// TODO Auto-generated method stub
		try {
			modelMap.put("applyYearMonth", applyYearMonth);
			attdServiceFacade.findAnnualVacationMgtList(modelMap);
			modelMap.put("restAttdList", modelMap.get("result"));
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;

	}

	// ����
	@RequestMapping(value = "/modifyAnnualVacationMgtList", method = RequestMethod.POST)
	public ModelMap modifyAnnualVacationMgtList(@RequestBody HashMap<String, ArrayList<annualVacationMgtTO>> rowData) {
		// TODO Auto-generated method stub

		System.out.println("annualVacationMgt::" + rowData);

		try {
			ArrayList<annualVacationMgtTO> annualVacationMgt = rowData.get("rowData");
			modelMap.put("annualVacationMgt", annualVacationMgt);
			attdServiceFacade.modifyAnnualVacationMgtList(modelMap);
			modelMap.put("restAttdList", modelMap.get("result"));
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}

	/*
	 * 
	 * @RequestMapping(value="/attendance/findAnnualVacationMgtList",method=
	 * RequestMethod.GET) public void modifyAnnualVacationMgtList(@RequestParam
	 * String applyYearMonth){
	 * 
	 * System.out.println("applyYearMonth�� "+applyYearMonth); //
	 * attdServiceFacade.modifyAnnualVacationMgtList(applyYearMonth); }
	 * 
	 * 
	 * @RequestMapping("/attendance/cancelAnnualVacationMgtList.do") public void
	 * cancelAnnualVacationMgtList(@RequestAttribute("inData") PlatformData inData,
	 * 
	 * @RequestAttribute("outData") PlatformData outData) throws Exception {
	 * 
	 * ArrayList<annualVacationMgtTO> annualVacationMgtList =
	 * (ArrayList<annualVacationMgtTO>)datasetBeanMapper.datasetToBeans(inData,
	 * annualVacationMgtTO.class);
	 * attdServiceFacade.cancelAnnualVacationMgtList(annualVacationMgtList); }
	 */
}