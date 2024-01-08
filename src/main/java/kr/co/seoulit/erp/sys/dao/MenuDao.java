package kr.co.seoulit.erp.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.sys.to.MenuTo;

@Mapper
public interface MenuDao {
	
	public List<MenuTo> selectMenuList();
	
}
