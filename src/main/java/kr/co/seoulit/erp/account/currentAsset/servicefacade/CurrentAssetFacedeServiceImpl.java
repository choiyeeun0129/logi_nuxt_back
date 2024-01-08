package kr.co.seoulit.erp.account.currentAsset.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.currentAsset.applicationservice.CurrentAssetApplicationService;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;

@Service
public class CurrentAssetFacedeServiceImpl  implements CurrentAssetFacedeService{
	@Autowired
	private CurrentAssetApplicationService currentAssetApplicationService;
	@Override
	public ArrayList<AccountCodeBean> currentAssetCode(){
		return currentAssetApplicationService.currentAssetCode();
	} 
	@Override
	public ArrayList<CurrentAssetBean> findCurrentAssetList(HashMap<String, Object> params){
		return currentAssetApplicationService.findCurrentAssetList(params);
	}
	@Override
	public void insertCurrentAsset(HashMap<String, Object> params) {
		
		currentAssetApplicationService.insertCurrentAsset(params);
	}
	@Override
	public void deleteCurrentAsset(String assetCode){
		currentAssetApplicationService.deleteCurrentAsset(assetCode);
	}



}
