package kr.co.seoulit.erp.account.currentAsset.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetDetailBean;

@Mapper
public interface CurrentAssetDetailDAO {
	public CurrentAssetDetailBean selectAssetDetail(String assetCode);
	void insertCurrentAssetDetail(HashMap<String, Object> currentDetailAssetBean);
	void deleteCrrentAssetDetail(String assetCode);
	void updateCurrentAssetDetail(HashMap<String, Object> currentDetailAssetBean);
}
