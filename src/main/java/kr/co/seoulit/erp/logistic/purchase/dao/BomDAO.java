package kr.co.seoulit.erp.logistic.purchase.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.purchase.to.BomDeployTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomInfoTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomTO;

@Mapper
public interface BomDAO {

	public ArrayList<BomInfoTO> selectBomInfoList(String parentItemCode);

	public ArrayList<BomInfoTO> selectAllItemWithBomRegisterAvailable();

	public void insertBom(BomTO TO);

	public void updateBom(BomTO TO);

	public void deleteBom(BomTO TO);

	public ArrayList<BomDeployTO> selectBomDeployList(HashMap<String, String> param);

	//dbs
	public ArrayList<BomDeployTO> selectBomDataList(HashMap<String, String> param);

}
