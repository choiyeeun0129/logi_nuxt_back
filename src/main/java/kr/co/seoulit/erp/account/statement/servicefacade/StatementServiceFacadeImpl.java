package kr.co.seoulit.erp.account.statement.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.statement.applicationservice.StatementApplicationService;
import kr.co.seoulit.erp.account.statement.to.CashJournalBean;
import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;

@Service
public class StatementServiceFacadeImpl implements StatementServiceFacade {

	@Autowired
	private StatementApplicationService statementApplicationService;

	@Override
	public HashMap<String, Object> getTotalTrialBalance(String toDate) {
		return statementApplicationService.getTotalTrialBalance(toDate);
	}

	@Override
	public HashMap<String, Object> getIncomeStatement(String toDate) {
		return statementApplicationService.getIncomeStatement(toDate);
	}

	@Override
	public HashMap<String, Object> getFinancialPosition(String toDate) {
		return statementApplicationService.getFinancialPosition(toDate);
	}

	@Override
	public ArrayList<CashJournalBean> getCashJournal(String fromDate, String toDate) {
		return statementApplicationService.getCashJournal(fromDate, toDate);
	}
	
	@Override
	public HashMap<String, Object> addEarlyStatements(String toDate) {
		return statementApplicationService.addEarlyStatements(toDate);
	}

	@Override
	public ArrayList<DetailTrialBalanceBean> getDetailTrialBalance(String fromDate, String toDate) {
		return statementApplicationService.getDetailTrialBalance(fromDate, toDate);
	}

	@Override
	public HashMap<String, Object> getCostStatement(String toDate) {
		// TODO Auto-generated method stub
		return statementApplicationService.getCostStatement(toDate);
	}
	
	@Override
	public HashMap<String, Object> getCashFlowStatement(String toDate) {
		// TODO Auto-generated method stub
		return statementApplicationService.getCashFlowStatement(toDate);
	}
	
	@Override
	public HashMap<String, Object> getMonthIncomeStatement(String toDate) {
		return statementApplicationService.getMonthIncomeStatement(toDate);
		
	}
}
