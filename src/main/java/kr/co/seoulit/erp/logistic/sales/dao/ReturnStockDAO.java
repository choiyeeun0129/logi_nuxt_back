package kr.co.seoulit.erp.logistic.sales.dao;

import kr.co.seoulit.erp.logistic.sales.to.ReturnStockTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface ReturnStockDAO {
    public ArrayList<ReturnStockTO> searchReturnStockList(String itemCode);

//    public ArrayList<ReturnTO> returnListForStock();
//
//    public void updateReturn(ReturnTO TO);

    public void deleteReturnStock(String rtrnRecNo);

    // 최신 반품재고입고 번호 조회
    public String getRtrnRecMaxNo();

    void addReturnStock(Map<String, Object> params);

}
