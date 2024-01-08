package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.BestEmpTO;

@Mapper
public interface BestEmpDAO {

	public ArrayList<BestEmpTO> getBestEmp();

}
