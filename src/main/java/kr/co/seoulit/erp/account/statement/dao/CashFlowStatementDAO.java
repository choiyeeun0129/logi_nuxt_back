package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashFlowStatementDAO {
    public HashMap<String, Object> callCashFlowStatement(HashMap<String, Object> param);
}
