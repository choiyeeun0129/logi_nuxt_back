package kr.co.seoulit.erp.account.statement.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.statement.to.CashJournalBean;
import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;

public interface StatementServiceFacade {
	public HashMap<String, Object> addEarlyStatements(String toDate);

	public HashMap<String, Object> getTotalTrialBalance(String toDate);

	public HashMap<String, Object> getFinancialPosition(String toDate);

	public HashMap<String, Object> getIncomeStatement(String toDate);

	public ArrayList<CashJournalBean> getCashJournal(String fromDate, String toDate);
	
	public ArrayList<DetailTrialBalanceBean> getDetailTrialBalance(String fromDate, String toDate);

	public HashMap<String, Object> getCostStatement(String toDate);

	public HashMap<String, Object> getCashFlowStatement(String toDate);
	
	public HashMap<String, Object> getMonthIncomeStatement(String toDate);
}
