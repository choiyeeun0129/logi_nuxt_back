package kr.co.seoulit.erp.logistic.sales.controller;

import java.util.ArrayList;
//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//description:	HashMap, LinkedHashMap, Map, ObjectMapper, Gson, GsonBuilder  import
import java.util.HashMap;
import java.util.Map;

//************************* 2020.08.27 63기 양지훈 수정 종료 *************************
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.EstimateDetailTO;
import kr.co.seoulit.erp.logistic.sales.to.EstimateTO;
import kr.co.seoulit.erp.logistic.sales.to.logisticExelTO;


@Api(value ="견적관리")
@SuppressWarnings({ "unused", "deprecation" })
@RestController
@CrossOrigin("*")
@RequestMapping("/logi/*")
public class EstimateController {

	@Autowired
	private SalesServiceFacade salesSF;

	private ModelMap modelMap = new ModelMap();

//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//	description:	gson import
//
//	GSON 라이브러리
//	속성값이 null 인 속성도 json 변환
	private static Gson gson = new GsonBuilder().serializeNulls().create();
//************************* 2020.08.27 63기 양지훈 수정 종료 *************************

	@ApiOperation(value = "견적조회")
	@RequestMapping("/sales/searchEstimates")
	public ModelMap searchEstimateInfo(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String dateSearchCondition) {

//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
//		String dateSearchCondition = request.getParameter("dateSearchCondition");

		try {

			ArrayList<EstimateTO> estimateTOList = salesSF.getEstimateList(dateSearchCondition, startDate, endDate);

			modelMap.put("gridRowJson", estimateTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	@RequestMapping("/sales/logisticExel")
	public ModelMap logisticExel(@RequestParam String estimateNo) {

		try {

			ArrayList<logisticExelTO> logisticExel = salesSF.getLogisticExel(estimateNo);

			modelMap.put("gridRowJson", logisticExel);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
			System.out.println(logisticExel);
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	@ApiOperation(value ="수주상세검색")
// 酉곕떒�뿉 二쇱꽍 泥섎━ �릺�뼱�엳�쓬
	@RequestMapping("/sales/searchEstimateDetail")
	public ModelMap searchEstimateDetailInfo(@RequestParam String estimateNo) {

		System.out.println(estimateNo);

		try {

			ArrayList<EstimateDetailTO> estimateDetailTOList = salesSF.getEstimateDetailList(estimateNo);

			modelMap.put("gridRowJson", estimateDetailTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//	description:	주석 처리 되어 있는 부분들 해제
//					주석 내용들 UTF-8로 수정
//					newEstimateInfo의 TYPE이 LinkedHashMap임; ObjectMapper를 사용해 TYPE을 EstimateTO로 변환;
//					Data @RequestBody로 받아옴;
	@ApiOperation(value="견적등록")
	@PostMapping("/sales/addNewEstimates")
	public ModelMap addNewEstimate(@RequestBody Map<String, Object> params) {

		System.out.println("params.toString() = " + params.toString());
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(
				VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		EstimateTO newEstimateInfo = mapper.convertValue(params.get("newEstimateInfo"), EstimateTO.class);
		String estimateDate = newEstimateInfo.getEstimateDate();
		ArrayList<EstimateDetailTO> estimateDetailTO = newEstimateInfo.getEstimateDetailTOList();
		EstimateDetailTO estimateDetailTO1 = estimateDetailTO.get(0);
		System.out.println("estimateDetailTO1.getEstimateAmount() = " + estimateDetailTO1.getEstimateAmount());
		try {
			HashMap<String, Object> resultList = salesSF.addNewEstimate(estimateDate, newEstimateInfo);
			modelMap.clear();
			modelMap.put("result", resultList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
			System.out.println("서엉공");
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return modelMap;
	}
//************************* 2020.08.27 63기 양지훈 수정 종료 *************************

	@RequestMapping("/batchEstimateDetailListProcess")
	public ModelMap batchListProcess(HttpServletRequest request, HttpServletResponse response) {

//		String batchList = request.getParameter("batchList");

//		ArrayList<EstimateDetailTO> estimateDetailTOList = gson.fromJson(batchList,
//				new TypeToken<ArrayList<EstimateDetailTO>>() {
//				}.getType());

		try {

//			HashMap<String, Object> resultList = salesSF.batchEstimateDetailListProcess(estimateDetailTOList);
//
//			modelMap.put("result", resultList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "�꽦怨�");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

}
