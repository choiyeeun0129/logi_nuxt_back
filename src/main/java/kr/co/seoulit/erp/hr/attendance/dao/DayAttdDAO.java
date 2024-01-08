package kr.co.seoulit.erp.hr.attendance.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;

@Mapper
public interface DayAttdDAO {
	public ArrayList<DayAttdTO> selectDayAttdList(@Param("empCode") String empCode, @Param("applyDay")String applyDay);
	
	public void insertDayAttd(DayAttdTO dayAttd);

	public HashMap<String,Object> batchInsertDayAttd(HashMap<String, Object> map);
	
	public void deleteDayAttd(DayAttdTO dayAttd);
}
