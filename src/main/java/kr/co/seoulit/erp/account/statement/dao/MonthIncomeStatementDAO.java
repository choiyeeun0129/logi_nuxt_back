package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MonthIncomeStatementDAO {
    public HashMap<String, Object> callMonthIncomeStatement(HashMap<String, Object> param);
}
