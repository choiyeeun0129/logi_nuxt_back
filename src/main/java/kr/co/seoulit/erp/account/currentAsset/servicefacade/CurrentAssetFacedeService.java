package kr.co.seoulit.erp.account.currentAsset.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;

public interface CurrentAssetFacedeService {
	
	public ArrayList<AccountCodeBean> currentAssetCode();

	public ArrayList<CurrentAssetBean> findCurrentAssetList(HashMap<String, Object> params);
	public void insertCurrentAsset(HashMap<String, Object> params);

	void deleteCurrentAsset(String assetCode);

}
