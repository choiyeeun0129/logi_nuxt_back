package kr.co.seoulit.erp.account.slip.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import kr.co.seoulit.erp.account.slip.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.slip.applicationservice.SlipApplicationService;
import kr.co.seoulit.erp.account.slip.servicefacade.SlipServiceFacadeImpl;

@Service
public class SlipServiceFacadeImpl implements SlipServiceFacade {



	@Autowired
	private SlipApplicationService slipApplicationService;


	//황민상

	//전표만 전체조회
	@Override
	public ArrayList<SlipBean> findSlipList() {
		return slipApplicationService.findSlipList();
	}

	//전표 한개조회
	@Override
	public SlipBean findSlipBySlipNo(String slipNo) {
		return slipApplicationService.findSlipBySlipNo(slipNo);
	}

	//전표등록
	@Override
	public String registerSlip(SlipBean slipBean) {

		return slipApplicationService.registerSlip(slipBean);
	}


	//전표삭제
	@Override
	public void deleteSlip(HashMap<String,ArrayList<SlipBean>> slipMap) {

		slipApplicationService.deleteSlip(slipMap);
	}

	//전표수정
	@Override
	public void updateSlip(SlipBean slipBean) {
		slipApplicationService.updateSlip(slipBean);
	}
	//잔표승인
	@Override
	public void approveSlip(String slipId,SlipBean slipBean) {
		slipApplicationService.approveSlip(slipId,slipBean);
	}




	@Override
	public String addSlip(Map<String, SlipBean> batchArray) {
		return slipApplicationService.addSlip(batchArray);
	}




	@Override
	public ArrayList<SlipBean> findSlipDataList(String slipDate) {
		return slipApplicationService.findSlipDataList(slipDate);
	}

	@Override
	public ArrayList<SlipBean> findRangedSlipList(HashMap<String, Object> map) {
		return slipApplicationService.findRangedSlipList(map);
	}



	@Override
	public String hrAddSlip(Map<String, ArrayList<SlipBean>> batchArray) {
		return slipApplicationService.hrAddSlip(batchArray);
	}

	//분개


	@Override
	public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {

		return slipApplicationService.findRangedJournalList(fromDate, toDate);
	}

	@Override
	public ArrayList<JournalBean> findSingleJournalList(String slipNo) {
		return slipApplicationService.findSingleJournalList(slipNo);
	}

	// 조편백 분개삭제 생성 2020-09-07
	@Override
	public void deleteJournalRow(String slipNo, String journalNo) {
		slipApplicationService.deleteJournalRow(journalNo);

	}

	// 조편백 분개 update 2020-09-12
	@Override
	public void updateJournalList(HashMap<String, ArrayList<JournalBean>> journalList) {

		slipApplicationService.updateJournalList(journalList);
	}



	@Override
	public ArrayList<JournalDoubleBean> findJournalDoubleList(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return slipApplicationService.findJournalDoubleList(fromDate, toDate);
	}

	//분개상세


	@Override
	public void addJournalDetailList(String journalNo) {

		slipApplicationService.addJournalDetailList(journalNo);

	}

	@Override
	public void editJournalDetail(JournalDetailBean journalDetailBean) {

		slipApplicationService.editJournalDetail(journalDetailBean);

	}



	@Override
	public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
		System.out.println("나오나?" + journalNo);
		return slipApplicationService.getJournalDetailList(journalNo);
	}

}
