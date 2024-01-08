package kr.co.seoulit.erp.hr.company.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;

@Mapper
public interface LogiWorkplaceDAO {
	
	public ArrayList<WorkplaceTO> selectWorkplaceList(String companyCode);

	public void insertWorkplace(WorkplaceTO TO);
	
	public void updateWorkplace(WorkplaceTO TO);
	
	public void deleteWorkplace(WorkplaceTO TO);
}
