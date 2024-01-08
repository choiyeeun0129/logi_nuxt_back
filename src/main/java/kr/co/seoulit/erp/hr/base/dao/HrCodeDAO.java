package kr.co.seoulit.erp.hr.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.base.to.HrCodeTO;

@Mapper
public interface HrCodeDAO {
	   public ArrayList<HrCodeTO> selectCode();
}
