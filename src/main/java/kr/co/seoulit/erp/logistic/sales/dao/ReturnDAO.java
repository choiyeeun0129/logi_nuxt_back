package kr.co.seoulit.erp.logistic.sales.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.logistic.sales.to.ReturnTO;

@Mapper
public interface ReturnDAO {
    public ArrayList<ReturnTO> getReturnList(HashMap<String, String> param);

    public ArrayList<ReturnTO> returnListForStock();

    public void updateReturn(ReturnTO TO);

    public void deleteReturn(String returnNo);

    // 최신 반품번호 조회
    public String getReturnMaxNo();

    void addReturn(Map<String, Object> params);

}
