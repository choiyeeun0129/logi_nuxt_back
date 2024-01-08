package kr.co.seoulit.erp.hr.salary.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;

@Mapper
public interface SeverancePayDAO {
	public ArrayList<SeveranceTO> selectSeverancePayList(String empName);
}
