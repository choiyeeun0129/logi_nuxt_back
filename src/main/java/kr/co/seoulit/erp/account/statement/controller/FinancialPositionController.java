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
public class FinancialPositionController {
    @Autowired
	private StatementServiceFacade statementServiceFacade;
  
    @GetMapping("/financialPositions")
    public ResponseEntity<HashMap<String, Object>> getFinancialPosition(@RequestParam("searchDate")String toDate){

    HashMap<String, Object> param =new HashMap<>();
	try {

        HashMap<String, Object> result = statementServiceFacade.getFinancialPosition(toDate);

		param.put("financialPositionList", result.get("RESULT"));

        return ResponseEntity.ok(param);
		} catch(Exception e){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	           }

    }
    
    
    @RequestMapping(value="/addearlystatements", method = RequestMethod.POST)
	public void addearlystatements(@RequestParam("toDate")String toDate) {
		
          //  HashMap<String, Object> financialPosition = statementServiceFacade.addEarlyStatements(toDate);
          statementServiceFacade.addEarlyStatements(toDate);
    }

}

