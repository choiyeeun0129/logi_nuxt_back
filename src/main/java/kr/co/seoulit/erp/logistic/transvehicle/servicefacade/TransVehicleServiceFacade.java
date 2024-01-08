package kr.co.seoulit.erp.logistic.transvehicle.servicefacade;

import kr.co.seoulit.erp.logistic.transvehicle.to.TransVehicleTO;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.Map;

public interface TransVehicleServiceFacade {
    public ModelMap allTransVehicleList();

    public ModelMap getTransVehicleList(String type);

    Map<String, Object> addNewVehicle(Map<String, Object> params);
    public void updateTransVehicle(TransVehicleTO transList);

   public void deleteTransVehicle(String vehicleNumber);


//    public void deleteSelectedItem(String itemCode);
//    public void deleteSelectedItemGroup(String itemGroupCode);
//    public void updateItemGroup(ItemGroupTO batchList);
//    public ModelMap searchItemGroupList();
//    public void batchListProcess(ItemTO batchList);
//    public void itemGroupBatchListProcess(ItemGroupTO batchList);
}
