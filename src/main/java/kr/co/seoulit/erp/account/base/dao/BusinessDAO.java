package kr.co.seoulit.erp.account.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.base.to.BusinessBean;

@Mapper
public interface BusinessDAO {

    public ArrayList<BusinessBean> selectBusinessList();
}
