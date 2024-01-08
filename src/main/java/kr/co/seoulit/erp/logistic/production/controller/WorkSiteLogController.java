package kr.co.seoulit.erp.logistic.production.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;
import kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteLogServiceFacade;
import kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "작업장/작업장로그")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class WorkSiteLogController {

    @Autowired
    private WorkSiteLogServiceFacade workSiteLogSF;

    @Autowired
    public WorkSiteLogController(WorkSiteLogServiceFacade workSiteLogSF) {
        this.workSiteLogSF = workSiteLogSF;
    }

    /**************************************
     작업장/작업장 로그 = 작업장 로그 조회(JPA)
     **************************************/
    @ApiOperation(value = "작업장 로그 조회")
    @RequestMapping(value = "/getProductionProcessCode", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<WorkSiteLog>> getWorkSiteLog(@RequestParam @ApiParam(value = "생산공정코드")String productionProcessCode,
                                                            @RequestParam @ApiParam(value = "사업장명")String workSiteName) {
        System.out.println("작업장로그조회_Controller : " + productionProcessCode);
        System.out.println("작업장로그조회_Controller : " + workSiteName);

        List<WorkSiteLog> WorkSiteLogList = workSiteLogSF.getWorkSiteLog(productionProcessCode, workSiteName);
        return new ResponseEntity<>(WorkSiteLogList, HttpStatus.OK);
    }














    //작업장/작업장 로그 = 작업장 로그 조회(Spring)
//    @RequestMapping("/getProductionProcessCode")
//    public HashMap<String, Object> searchProductionProcessCode(@RequestParam String productionProcessCode,
//                                                               @RequestParam String workSiteCode) {
//        System.out.println("getProductionProcessCode");
//        System.out.println("productionProcessCode ========== " + productionProcessCode);
//        System.out.println("workSiteCode ============== " + workSiteCode);
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("productionProcessCode", productionProcessCode);
//        map.put("workSiteCode", workSiteCode);
//        ArrayList<WorkSiteLogTO> getProductionProcessCode = workSiteSF.getProductionProcessCode(map);
//
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("gridRowJson", getProductionProcessCode);
//        param.put("errorCode", 1);
//        param.put("errorMsg", "성공");
//
//        return param;
//    }
}
