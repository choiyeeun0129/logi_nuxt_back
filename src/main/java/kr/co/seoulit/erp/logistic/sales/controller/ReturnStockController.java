package kr.co.seoulit.erp.logistic.sales.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.ReturnStockTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Api(value = "반품재고입고 요청관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/sales/*", produces = "application/json")


public class ReturnStockController {

    @Autowired
    private SalesServiceFacade salesSF;

    private ModelMap modelMap = new ModelMap();

    @ApiOperation(value = "반품재고 품목별 조회")
	@RequestMapping("/searchReturnStockList")
	public ArrayList<ReturnStockTO> searchReturnStockList(HttpServletRequest request, HttpServletResponse response) {

		String itemCode = request.getParameter("itemCode");

		ArrayList<ReturnStockTO> returnStockList = salesSF.searchReturnStockList(itemCode);

		return returnStockList;

	}

//    //반품재고입고 등록 위해 필요
//    @ApiOperation(value = "반품요청 조회")
//    @RequestMapping(value = "/returnListForStock", method = RequestMethod.GET)
//    public ModelMap returnListForStock(){
//        return salesSF.returnListForStock();
//    }

    @ApiOperation(value = "요청 등록")
    @PostMapping("/addReturnStock")
    public Map<String, Object> addReturnStock(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        System.out.println("params = " + params);
        System.out.println("returnNo:"+params.get("returnNo"));
        System.out.println("rtrnItemCode:"+params.get("rtrnItemCode"));
        System.out.println("rtrnItemName:"+params.get("rtrnItemName"));
        System.out.println("returnQty:"+params.get("returnQty"));
        try {
            // 반품요청 등록을 위한 퍼사드 메소드 호출
            result = salesSF.addReturnStock(params);

            // 반환된 결과에 'generatedRtrnRecNo'가 있을 경우 클라이언트로 전송
            if (result.containsKey("generatedRtrnRecNo")) {
                return result;
            } else {
                result.put("errorCode", -2);
                result.put("errorMsg", "Internal Server Error");
            }
        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

//    @ApiOperation(value = "반품요청 수정")
//    @PutMapping("/updateReturn")
//    public void updateReturn(@RequestBody @ApiParam(value = "반품JSON") ReturnTO returnList) {
//        salesSF.updateReturn(returnList);
//    }

    @ApiOperation(value = "반품재고요청 취소")
    @DeleteMapping(value = "/deleteReturnStock/{rtrnRecNo}")
    public void deleteReturnStock(@PathVariable @ApiParam(value = "반품JSON") String rtrnRecNo) {
        salesSF.deleteReturnStock(rtrnRecNo);
    }
}
