package kr.co.seoulit.erp.account.currentAsset.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.dao.AccountDAO;
import kr.co.seoulit.erp.account.base.to.AccountBean;
import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.currentAsset.dao.CurrentAssetDAO;
import kr.co.seoulit.erp.account.currentAsset.dao.CurrentAssetDetailDAO;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetDetailBean;

 
@Component
public class CurrentAssetApplicationServiceImpl implements  CurrentAssetApplicationService{

	
	@Autowired 
	private AccountDAO accountDAO; 
	@Autowired 
	private CurrentAssetDAO currentAssetDAO; 
	@Autowired 
	private CurrentAssetDetailDAO currentAssetDetailDAO; 
	
	@Override
	public ArrayList<AccountCodeBean> currentAssetCode(){
		return accountDAO.selectCurrentAssetList();
	} 
	@Override
	public ArrayList<CurrentAssetBean> findCurrentAssetList(HashMap<String, Object> params){
		System.out.println("@@##!3!:::::"+params.get("params"));
		
		HashMap<String, Object> param =new HashMap<String, Object>();
		param=(HashMap<String, Object>) params.get("params");
		
		ArrayList<CurrentAssetBean> findCurrentAssetList=currentAssetDAO.selectCurrentAssetList(param);
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+findCurrentAssetList);
		 return currentAssetDAO.selectCurrentAssetList(param);  
	}
	@Override
	public void insertCurrentAsset(HashMap<String, Object> params) {

		System.out.println("$$$$$$$$$$$$$$$$"+params.get("params"));
		
		HashMap<String,Object> currentAssetBean=(HashMap<String,Object>)params.get("params");
		StringBuffer assetCode = new StringBuffer();
		System.out.println("########???????????????????????"+currentAssetBean.get("accountCode"));
		String accountCode=(String) currentAssetBean.get("accountCode");
		String checkStatus=(String) currentAssetBean.get("checkStatus");
		HashMap<String,Object> currentAssetDetailBean=(HashMap<String,Object>)currentAssetBean.get("currentAssetDetailBean");
		String code="0"+(currentAssetDAO.selectNoncurrentAssetCount(accountCode)+1)+"" ; 
		assetCode.append(currentAssetBean.get("accountCode"));
		assetCode.append("MH");
		assetCode.append(code); 
		
		if(checkStatus.equals("insert")) {
		
		currentAssetBean.remove("assetCode");
		currentAssetBean.put("assetCode",assetCode.toString());
		System.out.println(currentAssetBean.get("assetCode"));
		currentAssetDAO.insertCurrentAsset(currentAssetBean);
		currentAssetDetailBean.put("assetCode",assetCode.toString());
		
		System.out.println(currentAssetDetailBean+"#$#@::::");
		currentAssetDetailDAO.insertCurrentAssetDetail(currentAssetDetailBean);
		}if(checkStatus.equals("update")) {
			System.out.println("수정");
			currentAssetDetailBean.put("assetCode",currentAssetBean.get("assetCode").toString());
			currentAssetDAO.updateCurrentAsset(currentAssetBean);
			currentAssetDetailDAO.updateCurrentAssetDetail(currentAssetDetailBean);
		}
	} 
	@Override
	public void deleteCurrentAsset(String assetCode){
		currentAssetDAO.deleteCrrentAsset(assetCode);
		currentAssetDetailDAO.deleteCrrentAssetDetail(assetCode);
	}

} 
