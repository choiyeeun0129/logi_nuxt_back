package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.dao.ItemDAO;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

@Slf4j
@Service
public class ItemServiceFacadeImpl implements ItemServiceFacade{

    @Autowired
    private ItemDAO itemDAO;

    private ModelMap modelMap = new ModelMap();

    @Override
    public ModelMap searchItemList() {
        ArrayList<ItemTO> itemList=itemDAO.searchItemList();
        try{
            modelMap.put("gridRowJson", itemList); //명칭통일필요
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public ModelMap searchItem(String itemCode) {
        ItemTO itemTo=itemDAO.searchItem(itemCode);
        try{
            modelMap.put("itemTo", itemTo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public void updateItem(ItemTO batchList) {
        itemDAO.updateItem(batchList);
    }

    @Override
    public void deleteSelectedItem(String itemCode) {
        itemDAO.deleteSelectedItem(itemCode);
    }

    @Override
    public ModelMap searchItemGroupList() {
        ArrayList<ItemGroupTO> itemGroupList = itemDAO.searchItemGroupList();
        try{
            modelMap.put("gridRowJson", itemGroupList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public void updateItemGroup(ItemGroupTO batchList) {
        itemDAO.updateItemGroup(batchList);
    }
    @Override
    public void deleteSelectedItemGroup(String itemGroupCode) {
        itemDAO.deleteSelectedItemGroup(itemGroupCode);
    }

    @Override
    public void batchListProcess(ItemTO batchList) {
        String status=batchList.getStatus();
        switch(status){

            case "INSERT":
                itemDAO.insertItem(batchList);
                break;

            case "UPDATE":
                itemDAO.updateItem(batchList);
                break;

            case "DELETE":
                itemDAO.deleteItem(batchList);
        }
    }

    @Override
    public void itemGroupBatchListProcess(ItemGroupTO batchList) {
        String status=batchList.getStatus();
        switch(status){

            case "INSERT":
                itemDAO.insertItemGroup(batchList);
                break;

            case "UPDATE":
                itemDAO.updateItemGroup(batchList);
                break;

            case "DELETE":
                itemDAO.deleteItemGroup(batchList);
        }
    }
}
