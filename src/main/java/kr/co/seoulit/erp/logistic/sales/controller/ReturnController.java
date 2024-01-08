package kr.co.seoulit.erp.logistic.sales.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.ReturnTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "반품요청관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/sales/*", produces = "application/json")


public class ReturnController {

    @Autowired
    private SalesServiceFacade salesSF;

    private ModelMap modelMap = new ModelMap();

    @ApiOperation(value = "반품요청 조회")
    @RequestMapping("/getReturnList")
    public HashMap<String, Object> getReturnList(@RequestParam String startDate,
                                                 @RequestParam String endDate
    ) {
        HashMap<String, Object> resultMap = new HashMap<>();

        try {
            resultMap = salesSF.getReturnList(startDate, endDate);
            System.out.println("returnList!!" + resultMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            resultMap.put("errorCode", -2);
            resultMap.put("errorMsg", e2.getMessage());
        }
        return resultMap;
    }

    //반품재고입고 등록 위해 필요
    @ApiOperation(value = "반품요청 조회")
    @RequestMapping(value = "/returnListForStock", method = RequestMethod.GET)
    public ModelMap returnListForStock(){
        return salesSF.returnListForStock();
    }

    @ApiOperation(value = "반품요청 수정")
    @PutMapping("/updateReturn")
    public void updateReturn(@RequestBody @ApiParam(value = "반품JSON") ReturnTO returnList) {
        salesSF.updateReturn(returnList);
    }

    @ApiOperation(value = "반품요청 취소")
    @DeleteMapping(value = "/deleteReturn/{returnNo}")
    public void deleteReturn(@PathVariable @ApiParam(value = "반품JSON") String returnNo) {
        salesSF.deleteReturn(returnNo);
    }

    @ApiOperation(value = "반품요청 등록")
    @PostMapping("/addReturn")
    public Map<String, Object> addReturn(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        System.out.println("보여라");
        System.out.println("deliveryNumber"+params.get("deliveryNumber"));
        System.out.println("itemName"+params.get("itemName"));
        try {
            // 반품요청 등록을 위한 퍼사드 메소드 호출
            result = salesSF.addReturn(params);

            // 반환된 결과에 'generatedReturnNumber'가 있을 경우 클라이언트로 전송
            if (result.containsKey("generatedReturnNumber")) {
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
}
