package kr.co.seoulit.erp.logistic.transvehicle.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.transvehicle.servicefacade.TransVehicleServiceFacade;
import kr.co.seoulit.erp.logistic.transvehicle.to.TransVehicleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(description = "운송수단관리")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/trans")
public class TransVehicleController {
    @Autowired
    private TransVehicleServiceFacade TransVehicleSF;

    private ModelMap modelMap = new ModelMap();

    @ApiOperation(value = "운송수단 전체 조회")
    @RequestMapping(value = "/allTransVehicleList", method = RequestMethod.GET)
    public ModelMap allTransVehicleList() {
        return TransVehicleSF.allTransVehicleList();
    }

    @ApiOperation(value = "운송수단 type별 조회")
    @GetMapping(value = "/getTransVehicleList/{type}")
    public ModelMap getTransVehicleList(@PathVariable @ApiParam(value = "운송수단") String type) {
        return TransVehicleSF.getTransVehicleList(type);
    }

    @ApiOperation(value = "운송수단 등록")
    @PostMapping("/addTransportation")
    public Map<String, Object> addNewVehicle(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        System.out.println("ssss");
        System.out.println("aaaaaaaa"+params.get("manufacturingCompany"));
        try {
            // 운송수단 등록을 위한 퍼사드 메소드 호출
            result = TransVehicleSF.addNewVehicle(params);

            // 반환된 결과에 'generatedVehicleNumber'가 있을 경우 클라이언트로 전송
            if (result.containsKey("generatedVehicleNumber")) {
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

    @ApiOperation(value = "운송수단 수정")
    @PutMapping("/updateTransportation")
    public void updateTransVehicle(@RequestBody @ApiParam(value = "운송수단JSON") TransVehicleTO transList){
        TransVehicleSF.updateTransVehicle(transList);
    }
    @ApiOperation(value = "운송수단 삭제")
    @DeleteMapping(value = "/deleteTransportation/{vehicleNumber}")
    public void deleteTransVehicle(@PathVariable @ApiParam(value = "운송수단JSON") String vehicleNumber) {
        TransVehicleSF.deleteTransVehicle(vehicleNumber);
    }
}