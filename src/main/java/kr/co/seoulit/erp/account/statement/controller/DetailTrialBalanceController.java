package kr.co.seoulit.erp.account.statement.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.account.statement.servicefacade.StatementServiceFacade;
import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/statement")
public class DetailTrialBalanceController  {
   @Autowired
    private StatementServiceFacade statementServiceFacade;
  
///////////////////////// 2022-03-23 황민상///////////////////////////
   //일(월)계표
    @GetMapping("/detailTrialBalances")
    public ResponseEntity<HashMap<String, Object>> handleRequestInternal(
            @RequestParam("startDate")String fromDate
            ,@RequestParam("endDate")String toDate) {

        HashMap<String, Object> param = new HashMap<>();
        ArrayList<DetailTrialBalanceBean> detailTrialBalanceList = statementServiceFacade.getDetailTrialBalance(fromDate, toDate);

        if(detailTrialBalanceList.size()==0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(param);
        }
        param.put("detailTrialBalanceList", detailTrialBalanceList);
        return ResponseEntity.ok(param);
    }

    
}