package kr.co.seoulit.erp.logistic.sales.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.sales.to.ContractDetailTO;
import kr.co.seoulit.erp.logistic.sales.to.ContractInfoTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Api(value = "출고관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/sales/*", produces = "application/json")

public class OutputController {

    @Autowired
    private SalesServiceFacade salesSF;

    private ModelMap modelMap = new ModelMap();

    @ApiOperation(value = "출고조회")
    @RequestMapping("/output")
    public ModelMap getOutputList(){
        return salesSF.getOutputList();
    }

    @ApiOperation(value = "출고 상세조회")
    @ResponseBody
    @RequestMapping(value = "/outputInfo", method = RequestMethod.GET)
    public ModelMap getOutputDetailList(@RequestParam @ApiParam(value = "출고번호") String outputNumber) {
        return salesSF.getOutputDetailList(outputNumber);
    }

    @ApiOperation(value = "출고 등록")
    @PostMapping("/addOutput")
    public Map<String, Object> addNewOutput(@RequestBody Map<String, Object> params) {
        System.out.println("gogo");
        Map<String, Object> result = new HashMap<>();

        try {
            // 출고 등록을 위한 퍼사드 메소드 호출
            result = salesSF.addNewOutput(params);

            // 반환된 결과에 'generatedOutputNumber'가 있을 경우 클라이언트로 전송
            if (result.containsKey("generatedOutputNumber")) {
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


    @ApiOperation(value = "출고삭제")
    @DeleteMapping(value = "/deleteOutput/{outputNumber}")
    public void deleteOutput(@PathVariable @ApiParam(value = "출고JSON")String outputNumber) {
        salesSF.deleteOutput(outputNumber);
    }

    @ApiOperation(value = "출고를 위한 수주조회")
    @RequestMapping("/searchContractOutput")
    public ModelMap searchContractOutput(@RequestParam String customerCode, @RequestParam String searchCondition,
                                   @RequestParam String startDate, @RequestParam String endDate) {
//        System.out.println("customerCode = " + customerCode);
//        System.out.println("customerCode = " + startDate);
//        System.out.println("customerCode = " + endDate);

        ArrayList<ContractInfoTO> contractOutputInfoTOList = null;

        if (searchCondition.equals("searchByDate")) {

            contractOutputInfoTOList = salesSF.getContractOutputList(startDate, endDate);

        } else if (searchCondition.equals("searchByCustomer")) {

            contractOutputInfoTOList = salesSF.getContractOutputListByCustomer(customerCode);
        }

        modelMap.put("gridRowJson", contractOutputInfoTOList);
        modelMap.put("errorCode", 1);
        modelMap.put("errorMsg", "성공");

        return modelMap;
    }

    @ApiOperation(value = "출고를 위한 수주 상세 조회")
    @RequestMapping("/searchContractOutputDetail")
    public ModelMap searchContractOutputDetail(@RequestParam String contractNo) {
        System.out.println("contractNo = " + contractNo);
        System.out.println("controller -searchContractOutputDetail() ");

        ArrayList<ContractDetailTO> contractDetailTOList = salesSF.getContractOutputDetailList(contractNo);

        System.out.println("왔니?"+contractDetailTOList);

        modelMap.put("gridRowJson", contractDetailTOList);
        modelMap.put("errorCode", 1);
        modelMap.put("errorMsg", "성공");

        return modelMap;
    }
}
