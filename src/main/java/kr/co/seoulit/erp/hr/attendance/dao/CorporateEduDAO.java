package kr.co.seoulit.erp.hr.attendance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.attendance.to.CorporateEduTO;;

@Mapper
public interface CorporateEduDAO {

	public List<CorporateEduTO> selectClassList(); 
	
	public CorporateEduTO selectClass(String classCode); 

	public void insertClass(CorporateEduTO classData);
	
	public void updateClass(CorporateEduTO classData);
	
	public void deleteClass(String classCode);
}
