package kr.co.seoulit.erp.account.currentAsset.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;


public interface CurrentAssetApplicationService {
	public ArrayList<AccountCodeBean> currentAssetCode();
	
	public ArrayList<CurrentAssetBean> findCurrentAssetList(HashMap<String, Object> params);

	public void insertCurrentAsset(HashMap<String, Object> params);

	void deleteCurrentAsset(String assetCode);


}
