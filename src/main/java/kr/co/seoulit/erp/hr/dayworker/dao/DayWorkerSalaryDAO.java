package kr.co.seoulit.erp.hr.dayworker.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerSalaryTO;
@Mapper
public interface DayWorkerSalaryDAO { //21.12.24 YS
	public ArrayList<DayWorkerSalaryTO> selectDayWorkerSalaryList(@Param("empCode") String empCode, @Param("empName") String empName);

	public HashMap<String,Object> batchInsertDayWorkerSalary(HashMap<String, Object> map); //일급 프로시저 
	
	public HashMap<String,Object> batchInsertMonthWorkerSalary(HashMap<String, Object> map); //월급 프로시저
	
	//해당 데이터가 없으면 등록이 되지 않게 프로시저에서 처리하므로 삭제는 필요없다.
	//있는 사원에 한하여 급여를 계산하므로 수정 또한 필요없다. 
}
