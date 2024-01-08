package kr.co.seoulit.erp.logistic.production.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;
import org.springframework.ui.ModelMap;

@Mapper
public interface MrpGatheringDAO {

	public ArrayList<MrpGatheringTO> getMrpGathering(String mrpNoList);

	public ArrayList<MrpGatheringTO> selectMrpGatheringCount(String mrpGatheringRegisterDate);

	public void insertMrpGathering(MrpGatheringTO TO);

	public void updateMrpGathering(MrpGatheringTO TO);

	public void deleteMrpGathering(MrpGatheringTO TO);

	public ArrayList<MrpGatheringTO> selectMrpGatheringList(HashMap<String, String> param);

	public int selectMrpGatheringSeqCount();

	public void updateMrpGatheringContract(HashMap<String, String> parameter);

}
