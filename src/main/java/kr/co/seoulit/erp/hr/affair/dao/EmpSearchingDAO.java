package kr.co.seoulit.erp.hr.affair.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.EmpInfoTO;
import kr.co.seoulit.erp.hr.affair.to.EmployeeSecretTO;

@Mapper
public interface EmpSearchingDAO {

	public EmpInfoTO getTotalEmpInfo(HashMap<String, String> map);

	public EmployeeSecretTO selectAllEmpList(HashMap<String, Object> param);

}
