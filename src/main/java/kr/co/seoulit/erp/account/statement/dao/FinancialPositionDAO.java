package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinancialPositionDAO {
    public HashMap<String, Object> callFinancialPosition(HashMap<String, Object> param);
}
