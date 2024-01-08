package kr.co.seoulit.erp.hr.attendance.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.attendance.to.RestAttdTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

@Mapper
public interface RestAttdDAO {
	public ArrayList<RestAttdTO> selectRestAttdListByToday(String empCode, String toDay);

	public ArrayList<RestAttdTO> selectRestAttdList(HashMap<String, Object> map);

	public ArrayList<RestAttdTO> selectRestAttdListCode(HashMap<String, Object> map);

	public ArrayList<RestAttdTO> selectRestAttdListByDept(HashMap<String, String> attdApplMap); 			

	public ArrayList<RestAttdTO> selectRestAttdListByAllDept(String applyDay);

	public void insertRestAttd(RestAttdTO restAttd);

	public void updateRestAttd(HashMap<String, String> attdApplMap); 

	public void deleteRestAttd(HashMap<String, String> params);

	public void deleteRestAttdlist(ArrayList<RestAttdTO> restAttdList);

	public ArrayList<HrDetailCodeTO> selectRestDatailCodeName();
}
