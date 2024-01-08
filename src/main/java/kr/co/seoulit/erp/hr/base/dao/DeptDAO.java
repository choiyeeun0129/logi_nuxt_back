package kr.co.seoulit.erp.hr.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.base.to.DeptTO;

@Mapper
public interface DeptDAO {
	public ArrayList<DeptTO> selectDeptList();
	
	public void updateDept(DeptTO dept);
	public void registDept(DeptTO dept);
	public void deleteDept(DeptTO dept);

	public ArrayList<DeptTO> selectEmpList();
}
