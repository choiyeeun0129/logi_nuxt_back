package kr.co.seoulit.erp.logistic.base.dao;

import java.util.ArrayList;
import java.util.Map;

import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.base.to.ItemInfoTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;

@Mapper
public interface ItemDAO {
	public ArrayList<ItemTO> searchItemList();
	 public ItemTO searchItem(String itemCode);

	public ArrayList<ItemGroupTO> searchItemGroupList();

	public void insertItem(ItemTO TO);

	public void updateItem(ItemTO TO);

	public void deleteItem(ItemTO TO);

	public void deleteSelectedItem(String itemCode);

	public void insertItemGroup(ItemGroupTO TO);

	public void updateItemGroup(ItemGroupTO TO);
	public void deleteSelectedItemGroup(String itemGroupCode);

	public void deleteItemGroup(ItemGroupTO TO);
	//이하는 이전에 있던 method

	public int getStandardUnitPrice(String itemCode);

	public int getStandardUnitPriceBox(String itemCode);

	public ArrayList<ItemInfoTO> selectOptionItemList();

	public ArrayList<ItemInfoTO> selectAllItemList();

	public ArrayList<ItemInfoTO> selectItemList(Map<String, String> params);

}
