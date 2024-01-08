package kr.co.seoulit.erp.hr.salary.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;

@Mapper
public interface MonthSalaryDAO {
	public ArrayList<MonthSalaryTO> selectYearSalary(HashMap<String, Object> map);

	public HashMap<String, Object> batchMonthSalaryProcess(HashMap<String, Object> map);

	public void updateMonthSalary(MonthSalaryTO monthSalary);

	public void findMonthSalaryProcess(HashMap<String, Object> map);
}
