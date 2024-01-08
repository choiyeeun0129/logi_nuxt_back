package kr.co.seoulit.erp.logistic.production.controller;

import java.util.List;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.servicefacade.ProductionPerformanceServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(description = "작업지시/생산실적관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class ProductionPerformanceController {

    @Autowired
    private ProductionPerformanceServiceFacade ProductionPerformanceSF;

    /*************************************
     생산실적관리 Tab - 생산실적조회(JPA)
     *************************************/
    @ApiOperation(value = "생산실적조회")
    @RequestMapping(value = "/getProductionPerformanceInfoList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductionPerformance>> getWorkOrderInfoListStatus() {
        System.out.println("ProductionPerformanceController");
        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getProductionPerformanceInfoList();
        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
    }

    /*************************************
     생산실적관리 Tab - 생산실적관리조회(Spring)
     *************************************/
//    @RequestMapping(value = "/productionperformance/itemClassification", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<ProductionPerformance>> getItemClassifiction(@RequestParam String itemClassification) {
//        System.out.println("ProductionPerformanceController = " );
//        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getItemClassifiction(itemClassification);
//        System.out.println("ProductionPerformanceController = " );
//        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
//    }
}
