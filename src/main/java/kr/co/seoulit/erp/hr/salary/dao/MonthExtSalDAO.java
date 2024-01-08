package kr.co.seoulit.erp.hr.salary.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.MonthExtSalTO;

@Mapper

public interface MonthExtSalDAO {
	public ArrayList<MonthExtSalTO> selectMonthExtSalList(String applyYearMonth, String empCode);
}
