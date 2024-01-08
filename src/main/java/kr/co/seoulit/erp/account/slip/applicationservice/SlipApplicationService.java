package kr.co.seoulit.erp.account.slip.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.account.slip.to.*;

public interface SlipApplicationService {
    //황민상
	//전표전체조회
	 ArrayList<SlipBean> findSlipList();
	 //전표한개조회
	 SlipBean findSlipBySlipNo(String slipNo);
	 //전표등록
	 String registerSlip(SlipBean slipBean);
	//전표삭제
	 void deleteSlip(HashMap<String,ArrayList<SlipBean>> slipMap);
	 //전표수정
	 void updateSlip(SlipBean slipBean);
	 //전표승인
	void approveSlip(String slipId,SlipBean slipBean);
//====================================================================

	public ArrayList<SlipBean> findSlipDataList(String slipDate);

	public ArrayList<SlipBean> findRangedSlipList(HashMap<String, Object> map);

	public String addSlip(Map<String, SlipBean> batchArray);

	public String hrAddSlip(Map<String, ArrayList<SlipBean>> batchArray);

	//분개
	public ArrayList<JournalBean> findSingleJournalList(String slipNo);

	public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);

	public void deleteJournalRow(String journalNo);

	public void updateJournalList(HashMap<String, ArrayList<JournalBean>> journalList); // 조편백 분개 update 2020-09-12


	public ArrayList<JournalDoubleBean> findJournalDoubleList(String fromDate, String toDate);




	//분개상세

	public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo);

	public void addJournalDetailList(String journalNo);

	public void editJournalDetail(JournalDetailBean journalDetailBean);
}


