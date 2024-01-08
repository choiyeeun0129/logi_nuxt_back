package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CostStatementDAO {
    public HashMap<String, Object> callCostStatement(HashMap<String, Object> param);
}
