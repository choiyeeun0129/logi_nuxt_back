package kr.co.seoulit.erp.account.statement.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.statement.servicefacade.StatementServiceFacade;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/statement")
public class CostStatementController {

	@Autowired
	private StatementServiceFacade statementServiceFacade;

	@GetMapping( "/costStatements")
	public ResponseEntity<HashMap<String, Object>>handleRequestInternal(@RequestParam("searchDate") String toDate) {

		HashMap<String, Object> param = new HashMap<>();
		try {

			HashMap<String, Object> result = statementServiceFacade.getCostStatement(toDate);
			param.put("costList", result.get("RESULT"));
			return  ResponseEntity.ok(param);

		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}

	}
}
