package kr.co.seoulit.erp.hr.dayworker.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;

@Mapper
public interface DayWorkerDAO {
	public ArrayList<DayWorkerTO> selectDayWorkerList(@Param("empCode") String empCode, @Param("empName") String empName);
	
	public void insertDayWorker(DayWorkerTO dayworker);

	public void deleteDayWorker(DayWorkerTO dayworker);

	
}
