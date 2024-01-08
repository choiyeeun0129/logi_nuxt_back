package kr.co.seoulit.erp.hr.base.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;


@Mapper
public interface HrDetailCodeDAO {
	public ArrayList<HrDetailCodeTO> selectDetailCodeList(String codetype);
	public ArrayList<HrDetailCodeTO> selectDetailCodeListRest(@Param("code1")String code1,@Param("code2")String code2,@Param("code3")String code3);

	public void updateDetailCode(HrDetailCodeTO detailCodeto);
	public void registDetailCode(HrDetailCodeTO detailCodeto);
	public void deleteDetailCode(HrDetailCodeTO detailCodeto);
	
}