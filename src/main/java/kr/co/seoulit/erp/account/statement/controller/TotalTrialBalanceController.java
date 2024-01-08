package kr.co.seoulit.erp.account.statement.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.statement.to.TotalTrialBalanceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.statement.servicefacade.StatementServiceFacade;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/statement")
public class TotalTrialBalanceController {
	@Autowired
	private StatementServiceFacade statementServiceFacade;

	@GetMapping("/totalTrialBalances")
	public ResponseEntity<HashMap<String, Object>> getTotalTrialBalance(@RequestParam("searchDate") String toDate) {

		HashMap<String, Object> param = new HashMap<>();
			try{
				HashMap<String, Object> resultMap = statementServiceFacade.getTotalTrialBalance(toDate);
				ArrayList<TotalTrialBalanceBean>  result= (ArrayList<TotalTrialBalanceBean>)resultMap.get("RESULT");
				param.put("totaltrialList", result);
				return ResponseEntity.ok(param);
			}catch (Exception ex){
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

			}







	}
}
