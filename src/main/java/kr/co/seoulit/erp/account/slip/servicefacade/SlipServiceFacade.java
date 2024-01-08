package kr.co.seoulit.erp.account.slip.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.account.slip.to.*;

public interface SlipServiceFacade {

    //황민상 정리시작
    //전표전체조회
    ArrayList<SlipBean> findSlipList();
    //전표한개조회
    SlipBean findSlipBySlipNo(String slipNo);
    //전표 등록 <미구현>
    String registerSlip(SlipBean slipBean);
    //전표삭제
    void deleteSlip(HashMap<String,ArrayList<SlipBean>> slipMap);
    //전표수정
    void updateSlip(SlipBean slipBean);
    //전표승인
    void approveSlip(String slipId,SlipBean slipBean);





    public ArrayList<SlipBean> findSlipDataList(String slipDate);

    public ArrayList<SlipBean> findRangedSlipList(HashMap<String,Object> map);


    public String addSlip(Map<String, SlipBean> slipData);

    public String hrAddSlip(Map<String,ArrayList<SlipBean>> batchArray);

    //분개

    public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);

    public ArrayList<JournalBean> findSingleJournalList(String slipNo);

    public void deleteJournalRow(String slipNo, String journalNo);

    public void updateJournalList(HashMap<String, ArrayList<JournalBean>> journalList); //분개 update 생성  조편백 2020-09-12

    public ArrayList<JournalDoubleBean> findJournalDoubleList(String fromDate, String toDate);


    //분개상세

    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo);

    public void addJournalDetailList(String journalNo);

    public void editJournalDetail(JournalDetailBean journalDetailBean);



}
