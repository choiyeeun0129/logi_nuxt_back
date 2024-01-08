package kr.co.seoulit.erp.account.statement.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.statement.to.CashJournalBean;
import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;

public interface StatementApplicationService {

    HashMap<String, Object> addEarlyStatements(String toDate);
	
    HashMap<String, Object> getTotalTrialBalance(String toDate);

    HashMap<String, Object> getIncomeStatement(String toDate);

    HashMap<String, Object> getFinancialPosition(String toDate);
    
    ArrayList<DetailTrialBalanceBean> getDetailTrialBalance(String fromDate, String toDate);
    
    ArrayList<CashJournalBean> getCashJournal(String fromDate, String toDate);

    HashMap<String, Object> getCostStatement(String toDate);

    HashMap<String, Object> getCashFlowStatement(String toDate);

    HashMap<String, Object> getMonthIncomeStatement(String toDate);
}