package kr.co.seoulit.erp.account.statement.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.statement.servicefacade.StatementServiceFacade;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/statement")
public class MonthIncomeStatementController {

	@Autowired
	private StatementServiceFacade statementServiceFacade;

//================================ 손익계산서 컨드롤러 조편백 ====================================

	@GetMapping(value = "/monthIncomeStatements")
	public ResponseEntity<HashMap<String, Object>> handleRequestInternal(@RequestParam("searchDate") String toDate) {

		System.out.println("============월별손익계산서 컨트롤러시작===============");
		HashMap<String, Object> param = new HashMap<>();
		try {

			param = statementServiceFacade.getMonthIncomeStatement(toDate);
			param.put("monthIncomeList", param.get("RESULT"));
			return ResponseEntity.ok(param);


		} catch (Exception e) {
			param.put("errorCode", -1);
			param.put("errorMsg", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
}
