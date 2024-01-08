package kr.co.seoulit.erp.logistic.production.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;
import kr.co.seoulit.erp.logistic.production.domain.MrpGatheringDTO;
import kr.co.seoulit.erp.logistic.production.servicefacade.MrpGatheringServiceFacade;

import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "소요량 취합")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/logistics/production/mrpGathering/*", produces = "application/json")
public class MrpGatheringController {

    private final MrpGatheringServiceFacade mrpGatheringSF;

    @Autowired
    public MrpGatheringController(MrpGatheringServiceFacade mrpGatheringSF) {
        this.mrpGatheringSF = mrpGatheringSF;
    }

    /*****************************
      품목별 조달계획 디폴트 테이블 + ?
     *****************************/
    @ApiOperation(value = "품목별 조달계획 디폴트 테이블")
    @RequestMapping("/getMrpList")
    public ResponseEntity<HashMap<String,Object>> getMrpList(
                               @RequestParam(required = false) String mrpGatheringStatusCondition,
                               @RequestParam(required = false) String dateSearchCondition,
                               @RequestParam(required = false) String mrpStartDate,
                               @RequestParam(required = false) String mrpEndDate,
                               @RequestParam(required = false) String mrpGatheringNo) {

            HashMap<String, Object> resultMap= new HashMap<>();

            if (mrpGatheringStatusCondition != null) {
                resultMap = mrpGatheringSF.searchMrpList(mrpGatheringStatusCondition);
            }
            else if (dateSearchCondition != null) {
                resultMap = mrpGatheringSF.searchMrpList(dateSearchCondition, mrpStartDate, mrpEndDate);
            }
            else if (mrpGatheringNo != null) {
                resultMap = mrpGatheringSF.searchMrpListAsMrpGatheringNo(mrpGatheringNo);
            }
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    /*****************************
       품목별 소요량 취합 실행 버튼
     *****************************/
    @ApiOperation(value = "품목별 소요량 취합 실행 버튼")
    @RequestMapping(value = "/getMrpGatheringList")
    public ResponseEntity<HashMap<String,Object>> getMrpGatheringList(@RequestParam String mpsNoList) {
        HashMap<String, Object> mrpGathering = mrpGatheringSF.getMrpGathering(mpsNoList);
        return new ResponseEntity<>(mrpGathering, HttpStatus.OK);
    }


    /*****************************
           취합 결과 등록 버튼
     *****************************/
    @ApiOperation(value = "취합 결과 등록 버튼")
    @RequestMapping(value = "/registerMrpGathering", method = RequestMethod.PUT)
    public ResponseEntity<HashMap<String, Object>> registerMrpGathering(@RequestBody(required = false) Map<String, Object> params) {
        String mrpGatheringRegisterDate = params.get("mrpGatheringRegisterDate").toString();

        Object mrpNoAndItemCode = params.get("mrpNoAndItemCode");
        ArrayList<HashMap<String, String>> codeList = (ArrayList<HashMap<String, String>>) mrpNoAndItemCode;

        HashMap<String, String> mrpNoAndItemCodeMap = new HashMap<>();
        for (HashMap<String, String> item : codeList) {
            String itemCode = item.get("itemCode");
            String mrpNo = item.get("mrpNo");
            mrpNoAndItemCodeMap.put(mrpNo, itemCode);
        }

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ArrayList<MrpGatheringTO> newMrpGatheringList = mapper.convertValue(params.get("batchList"),
                TypeFactory.defaultInstance().constructCollectionType(List.class, MrpGatheringTO.class));

//        HashMap<String, String> mrpNoAndItemCodeMap = gson.fromJson(params.get("mrpNoAndItemCode").toString(),
//                new TypeToken<HashMap<String, String>>() {}.getType());

        HashMap<String, Object> resultMap =
                mrpGatheringSF.registerMrpGathering(mrpGatheringRegisterDate, newMrpGatheringList, mrpNoAndItemCodeMap);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }


    /*****************************
     소요량 취합 조회 (JPA)
     *****************************/
    @ApiOperation(value = "소요량 취합 조회 (JPA)")
    @RequestMapping(value = "/searchMrpGathering", method = RequestMethod.GET)
    public ResponseEntity<List<MrpGathering>> searchMrpGathering(@RequestParam String searchDateCondition,
                                                                 @RequestParam String startDate,
                                                                 @RequestParam String endDate) {

        List<MrpGathering> result = mrpGatheringSF.searchMrpGatheringList(searchDateCondition,
                startDate, endDate);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*****************************
      소요량 취합 캘린더(JPA,MapStruct)
     *****************************/
    @RequestMapping(value = "/searchMrpGatheringCalendar", method = RequestMethod.GET)
    public ResponseEntity<List<MrpGatheringDTO>> searchMrpGatheringCalendar(@RequestParam String month) {

        System.out.println("month = " + month);
        List<MrpGatheringDTO> result = mrpGatheringSF.searchMrpGatheringCalendar(month);
        System.out.println("result = " + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
