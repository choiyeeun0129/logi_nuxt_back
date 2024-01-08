package kr.co.seoulit.erp.hr.attendance.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.attendance.to.annualVacationMgtTO;

@Mapper
public interface AnnualVacationDAO {

	public HashMap<String, Object> batchAnnualVacationMgtProcess(HashMap<String, Object> startDate);

	public void updateAnnualVacationMgtList(annualVacationMgtTO annualVacationMgtList);

}