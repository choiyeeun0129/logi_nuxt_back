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
public class IncomeStatementController {

	@Autowired
	private StatementServiceFacade statementServiceFacade;

//================================ 손익계산서 컨드롤러 조편백 ====================================

	@GetMapping("/incomeStatements")
	public ResponseEntity<HashMap<String, Object>> handleRequestInternal(@RequestParam("searchDate") String toDate) {

		HashMap<String, Object> param = new HashMap<>();
		try {

			HashMap<String, Object> result = statementServiceFacade.getIncomeStatement(toDate);

			param.put("incomeList",result.get("RESULT"));
			return ResponseEntity.ok(param);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}
}
