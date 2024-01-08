package kr.co.seoulit.erp.account.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.base.to.DetailBusinessBean;


@Mapper
public interface DetailBusinessDAO {

	public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode);
}
