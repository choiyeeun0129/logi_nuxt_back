package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.affair.to.AssignEmpTO;

@Mapper
public interface EmpAssignDAO {
	public void insertAssign(HashMap<String, String> map);

	public ArrayList<AssignEmpTO> selectAssignList(@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	public void updateDeptCode(HashMap<String, String> map);
}
