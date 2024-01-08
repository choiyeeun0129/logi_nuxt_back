package kr.co.seoulit.erp.logistic.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.base.to.WarehouseTO;

@Mapper
public interface WarehouseDAO {
	public ArrayList<WarehouseTO> selectWarehouseList();

	public void insertCode(WarehouseTO WarehouseTO);

	public void updateCode(WarehouseTO WarehouseTO);

	public void deleteCode(WarehouseTO WarehouseTO);

	public int createWarehouseCode();
}
