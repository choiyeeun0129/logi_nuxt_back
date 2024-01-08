package kr.co.seoulit.erp.logistic.production.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.production.to.OpenMrpTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.production.to.MrpTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MrpDAO {

	public List<MpsTO> getMpsList(@Param("startDate") String startDate,
								  @Param("endDate") String endDate);

	public void updateMps(MpsTO mpsTO);


	public ArrayList<MrpTO> selectMrpListAll(String mrpGatheringStatusCondition);

	public ArrayList<MrpTO> selectMrpListAsMrpGatheringNo(String mrpGatheringNo);

	public List<MrpTO> selectMrpCount(String mrpRegisterDate);

	public void insertMrp(MrpTO TO);

	public void updateMrp(MrpTO TO);

	public void deleteMrp(MrpTO TO);

	public ArrayList<MrpTO> selectMrpList(HashMap<String, String> param);

	public void openMrp(HashMap<String, Object> resultMap);

	public void changeMrpGatheringStatus(HashMap<String, String> param);

	/**
	 * mpsDAO에서 이동
	 */
	public void changeMrpApplyStatus(HashMap<String, String> param);

}
