package kr.co.seoulit.erp.account.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.base.to.AccountBean;
import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import kr.co.seoulit.erp.account.base.to.PeriodBean;

@Mapper
public interface AccountDAO {
    
    public ArrayList<AccountBean> selectDetailAccountList(String code);

    public ArrayList<AccountBean> selectParentAccountList();

    public void updateAccount(AccountBean accountBean);
    
    public String selectPeriodNo(String toDay);

    ArrayList<AccountBean> selectAccountListByName(String accountName);

    ArrayList<AccountControlBean> selectAccountControlList(String accountCode);

	public List<AccountCodeBean> getAccountList();

	 //========================================2020-09-19 조편백 코드 조회 시작 ================================================
    public List<AccountBean> selectAccount(HashMap<String, Object> param);
    //========================================2020-09-19 조편백 코드 조회 끝 ================================================
    
    //=====================================  2020-08-25 계정별 원장 조편백   시작 ====================================
    public HashMap<String, Object> getLedgerbyAccountInfo(HashMap<String,Object> param);//계정별원장 
    //=====================================  2020-08-25 계정별 원장 조편백   끝  ====================================

	public ArrayList<AccountBean> selectDetailBudgetList(String code);

	public ArrayList<AccountBean> selectParentBudgetList();

	public ArrayList<PeriodBean> selectAccountPeriodList();
	//==========================================박미노=====================================================
	public ArrayList<AccountCodeBean> selectCurrentAssetList();
	//=====================================  2020-11-25 계정과목관리  유길현   시작 ====================================
    public void deleteAccountList(String accountInnerCode); // 계정관리목록 삭제
    public void insertAccountList(AccountBean bean); // 계정관리목록 추가
    public void updateAccountList(AccountBean bean);
    //=====================================  2020-11-25 계정과목관리  유길현   끝 ====================================

	
}