package kr.co.seoulit.erp.logistic.purchase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.co.seoulit.erp.logistic.purchase.servicefacade.PurchaseServiceFacade;
import kr.co.seoulit.erp.logistic.purchase.to.BomDeployTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomInfoTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomTO;

@Api(description = "Deploy")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/purchase/*")
public class BomController {

	@Autowired
	private PurchaseServiceFacade purchaseSF;

	/***************************
	 			Deploy								현재 JPA, Swagger 변환하는 작업중
	 ***************************/

/*
	@ApiOperation(value = "Search Deploy")
	@RequestMapping("/searchBomDeploy")
	public ModelMap searchBomDeploy(@RequestParam("deployCondition") String deployCondition,
									@RequestParam @ApiParam(value = "품목코드") String itemCode,
									@RequestParam("itemClassificationCondition") String itemClassificationCondition) {

		List<BomDeployTO> bomDeployList = purchaseSF.getBomDeployList(deployCondition, itemCode,
				itemClassificationCondition);

		return purchaseSF.bomDeployList(deployCondition, itemCode,
				itemClassificationCondition);
	}
*/

	/***************************
	 			BomInfo
	 ***************************/

	/*
	@ApiOperation(value = "Search BomInfo")
	@RequestMapping("/searchBomInfo")
	public ModelMap searchBomInfo(@RequestParam("parentItemCode") String parentItemCode) {

		*//*List<BomInfoTO> bomInfoList = purchaseSF.getBomInfoList(parentItemCode);*//*
		return purchaseSF.bomInfoList(parentItemCode);
	}

	*/

	/***************************
	 	등록가능한 BOM 항목검색
	 ***************************/

	/*

	@ApiOperation(value = "등록가능한 BOM 항목검색")
	@RequestMapping("/searchAllItemWithBomRegisterAvailable")
	public ResponseEntity<ModelMap> searchAllItemWithBomRegisterAvailable() {
		ModelMap modelMap = new ModelMap();

		try {
			List<BomInfoTO> allItemWithBomRegisterAvailable = purchaseSF.getAllItemWithBomRegisterAvailable();

			modelMap.put("gridRowJson", allItemWithBomRegisterAvailable);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

			return ResponseEntity.ok(modelMap);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(modelMap);
		}
	}

	*/


	private static Gson gson = new GsonBuilder().serializeNulls().create();

	private ModelMap modelMap = new ModelMap();


	@RequestMapping("/searchBomDeploy")
	public ArrayList<BomDeployTO> searchBomDeploy(HttpServletRequest request, HttpServletResponse response) {

		String deployCondition = request.getParameter("deployCondition");
		System.out.println("deployCondition : " + deployCondition);
		// forward 정전개 || reverse 역전개
		String itemCode = request.getParameter("itemCode");
		System.out.println("itemCode : " + itemCode);
		// CodeController를 사용하여 검색한 후 선택하여 텍스트박스에 들어있던 값을 파라미터로 받아옴
		// ex) DK-01
		String itemClassificationCondition = request.getParameter("itemClassificationCondition");
		System.out.println("itemClassificationCondition : " + itemClassificationCondition);

		ArrayList<BomDeployTO> bomDeployList = purchaseSF.getBomDeployList(deployCondition, itemCode,
				itemClassificationCondition);

		return bomDeployList;

	}

	@RequestMapping("/searchBomInfo")
	public ArrayList<BomInfoTO> searchBomInfo(HttpServletRequest request, HttpServletResponse response) {

		String parentItemCode = request.getParameter("parentItemCode");

		ArrayList<BomInfoTO> bomInfoList = purchaseSF.getBomInfoList(parentItemCode);

		return bomInfoList;

	}

	@RequestMapping("/searchAllItemWithBomRegisterAvailable")
	public ModelMap searchAllItemWithBomRegisterAvailable(HttpServletRequest request, HttpServletResponse response) {

		try {

			ArrayList<BomInfoTO> allItemWithBomRegisterAvailable = purchaseSF.getAllItemWithBomRegisterAvailable();

			modelMap.put("gridRowJson", allItemWithBomRegisterAvailable);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;

	}

	@RequestMapping(value = "/batchBomListProcess", method = RequestMethod.POST)
	public HashMap<String, Object> batchBomListProcess(@RequestBody ArrayList<BomTO> batchBomList) {
    System.out.println("batchBomList: " + batchBomList);

    // batchBomList를 직접 사용하거나 처리

    HashMap<String, Object> resultList = purchaseSF.batchBomListProcess(batchBomList);

    return resultList;
//	public HashMap<String, Object> batchBomListProcess(@RequestBody HashMap<String, Object> params) {
//
//		// String batchList = request.getParameter("batchList");
//		System.out.println("params : " + params);
//		String batchList = (String) params.get("batchList");
//		System.out.println("batchList : " + batchList);
//
//		ArrayList<BomTO> batchBomList = gson.fromJson(batchList, new TypeToken<ArrayList<BomTO>>() {
//		}.getType());
//		System.out.println(batchBomList);
//		HashMap<String, Object> resultList = purchaseSF.batchBomListProcess(batchBomList);
//
//		return resultList;

	}

	//dbs
	@RequestMapping("/searchBomData")
	public ArrayList<BomDeployTO> searchBomDataList(HttpServletRequest request, HttpServletResponse response) {

		String itemCode = request.getParameter("itemCode");
		String itemClassificationCondition = request.getParameter("itemClassificationCondition");

		ArrayList<BomDeployTO> bomDataList = purchaseSF.getBomDataList(itemCode,
				itemClassificationCondition);

		System.out.println("bomDataList = " + bomDataList);

		return bomDataList;
	}

	@RequestMapping(value = "/bomdata/batch", method = RequestMethod.POST)
	public ModelMap bomBatchList(@RequestBody ArrayList<BomTO> bomBatchList) {
		System.out.println(bomBatchList);
		HashMap<String, Object> resultMap = null;

		try {
			resultMap = purchaseSF.batchBomListProcess(bomBatchList);
			modelMap.put("result", resultMap);
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
