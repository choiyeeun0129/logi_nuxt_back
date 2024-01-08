package kr.co.seoulit.erp.account.statement.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.statement.to.CashJournalBean;

@Mapper
public interface CashJournalDAO {

    /************************ 2020.08.24 정대현 수정 **********************/
    public ArrayList<CashJournalBean> selectCashJournalList(HashMap<String, Object> param);
    /************************ 2020.08.24 정대현 수정 **********************/

}
