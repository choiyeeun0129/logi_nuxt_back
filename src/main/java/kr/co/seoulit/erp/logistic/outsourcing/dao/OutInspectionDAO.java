package kr.co.seoulit.erp.logistic.outsourcing.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.outsourcing.to.OutInspectionTO;

@Mapper
public interface OutInspectionDAO {
	
	public ArrayList<OutInspectionTO> selectOutInspectionInfoList();
	
	public HashMap<String, Object> outInspectionCompletion(HashMap<String, Object> param);
	
}
