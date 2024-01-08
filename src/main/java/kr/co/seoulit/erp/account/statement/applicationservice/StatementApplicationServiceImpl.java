package kr.co.seoulit.erp.account.statement.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.statement.dao.CashFlowStatementDAO;
import kr.co.seoulit.erp.account.statement.dao.CashJournalDAO;
import kr.co.seoulit.erp.account.statement.dao.CostStatementDAO;
import kr.co.seoulit.erp.account.statement.dao.DetailTrialBalanceDAO;
import kr.co.seoulit.erp.account.statement.dao.FinancialPositionDAO;
import kr.co.seoulit.erp.account.statement.dao.IncomeStatementDAO;
import kr.co.seoulit.erp.account.statement.dao.TotalTrialBalanceDAO;
import kr.co.seoulit.erp.account.statement.to.CashJournalBean;
import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;
import kr.co.seoulit.erp.account.statement.dao.MonthIncomeStatementDAO;

@Component
public class StatementApplicationServiceImpl implements StatementApplicationService {

	@Autowired
	private TotalTrialBalanceDAO totalTrialBalanceDAO;
	@Autowired
	private FinancialPositionDAO financialPositionDAO;
	@Autowired
	private DetailTrialBalanceDAO detailTrialBalanceDAO;
	@Autowired
	private CashJournalDAO cashJournalDAO;
	@Autowired
	private IncomeStatementDAO IncomeStatementDAO;
	@Autowired
	private CostStatementDAO CostStatementDAO;
	@Autowired
	private CashFlowStatementDAO CashFlowStatementDAO;
	@Autowired
	private MonthIncomeStatementDAO MonthIncomeStatementDAO;


//==========================2020-09-19 議고렪諛� �빀怨꾩옍�븸�떆�궛�몴 �닔�젙============================== 
	@Override
	public HashMap<String, Object> getTotalTrialBalance(String toDate) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("toDate", toDate);
		totalTrialBalanceDAO.callTotalTrialBalance(param);

		return param;

	}
	// ==========================2020-09-19 議고렪諛� �빀怨꾩옍�븸�떆�궛�몴 �닔�젙 �걹
	// ==============================

	public HashMap<String, Object> addEarlyStatements(String toDate) {

		return totalTrialBalanceDAO.addEarlyStatements(toDate);

	}

	@Override
	public HashMap<String, Object> getFinancialPosition(String toDate) {

		HashMap<String, Object> param = new HashMap<>();
		param.put("toDate", toDate);
		financialPositionDAO.callFinancialPosition(param);
		return param;
	}

	@Override
	public ArrayList<CashJournalBean> getCashJournal(String fromDate, String toDate) {

		/************************ 2020.08.24 �젙���쁽 �닔�젙 **********************/
		HashMap<String, Object> param = new HashMap<>();
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);
		return cashJournalDAO.selectCashJournalList(param);
		/************************ 2020.08.24 �젙���쁽 �닔�젙 **********************/

	}

	@Override
	public HashMap<String, Object> getIncomeStatement(String toDate) {
		System.out.println("寃잛씤而�  �뀭:" + toDate);
		HashMap<String, Object> param = new HashMap<>();
		param.put("toDate", toDate);
		IncomeStatementDAO.callIncomeStatement(param);
		return param;

	}

	@Override
	public ArrayList<DetailTrialBalanceBean> getDetailTrialBalance(String fromDate, String toDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);
		return detailTrialBalanceDAO.selectDetailTrialBalance(param);

	}

	@Override
	public HashMap<String, Object> getCostStatement(String toDate) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("toDate", toDate);
		CostStatementDAO.callCostStatement(param);
		System.out.println("寃잛씤而�  �뀭:" + param);
		return param;
	}
	
	//---------------2021-03-20 현금흐름표 송화준 시작-----------------
			@Override
			public HashMap<String, Object> getCashFlowStatement(String toDate) {
				HashMap<String, Object> param = new HashMap<>();
				param.put("toDate", toDate);
				CashFlowStatementDAO.callCashFlowStatement(param);
				System.out.println("겟인컴  ㅣ:" + param);
				return param;
			}
	//-------66기 월별손익계산서 시작 2021-06-01 --------------------
	@Override
	public HashMap<String, Object> getMonthIncomeStatement(String toDate) {
		HashMap<String, Object> param = new HashMap<>();
		String year = toDate.substring(0,4);
		param.put("year", year);
		MonthIncomeStatementDAO.callMonthIncomeStatement(param);
		return param;
	}
}