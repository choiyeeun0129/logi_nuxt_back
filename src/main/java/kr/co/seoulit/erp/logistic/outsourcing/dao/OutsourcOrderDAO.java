package kr.co.seoulit.erp.logistic.outsourcing.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;
import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;

@Mapper
public interface OutsourcOrderDAO {

	public ArrayList<MrpGatheringTO> selectMrpGatheringList(HashMap<String, String> param);

	public int getStandardUnitPrice(String itemCode);

	public void insertOutsourc(ArrayList<OutsourcTO> outsourcList);

	public void updateMrpGathering(ArrayList<OutsourcTO> outsourcList);

	public ArrayList<OutsourcTO> selectOutsourcList(HashMap<String, String> param);

	public ArrayList<OutsourcTO> selectOutsourcInfoList(HashMap<String, String> param);

	public void updateNecessaryAmount(HashMap<String, Object> map);

	public ArrayList<OutsourcTO> selectOutsourcInfoList();

    public HashMap<String, Object> updateForwardStatus(HashMap<String, String> outsourcNo);
}
