package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.account.base.to.*;
import kr.co.seoulit.erp.account.slip.to.GeneralAccountLedgerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.applicationservice.AccountApplicationService;
import kr.co.seoulit.erp.account.base.applicationservice.AccountApplicationServiceImpl;
import kr.co.seoulit.erp.account.base.servicefacade.AccountServiceFacade;
import kr.co.seoulit.erp.account.base.servicefacade.AccountServiceFacadeImpl;

@Service
public class AccountServiceFacadeImpl implements AccountServiceFacade{
 
   @Autowired
    private AccountApplicationService accountApplicationService;


	@Override
	public ArrayList<GeneralAccountLedgerBean> findGeneralAccountLedgerList(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return accountApplicationService.findGeneralAccountLedgerList(fromDate, toDate);
	}


	
    @Override
    public ArrayList<AccountBean> findParentAccountList() {
           
        return accountApplicationService.findParentAccountList();
    }

    @Override
    public ArrayList<AccountBean> findDetailAccountList(String code) {
       
        return accountApplicationService.findDetailAccountList(code);
    }

    @Override
    public void updateAccount(AccountBean accountBean) {
      
            accountApplicationService.updateAccount(accountBean);         
    }

    public String findPeriodNo(String toDay) {
    	return accountApplicationService.selectPeriodNo(toDay);
    }
    
    @Override
    public ArrayList<AccountBean> getAccountListByName(String accountName) {
         
        return accountApplicationService.getAccountListByName(accountName);
    }

    @Override
    public ArrayList<AccountControlBean> getAccountControlList(String accountCode) {

        return accountApplicationService.getAccountControlList(accountCode);
            
    }

	@Override
	public List<AccountCodeBean> getAccountList() {
		return accountApplicationService.getAccountList();
	}
	
	 //========================================2020-09-19 조편백 코드 조회 시작 ================================================
		@Override
	    public List<AccountBean> getAccount(String accountCode,String accountName) {
	   
	        return accountApplicationService.getAccount(accountCode ,accountName);
	    }
		//========================================2020-09-19 조편백 코드 조회 끝 ================================================
		
		
    //=====================================  2020-08-25 계정별 원장 조편백   시작 ====================================
	@Override
	public HashMap<String, Object> getLedgerbyAccountInfo(String accountCode, String startDate, String endDate) {
		
		return accountApplicationService.getLedgerbyAccountInfo(accountCode, startDate,endDate);
	}
	//=====================================  2020-08-25 계정별 원장 조편백   끝 =======================================
	
    //=====================================  2020-09-01 거래처관리   조편백   시작 ======================================
	@Override
	public List<CustomerBean> getCustomerList(){
		return accountApplicationService.getCustomerList();
	}
	@Override
	public void deleteNormalCustormer(String customerCode ) {
		 accountApplicationService.deleteNormalCustormer(customerCode);	 
	}
	@Override
	public void batchCustormerProcess(HashMap<String, ArrayList<CustomerBean>> customerList) {
		accountApplicationService.batchCustormerProcess(customerList);	
	}
	//=====================================  2020-09-01 거래처관리  조편백   끝 ========================================

	@Override
	public ArrayList<AccountBean> findDetailBudgetList(String code) {
		// TODO Auto-generated method stub
		return accountApplicationService.findDetailBudgetList(code);
	}

	@Override
	public ArrayList<AccountBean> findParentBudgetList() {
		// TODO Auto-generated method stub
		return accountApplicationService.findParentBudgetList();
	}

	@Override
	public ArrayList<PeriodBean> findAccountPeriodList() {
		// TODO Auto-generated method stub
		return accountApplicationService.findAccountPeriodList();
	}
	
	//=====================================  2020-11-25 계정과목관리  유길현  시작  ======================================
	// 계정과목관리 삭제
	@Override
	public void deleteAccountList(String accountInnerCode) {
		accountApplicationService.deleteAccountList(accountInnerCode);
	}
		
	// 계정과목관리 저장
	@Override
	public void batchAccountList(HashMap<String, ArrayList<AccountBean>> accountList) {
		accountApplicationService.batchAccountList(accountList);
	}

	//계정과목가져오기
	@Override
	public List<Account> getAccountCodeList() {
		return accountApplicationService.getAccountCodeList();
	}

	@Override
	public void registerAccountCode(AccountBean accountBean) {
		accountApplicationService.registerAccountCode(accountBean);
	}
	//=====================================  2020-11-25 계정과목관리  유길현  끝  ======================================
}