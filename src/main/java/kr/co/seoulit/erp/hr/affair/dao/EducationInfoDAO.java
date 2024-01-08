package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.EducationInfoTO;

@Mapper
public interface EducationInfoDAO {
	public ArrayList<EducationInfoTO> selectEducationList(String code);

	public ArrayList<EducationInfoTO> selectEducationInfoList(String code);

	public void insertEducationInfo(EducationInfoTO educationInfo);

	public void updateEducationInfo(EducationInfoTO educationInfo);

	public void deleteEducationInfo(EducationInfoTO educationInfo);
}
