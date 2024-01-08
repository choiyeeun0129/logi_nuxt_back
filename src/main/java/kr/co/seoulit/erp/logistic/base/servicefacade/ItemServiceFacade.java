package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Map;

public interface ItemServiceFacade {

    public ModelMap searchItemList();
    public ModelMap searchItem(String itemCode);
    public void updateItem(ItemTO batchList);
    public void deleteSelectedItem(String itemCode);
    public void deleteSelectedItemGroup(String itemGroupCode);
    public void updateItemGroup(ItemGroupTO batchList);
    public ModelMap searchItemGroupList();
    public void batchListProcess(ItemTO batchList);
    public void itemGroupBatchListProcess(ItemGroupTO batchList);

}
