package kr.co.seoulit.erp.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.sys.to.SysCodeTo;

@Mapper
public interface CodeDao {
	
	public List<SysCodeTo> selectCodeList();
	
}
