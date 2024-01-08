package kr.co.seoulit.erp.hr.affair.dao;

import kr.co.seoulit.erp.hr.affair.to.EmpTO;
import kr.co.seoulit.erp.hr.affair.to.EmpUpdateTO;
import kr.co.seoulit.erp.hr.affair.to.RegistEMPTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Mapper
public interface EmpDAO {

	public EmpTO selectEmp(String empno);

	//updated 2022 resources/sqlMapper/hr/affair/sqlMapEmpDetailed.xml
	void updateEmp(EmpUpdateTO emp);

	public String selectLastEmpCode();

	public ArrayList<EmpTO> selectEmpList();

	public ArrayList<EmpTO> selectEmpListD(String dept);

	public ArrayList<EmpTO> selectEmpMemberListD(String dept);

	public ArrayList<EmpTO> selectEmpListN(String name);

	public String getEmpCode(String name);

	public void registEmployee(RegistEMPTO emp);

	public void updateEmployee(Map<String, ArrayList<EmpTO>> empArray);


	public void deleteEmployee(EmpTO emp);

	public ArrayList<EmpTO> selectEmployee(HashMap<String, String> map);

	public ArrayList<EmpTO> selectEmpAllList();

}