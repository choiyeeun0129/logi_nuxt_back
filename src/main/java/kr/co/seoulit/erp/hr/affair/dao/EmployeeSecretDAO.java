package kr.co.seoulit.erp.hr.affair.dao;

import kr.co.seoulit.erp.hr.affair.to.EmployeeSecretTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface EmployeeSecretDAO {

	public void insertEmployeeSecret(EmployeeSecretTO TO);

	public int selectUserPassWordCount(String companyCode, String empCode);

	public EmployeeSecretTO selectUserPassWord(HashMap<String, String> map);

	public ArrayList<EmployeeSecretTO> selectEmployeeSecretList(HashMap<String, Object> param);

}
