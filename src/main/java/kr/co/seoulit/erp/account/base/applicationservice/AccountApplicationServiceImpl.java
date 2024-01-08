package kr.co.seoulit.erp.account.base.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.account.slip.dao.JournalDAO;
import kr.co.seoulit.erp.account.slip.to.GeneralAccountLedgerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.base.dao.AccCustomerDAO;
import kr.co.seoulit.erp.account.base.dao.AccountDAO;
import kr.co.seoulit.erp.account.base.repository.AccountRepository;
import kr.co.seoulit.erp.account.base.to.Account;
import kr.co.seoulit.erp.account.base.to.AccountBean;
import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import kr.co.seoulit.erp.account.base.to.CustomerBean;
import kr.co.seoulit.erp.account.base.to.PeriodBean;
import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDetailDAO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.account.base.applicationservice.AccountApplicationServiceImpl;

@Component
public class AccountApplicationServiceImpl implements AccountApplicationService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private AccCustomerDAO customerDAO;
	@Autowired
	private LogiCodeDetailDAO codeDetailDAO;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private JournalDAO journalDAO;

//민상
//총계정원장

	@Override
	public ArrayList<GeneralAccountLedgerBean> findGeneralAccountLedgerList(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return journalDAO.selectGeneralAccountLedgerList(map);
	}


	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public ArrayList<AccountBean> findParentAccountList() {
		return accountDAO.selectParentAccountList();
	}

	public String selectPeriodNo(String toDay) {
		return accountDAO.selectPeriodNo(toDay);
	};

	public ArrayList<AccountBean> findDetailAccountList(String code) {
		return accountDAO.selectDetailAccountList(code);
	}

	@Override
	public void updateAccount(AccountBean accountBean) {
		accountDAO.updateAccount(accountBean);
	}

	@Override
	public ArrayList<AccountBean> getAccountListByName(String accountName) {
		return accountDAO.selectAccountListByName(accountName);
	}

	@Override
	public ArrayList<AccountControlBean> getAccountControlList(String accountCode) {
		return accountDAO.selectAccountControlList(accountCode);
	}

	@Override
	public List<AccountCodeBean> getAccountList() {
		return accountDAO.getAccountList();
	}

	// ========================================2020-09-19 조편백 코드 조회 시작
	// ================================================
	@Override
	public List<AccountBean> getAccount(String accountCode, String accountName) {

		System.out.println("zzzzzzzzzzzzzzzzzzzz" + accountCode);
		HashMap<String, Object> param = new HashMap<>();
		param.put("accountCode", accountCode);
		param.put("accountName", accountName);

		return accountDAO.selectAccount(param);
	}
	// ========================================2020-09-19 조편백 코드 조회 끝
	// ================================================

	// ===================================== 2020-08-25 계정별 원장 조편백 시작
	// ====================================
	@Override
	public HashMap<String, Object> getLedgerbyAccountInfo(String accountCode, String startDate, String endDate) {
		System.out.println("///////계정별원장 서비스임플 시작 ////// ");
		HashMap<String, Object> param = new HashMap<>();
		param.put("accountCode", accountCode);
		param.put("startDate", startDate);
		param.put("endDate", endDate);



		accountDAO.getLedgerbyAccountInfo(param);

		return param;
	}
	// ===================================== 2020-08-25 계정별 원장 조편백 끝
	// ====================================

	// ===================================== 2020-09-01 거래처관리 조편백 시작
	// ====================================
	@Override
	public List<CustomerBean> getCustomerList() {
		return customerDAO.selectCustomerList();
	}

	@Override
	public void deleteNormalCustormer(String customerCode) {
		System.out.println("1111111111111111111111111111111");
		customerDAO.deleteNormalAccount(customerCode);

		LogiCodeDetailTO detailCodeBean = new LogiCodeDetailTO();
		detailCodeBean.setDetailCode(customerCode);
		detailCodeBean.setDivisionCodeNo("CL-01");

		codeDetailDAO.deleteDetailCode(detailCodeBean);
	}

	@Override
	public void batchCustormerProcess(HashMap<String, ArrayList<CustomerBean>> customerList) {
		System.out.println("//////////오긴오나? //////");
		ArrayList<CustomerBean> batchCustormerList = customerList.get("customerList");
		for (CustomerBean bean : batchCustormerList) {
			System.out.println("////////////////" + bean);

			if ("insert".equals(bean.getStatus())) {
				System.out.println("////////  insert  ////////" + bean);
				// CUSTOMER 테이블
				bean.setWorkplaceCode("BRC-01");
				customerDAO.insertNormalAccount(bean);

				// CODE_DETAIL 테이블
				LogiCodeDetailTO detailCodeTo = new LogiCodeDetailTO();
				detailCodeTo.setDivisionCodeNo("CL-01");
				detailCodeTo.setDetailCode(bean.getCustomerCode());
				detailCodeTo.setDetailCodeName(bean.getCustomerName());
				codeDetailDAO.insertDetailCode(detailCodeTo);

			} else if ("update".equals(bean.getStatus())) {
				System.out.println("///////  update /////////" + bean);
				// CUSTOMER 테이블
				customerDAO.updateNormalAccount(bean);

				// CODE_DETAIL 테이블
				LogiCodeDetailTO detailCodeTo = new LogiCodeDetailTO();
				detailCodeTo.setDivisionCodeNo("CL-01");
				detailCodeTo.setDetailCode(bean.getCustomerCode());
				detailCodeTo.setDetailCodeName(bean.getCustomerName());
				codeDetailDAO.updateDetailCode(detailCodeTo);
			}
		}
	}
	// ===================================== 2020-09-01 거래처관리 조편백 끝
	// =======================================

	@Override
	public ArrayList<AccountBean> findDetailBudgetList(String code) {
		// TODO Auto-generated method stub
		return accountDAO.selectDetailBudgetList(code);
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList() {
		// TODO Auto-generated method stub
		return accountDAO.selectParentBudgetList();
	}

	@Override
	public ArrayList<PeriodBean> findAccountPeriodList() {
		// TODO Auto-generated method stub
		return accountDAO.selectAccountPeriodList();
	}

	// ===================================== 2020-11-28 계정과목관리 유길현 시작
	// ====================================
	// 계정관리목록 삭제
	@Override
	public void deleteAccountList(String accountInnerCode) {
		accountDAO.deleteAccountList(accountInnerCode);
	}

	// 계정관리목록 저장
	@Override
	public void batchAccountList(HashMap<String, ArrayList<AccountBean>> accountList) {
		ArrayList<AccountBean> batchAccountList = accountList.get("accountList");
		for (AccountBean bean : batchAccountList) {
			if ("insert".equals(bean.getStatus())) {
				System.out.println("////////  insert  ////////" + bean);
				accountDAO.insertAccountList(bean);

			} else if ("update".equals(bean.getStatus())) {
				System.out.println("///////  update /////////" + bean);
				accountDAO.updateAccountList(bean);

			}
		}
	}

	// ===================================== 2020-11-28 계정과목관리 유길현 끝
	// ======================================

	@Override
	public Account selectAccountName(String accountInnerCode) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountInnerCode(accountInnerCode);
	}

	@Override
	public List<Account>  getAccountCodeList() {

			return  accountRepository.findAll();
	}

	@Override
	public void registerAccountCode(AccountBean accountBean) {
		accountDAO.insertAccountList(accountBean);
	}

}
