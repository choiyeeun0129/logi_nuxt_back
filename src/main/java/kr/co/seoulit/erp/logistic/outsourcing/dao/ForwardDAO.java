package kr.co.seoulit.erp.logistic.outsourcing.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;

@Mapper
public interface ForwardDAO {

public HashMap<String,Object> getReleaseSimulationList(HashMap<String,Object> param);

public void updateStock(HashMap<String, String> map);

public void updateStatus(String mrpGatheringNo);

public ArrayList<OutsourcTO> selectForwardableList();

public ArrayList<OutsourcTO> searchForwardableList();

public void deleteTemp(HashMap<String, String> map);

public ArrayList<OutsourcTO> selectForwardStatus(String mrpGatheringNo);

    public ArrayList<OutsourcTO> searchForwardInfoList(HashMap<String, String> param);

    public ArrayList<OutsourcTO> searchForwardInfoList2();
}
	
