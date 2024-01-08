package kr.co.seoulit.erp.sys.controller;

import kr.co.seoulit.erp.hr.affair.to.EmpInfoTO;
import kr.co.seoulit.erp.sys.exception.IdNotFoundException;
import kr.co.seoulit.erp.sys.exception.PwMissMatchException;
import kr.co.seoulit.erp.sys.to.LoginTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.sys.serviceFacade.BaseServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys/*")
@CrossOrigin(value = "*", exposedHeaders = { "Authorization" })
public class MyLoginHandler {

	@Autowired
	BaseServiceFacade baseServiceFacade;

	@PostMapping("login")
	public Map<String, Object> login(@RequestBody LoginTo loginData, HttpServletResponse response)
			throws DataAccessException {
		Map<String, Object> result = new HashMap<>();


		try {

			// response.addHeader("Authorization", baseServiceFacade.login(loginTo));

			// 여기부터
			EmpInfoTO empTo = baseServiceFacade.myLogin(loginData);
//			
//			if(empTo.getEmpCode()!=null) {
//				response.addHeader("Authorization", "enter");
//			}			
//			System.out.println(empTo);
			result.put("empInfo", empTo);

			// 여기까지

//			result.put("empName", logi)

			result.put("errorCode", loginData.getErrorCode());
			result.put("errorMsg", loginData.getErrorMsg());

		} catch (IdNotFoundException | PwMissMatchException e) {
			result.put("errorCode", 1);
			result.put("errorMsg", e.getMessage());
		}

		return result;
	}

	@PostMapping("/api/auth/logout")
	public Map<String, Object> logout(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<>();

		try {
			request.getSession().invalidate();
			System.out.println("세션만료");
		} catch (Exception e) {
			result.put("errorCode", -1);
			result.put("errorMsg", e.getMessage());
		}

		return result;
	}

}