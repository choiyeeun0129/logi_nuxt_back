package kr.co.seoulit.erp.account.currentAsset.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;

@Mapper
public interface CurrentAssetDAO {
	ArrayList<CurrentAssetBean> selectCurrentAssetList(HashMap<String, Object> param);
	
	int selectNoncurrentAssetCount(String accountCode);

	void insertCurrentAsset(HashMap<String, Object> currentAssetBean);
	
	void deleteCrrentAsset(String assetCode);
	
	void updateCurrentAsset(HashMap<String, Object> currentAssetBean);
	
}

