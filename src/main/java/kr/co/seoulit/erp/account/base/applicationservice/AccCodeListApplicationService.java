package kr.co.seoulit.erp.account.base.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import kr.co.seoulit.erp.account.base.to.CodeBean;
import kr.co.seoulit.erp.account.base.to.DetailCodeBean;

public interface AccCodeListApplicationService {

	public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, Object> param);

	public ArrayList<CodeBean> findCodeList();

	public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeBean> codeList2);

    ArrayList<AccountControlBean> getControllerCodeList();
}
