package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.FamilyInfoTO;

@Mapper
public interface FamilyInfoDAO {
	public ArrayList<FamilyInfoTO> selectFamilyList(String code);

	public ArrayList<FamilyInfoTO> selectFamilyInfoList(String code);

	public void insertFamilyInfo(FamilyInfoTO familyInfo);

	public void updateFamilyInfo(FamilyInfoTO familyInfo);

	public void deleteFamilyInfo(FamilyInfoTO familyInfo);
}
