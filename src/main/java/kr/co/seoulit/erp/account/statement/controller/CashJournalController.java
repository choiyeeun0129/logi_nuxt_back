package kr.co.seoulit.erp.account.statement.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.statement.servicefacade.StatementServiceFacade;
import kr.co.seoulit.erp.account.statement.to.CashJournalBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/statement")
public class CashJournalController {

	@Autowired
	private StatementServiceFacade statementServiceFacade;

	@GetMapping( "/cashJournals")
	public ResponseEntity<HashMap<String, Object>> handleRequestInternal(
			@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate) {

		HashMap<String, Object> param = new HashMap<>();
		ArrayList<CashJournalBean> cashJournalList = statementServiceFacade.getCashJournal(fromDate, toDate);
		if(cashJournalList.size()==2){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(param);
		}
		param.put("cashJournalList",cashJournalList);
		return ResponseEntity.ok(param);
	}

}
