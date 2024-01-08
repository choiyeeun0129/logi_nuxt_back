package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.base.domain.Workplace;
import kr.co.seoulit.erp.logistic.base.servicefacade.WorkplaceServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Api(description = "사업장 정보")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base/*")
public class WorkplaceInfoController {
    // 75기 최영현 수정, workplace, logicode 이원화 및 JPA CRUD 추가.
    @Autowired
    private WorkplaceServiceFacade workplaceSF;
    private ModelMap modelMap;
    @ApiOperation(value = "사업장 조회")
    @ResponseBody
    @RequestMapping(value = "/workplaceList", method = RequestMethod.GET)
    public ModelMap getWorkplaceList() {
        return workplaceSF.getWorkplaceList();
    }
    @ApiOperation(value = "사업장 상세조회")
    @ResponseBody
    @RequestMapping(value = "/workplaceInfo", method = RequestMethod.GET)
    public ModelMap getWorkplaceInfo(@RequestParam @ApiParam(value = "사업장코드") String workplaceCode) {
        return workplaceSF.getWorkplaceDetailList(workplaceCode);
    }
    @ApiOperation(value = "사업장 추가")
    @ResponseBody
    @RequestMapping(value = "/workplace", method = RequestMethod.POST)
    public void insertWorkplaceCode(@RequestBody @ApiParam(value = "사업장JSON")Workplace workplaceInfoTO) {
        workplaceSF.insertWorkplaceCode(workplaceInfoTO);
    }
    @ApiOperation(value = "사업장 삭제")
    @ResponseBody
    @RequestMapping(value = "/workplaceCode", method = RequestMethod.DELETE)
    public void deleteWorkplaceCode(@RequestParam @ApiParam(value = "사업장JSON")String workplaceCode) {
        workplaceSF.deleteWorkplaceCode(workplaceCode);
    }
//    @ApiOperation(value = "사업장 수정")
//    @ResponseBody
//    @RequestMapping(value = "/workplaceupdate", method = RequestMethod.POST)
//    public void updateWorkplaceCode(@RequestBody @ApiParam(value = "사업장JSON")Workplace workplaceInfoTO) {
//        workplaceSF.updateWorkplaceCode(workplaceInfoTO);
//    }

    @ApiOperation(value = "사업장 수정")
    @ResponseBody
    @RequestMapping(value = "/workplaceupdate", method = RequestMethod.PUT)
    public void updateWorkplaceCode(@RequestBody @ApiParam(value = "사업장JSON")Workplace workplaceInfoTO) {
        workplaceSF.updateWorkplaceCode(workplaceInfoTO);
    }
}

