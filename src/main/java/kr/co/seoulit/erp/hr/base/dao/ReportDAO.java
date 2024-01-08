package kr.co.seoulit.erp.hr.base.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.base.to.ReportTO;

@Mapper
public interface ReportDAO {
	 public ReportTO selectReport(String empCode);
}