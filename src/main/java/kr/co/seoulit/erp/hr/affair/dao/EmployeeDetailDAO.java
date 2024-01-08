package kr.co.seoulit.erp.hr.affair.dao;

import kr.co.seoulit.erp.hr.affair.to.EmployeeDetailTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface EmployeeDetailDAO {

	public ArrayList<EmployeeDetailTO> selectUserIdList(String companyCode);

	public void insertEmployeeDetail(EmployeeDetailTO TO);

	public ArrayList<EmployeeDetailTO> selectEmployeeDetailList(HashMap<String, Object> param);

	ArrayList<EmployeeDetailTO> selectEmployeeDetail(String empCode);

}
