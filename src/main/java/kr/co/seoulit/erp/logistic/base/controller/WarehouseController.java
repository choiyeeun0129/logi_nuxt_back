package kr.co.seoulit.erp.logistic.base.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.logistic.base.servicefacade.WarehouseServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.WarehouseTO;

@Api(description = "창고관리")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base/*")
public class WarehouseController {

	@Autowired
	private WarehouseServiceFacade warehouseSF;

	private ModelMap modelMap = new ModelMap();
	@ApiOperation(value = "창고 조회")
	@RequestMapping("/warehouseInfo")
	public ModelMap getWarehouseList() {
		return warehouseSF.getWarehouseInfoList();
	}
	@ApiOperation(value = "창고 추가,수정,삭제")
	@RequestMapping(value = "/warehousebatchListProcess", method = RequestMethod.POST)
	public void warehousebatchListProcess(@RequestBody @ApiParam(value = "창고JSON") List<WarehouseTO> batchList) {
		warehouseSF.batchWarehouseInfoProcess(batchList);
	}

}
