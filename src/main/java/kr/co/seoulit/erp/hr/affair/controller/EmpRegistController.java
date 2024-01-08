package kr.co.seoulit.erp.hr.affair.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.RegistEMPTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/*")
public class EmpRegistController{
	
	@Autowired
	private EmpServiceFacade empServiceFacade;
	private ModelAndView modelAndView = null;
	private ModelMap modelMap = null;
	
	
	//******************************************************08-26 손유찬 **************************************************** */

	
	@RequestMapping(value="/registEmployee",method=RequestMethod.POST)
	public ModelMap registEmployee(@RequestParam("data") String sendData) {
		try {
//HashMap<String , ArrayList<RegistEMPTO>>
			System.out.println("사원등록 데이타"+sendData);
			modelMap=new ModelMap();
			
			Gson gson = new Gson();
			RegistEMPTO emp = gson.fromJson(sendData, new TypeToken<RegistEMPTO>(){}.getType());	
			System.out.println("지손 데이타"+emp);
			empServiceFacade.registEmployee(emp);		
			modelMap.put("errorMsg","사원이 등록되었습니다.");
			modelMap.put("errorCode", 0);
		} catch (Exception dae){
			modelMap.put("errorMsg", "사원 등록에 실패했습니다 : "+dae.getMessage());
			modelMap.put("errorCode", -1);
		}
		return modelMap;
	}
	//******************************************************08-26 손유찬 **************************************************** */

	
	public ModelAndView findLastEmpCode(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType("application/json; charset=UTF-8");
			String empCode = empServiceFacade.findLastEmpCode();
			modelMap.put("lastEmpCode", empCode);
			modelMap.put("errorMsg","success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		modelAndView = new ModelAndView("jsonView", modelMap);
		return modelAndView;
	}
	
}
