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
public class OutsourcOrderController {

	@Autowired
	private OutsourcServiceFacade outsourcSF;

	private ModelMap modelMap = new ModelMap();

	@GetMapping(value = "searchOderableList")
	public HashMap<String, Object> searchOrderableList(
			@RequestParam String searchDateCondition,
			@RequestParam String startDate,
			@RequestParam String endDate) {
		HashMap<String, Object> resultMap = new HashMap<>();
		System.out.println(searchDateCondition);
		System.out.println(startDate);
		System.out.println(endDate);

		try {
			resultMap.put("gridRowJson", outsourcSF.searchMrpGatheringList(
					searchDateCondition,
					startDate,
					endDate)
			);
			resultMap.put("errorCode", 1);
			resultMap.put("errorMsg", "성공");

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e.getMessage());
		}
		return resultMap;
	}

	@GetMapping(value = "searchOutsourcInfoList2")
	public HashMap<String, Object> searchOutsourceInfoList(){

		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("gridRowJson", outsourcSF.searchOutsourcInfoList());
			resultMap.put("errorCode", 1);
			resultMap.put("errorMsg", "성공");

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping("/getStandardUnitPrice")
	public ModelMap getStandardUnitPrice(HttpServletRequest request, HttpServletResponse response) {
		String itemCode = request.getParameter("itemCode");
		System.out.println("itemCode = " + itemCode);

		int price = 0;

		try {
			price = outsourcSF.getStandardUnitPrice(itemCode);

			modelMap.put("gridRowJson", price);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	@PostMapping("insertOutsourc") // mps등록
	public ModelMap insertOutsourc(@RequestBody ArrayList<OutsourcTO> OutsourcList) {

		System.out.println("여기니");
		System.out.println(OutsourcList);

		outsourcSF.insertOutsourc(OutsourcList);

		return modelMap;
	}

	@RequestMapping(value = "/searchOutsourcInfoList", method = RequestMethod.GET)
	public HashMap<String, Object> searchOutsourcInfoList(@RequestParam String searchDateCondition,
			@RequestParam String startDate, @RequestParam String endDate) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("gridRowJson", outsourcSF.searchOutsourcInfoList(searchDateCondition, startDate, endDate));
			resultMap.put("errorCode", 1);
			resultMap.put("errorMsg", "성공");

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e.getMessage());
		}
		return resultMap;
	}
}
