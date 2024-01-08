package kr.co.seoulit.erp.account.statement.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.statement.to.DetailTrialBalanceBean;


@Mapper
public interface DetailTrialBalanceDAO {

///////////////////////// 2020-08-24 김진호  수정///////////////////////////   
   ArrayList<DetailTrialBalanceBean> selectDetailTrialBalance(HashMap<String, String> param);
///////////////////////// 2020-08-24 김진호  끝///////////////////////////    

}