package kr.co.seoulit.erp.account.slip.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.slip.to.JournalDetailBean;

@Mapper
public interface JournalDetailDAO {

    ArrayList<JournalDetailBean> selectJournalDetailList(String journalNo);

//	public JournalDetailBean selectJournalDetail(String journalDetailNo);

   public void deleteJournalDetailByJournalNo(String journalNo);

   public void updateJournalDetail(JournalDetailBean journalDetailBean);

   public void insertJournalDetailList(String journalNo);

}
