package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IncomeStatementDAO {
    public HashMap<String, Object> callIncomeStatement(HashMap<String, Object> param);
}
