package kr.co.seoulit.erp.hr.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.base.to.BaseWorkTimeTO;

@Mapper
public interface BaseWorkTimeDAO {
	
	public ArrayList<BaseWorkTimeTO> selectBaseWorkTimeList();

	public void deleteBaseWorkTime(HashMap<String,Object> map);
	public void mergeBaseWorkTime(List<BaseWorkTimeTO> list);

}
