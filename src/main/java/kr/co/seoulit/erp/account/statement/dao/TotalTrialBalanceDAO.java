package kr.co.seoulit.erp.account.statement.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.statement.to.TotalTrialBalanceBean;


@Mapper
public interface TotalTrialBalanceDAO {

	public HashMap<String, Object> addEarlyStatements(String toDate);
    public List<TotalTrialBalanceBean> callTotalTrialBalance(HashMap<String,Object> param);

}
