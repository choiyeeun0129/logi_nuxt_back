package kr.co.seoulit.erp.hr.base.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;
import kr.co.seoulit.erp.hr.base.to.BaseWorkTimeTO;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/hr/base/*",produces ="application/json")
public class BaseWorkTimeController{	
	@Autowired
	private HrBaseServiceFacade baseServiceFacade;

	@RequestMapping(value="/baseWorkTimeList", method=RequestMethod.GET)
	public ModelMap searchBaseWorkTimeList() {


		
		List<BaseWorkTimeTO> list = baseServiceFacade.searchBaseWorkTimeList();
	  
		ModelMap map = new ModelMap();
		map.put("gridRowJson", list);
		map.put("errorCode",0);
		map.put("errorMsg","success");
		return map;
	 
	}
	
	@RequestMapping(value="/baseWorkTimeList", method=RequestMethod.POST)
	public void batchBaseWorkTimeListBatch(@RequestBody Map<String, Object> params) {
		
		List<BaseWorkTimeTO> list = Arrays.asList(new GsonBuilder().create().fromJson(params.get("sendData").toString(), BaseWorkTimeTO[].class));
		
		baseServiceFacade.batchBaseWorkTimeList(list);

	}
   
	@RequestMapping(value="/baseWorkTimeList", method=RequestMethod.DELETE)
	public void deleteBaseWorkTime(@RequestBody Map<String, Object> params) {
		System.out.println("delete");
		
		List<BaseWorkTimeTO> list = Arrays.asList(new GsonBuilder().create().fromJson(params.get("sendData").toString(), BaseWorkTimeTO[].class));
		
		for(BaseWorkTimeTO bwtTo : list) {
			System.out.println(bwtTo.getApplyYear());
		}
		
		baseServiceFacade.deleteBaseWorkTimeList(list);
	}
	

}
