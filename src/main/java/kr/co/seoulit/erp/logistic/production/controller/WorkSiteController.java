package kr.co.seoulit.erp.logistic.production.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "작업장/작업장로그")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class WorkSiteController {

    @Autowired
    private WorkSiteServiceFacade workSiteSF;

    @Autowired
    public WorkSiteController(WorkSiteServiceFacade workSiteSF) {
        this.workSiteSF = workSiteSF;
    }

    /*********************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     *********************************/
    @ApiOperation(value = "작업장 조회")
    @RequestMapping(value = "/getWorkSiteList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,List<WorkSite>>> getWorkSiteList() {
        System.out.println("WorkSiteContoller");
        Map<String,List<WorkSite>> map = new HashMap<>();
        List<WorkSite> workSiteList = workSiteSF.getWorkSiteList();

        if(workSiteList.isEmpty())
            return ResponseEntity.notFound().build();

        map.put("WorkSiteList",workSiteList);
        return ResponseEntity.ok(map);
    }

    //작업장/작업장 로그 = 작업장 조회(Spring)
//    @GetMapping("/getWorkSiteList")
//    public ModelMap getWorkPlaceList(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("getWorkSiteList");
//        ArrayList<WorkSiteTO> workPlaceList = null;
//
//        try {
//            workPlaceList = workSiteSF.getWorkSiteList();
//
//            modelMap.put("gridRowJson", workPlaceList);
//            modelMap.put("errorCode", 1);
//            modelMap.put("errorMsg", " 에러 ");
//
//        } catch (Exception e2) {
//            e2.printStackTrace();
//            modelMap.put("errorCode", -2);
//            modelMap.put("errorMsg", e2.getMessage());
//        }
//        return modelMap;
//    }



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
