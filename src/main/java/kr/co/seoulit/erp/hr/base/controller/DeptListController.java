package kr.co.seoulit.erp.hr.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;
import kr.co.seoulit.erp.hr.base.to.DeptTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/base/*")
public class DeptListController{	
	@Autowired
	private HrBaseServiceFacade baseServiceFacade;
	@Autowired
	private EmpServiceFacade empServiceFacade;

	@RequestMapping(value="/deptList", method=RequestMethod.POST)
	public void batchDeptProcess(@RequestBody HashMap<String,ArrayList<DeptTO>> sendData) {
         
//		  ObjectMapper mapper = new ObjectMapper();
//		ArrayList<DeptTO> deptto =null;
//				try {
//					deptto = mapper.readValue(sendData, new TypeReference<ArrayList<DeptTO>>(){});
//		  			
//		  		} catch (IOException e) {
//		  			e.printStackTrace();
//		  		}
//		
//				//수녕ssasd 몇단 전 
	  baseServiceFacade.batchDeptProcess(sendData.get("sendData"));
	}
   
@RequestMapping(value="/deptList", method=RequestMethod.GET )
@ResponseBody
	public Map<String, Object> findDeptList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
			List<DeptTO> list = empServiceFacade.findDeptList();
			DeptTO emptyBean = new DeptTO();
			 map.put("emptyBean", emptyBean);
			 map.put("list", list);
			 map.put("errorMsg","success");
			 map.put("errorCode", 0);

		
		
		return map;
	}
		
}
