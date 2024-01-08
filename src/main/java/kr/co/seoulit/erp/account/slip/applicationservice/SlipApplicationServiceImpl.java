package kr.co.seoulit.erp.account.slip.applicationservice;

import java.util.*;


import kr.co.seoulit.erp.account.slip.repository.JournalDetailRepository;
import kr.co.seoulit.erp.account.slip.repository.JournalRepository;
import kr.co.seoulit.erp.account.slip.repository.SlipReposiotry;
import kr.co.seoulit.erp.account.slip.to.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.slip.dao.SlipDAO;
import kr.co.seoulit.erp.hr.salary.dao.MonthSalaryDAO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;
import kr.co.seoulit.erp.logistic.sales.dao.DeliveryDAO;
import kr.co.seoulit.erp.logistic.sales.to.DeliveryInfoTO;
import kr.co.seoulit.erp.account.slip.applicationservice.SlipApplicationServiceImpl;
import kr.co.seoulit.erp.account.slip.dao.JournalDAO;
import kr.co.seoulit.erp.account.slip.dao.JournalDetailDAO;
@RequiredArgsConstructor
@Component
public class SlipApplicationServiceImpl implements SlipApplicationService {


	private final SlipDAO slipDAO;

	private final JournalDAO journalDAO;

	private final JournalDetailDAO journalDetailDAO;

	private final DeliveryDAO deliveryDAO;

	private final MonthSalaryDAO monthSalaryDAO;

	 private final SlipReposiotry slipReposiotry;

	 private  final JournalRepository journalRepository;
	private final JournalDetailRepository journalDetailRepository;

	//2022년 3.2~.3.31 vue Project <황민상>
	//전표 전제조회
	@Override
	public ArrayList<SlipBean> findSlipList() {

		ArrayList<SlipBean> all =(ArrayList<SlipBean>)slipReposiotry.findAll();
		return all;
	}
	//전표한개조회
	@Override
	public SlipBean findSlipBySlipNo(String slipNo) {
		Optional<SlipBean> slipbean = slipReposiotry.findById(slipNo);
		if(!slipbean.isPresent()){
			throw new RuntimeException("존재하지않는 전표입니다");
		}
		ArrayList<JournalBean> journalList = journalDAO.selectJournalList(slipNo);
		journalList.forEach(journalBean->
				journalBean.setJournalDetailList(journalDetailRepository.findByJournalNo(journalBean.getJournalNo())));
		SlipBean slipBean = slipbean.get();
		slipBean.setJournalList(journalList);
		return slipBean;
	}
	//전표삭제
	@Override
	public void deleteSlip(HashMap<String,ArrayList<SlipBean>> slipMap) {
		ArrayList<SlipBean> slipList = slipMap.get("slipList");
		slipList.forEach(slipEntity->{
			slipReposiotry.delete(slipEntity);
		});


	}

	//전표등록

	@Override
	public String registerSlip(SlipBean slipBean) {

		StringBuffer slipNo = new StringBuffer();
		String slipNoDate = slipBean.getReportingDate().replace("-", "");
		slipNo.append(slipNoDate);
		slipNo.append("SLIP"); // 20190717SLIP

		ArrayList<JournalBean> journalList = slipBean.getJournalList();

		String code = "0000" + (slipDAO.selectSlipCount(slipNoDate) + 1) + "";
		slipNo.append(code.substring(code.length() - 5));
		slipBean.setSlipNo(slipNo.toString());


		slipReposiotry.save(slipBean);


		for (JournalBean journalBean : journalList) {
			String SlipNo = slipBean.getSlipNo();
			String journalNo = journalDAO.selectJournalName(SlipNo);
			journalBean.setSlipNo(SlipNo);
			journalBean.setJournalNo(journalNo);
			journalBean.setAccountInnerCode(journalBean.getAccountCode());
			journalDAO.insertJournal(journalBean);


			for(JournalDetailBean journalDetailBean : journalBean.getJournalDetailList()) {

				journalDetailBean.setJournalNo(journalBean.getJournalNo());
				journalDetailRepository.save(journalDetailBean);
			}


		}
		return slipNo.toString();

	}
	//전표수정
	@Override
	public void updateSlip(SlipBean slipBean) {

			slipReposiotry.save(slipBean);

		for(JournalBean journalBean: slipBean.getJournalList()){
			journalDAO.updateJournal(journalBean);

			for(JournalDetailBean journalDetailBean: journalBean.getJournalDetailList()){
				journalDetailRepository.save(journalDetailBean);
			}
		}
		slipDAO.updateSlip(slipBean);
	}
 //전표승인
	@Override
	public void approveSlip(String slipId, SlipBean slipBean) {
		Optional<SlipBean> slipbean = slipReposiotry.findById(slipId);
		if(!slipbean.isPresent()){
			throw  new RuntimeException(String.format("해당 [%s] 전표는 존재하지않습니다",slipBean.getSlipNo()));
		}
		slipReposiotry.save(slipBean);

	}
	//분개장
	@Override
	public ArrayList<JournalDoubleBean> findJournalDoubleList(String fromDate, String toDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return journalDAO.selectJournalDoubleList(map);
	}




	@Override
	public ArrayList<SlipBean> findSlipDataList(String slipDate) {

		return slipDAO.selectSlipDataList(slipDate);
	}

	@Override
	public String addSlip(Map<String, SlipBean> batchArray) {
		HashMap<String, String> map = new HashMap<>();
		SlipBean slipList = batchArray.get("slipData");
       ArrayList<JournalBean> journalList = null;
		SlipBean slipBean = slipList;
		StringBuffer slipNo = new StringBuffer();
		String slipNoDate = slipBean.getReportingDate().replace("-", ""); // 20190717
		slipNo.append(slipNoDate);
		slipNo.append("SLIP"); // 20190717SLIP

		journalList = slipBean.getJournalList();

		String code = "0000" + (slipDAO.selectSlipCount(slipNoDate) + 1) + ""; // 00003

		slipNo.append(code.substring(code.length() - 5)); // 00003
		slipBean.setSlipNo(slipNo.toString()); // 20190717SLIP00003
		slipBean.setApprovalEmpCode("");
		slipBean.setApprovalDate("");

		slipDAO.insertSlip(slipBean);

		for (JournalBean journalBean : journalList) {
			String SlipNo = slipBean.getSlipNo();
			String journalNo = journalDAO.selectJournalName(SlipNo);
			journalBean.setSlipNo(SlipNo);
			journalBean.setJournalNo(journalNo);
			journalDAO.insertJournal(journalBean);
			journalDetailDAO.insertJournalDetailList(journalNo);

		}

		return slipNo.toString();
	}


//	@Override
//	public void approveSlip(ArrayList<SlipBean> slipBeans) {
//		HashMap<String, String> slipNoList = new HashMap<String, String>();
//		ArrayList<JournalSeparatorBean> jouranlSetartor = new ArrayList<JournalSeparatorBean>();
//		DeliveryInfoTO deliveryInfo = new DeliveryInfoTO();
//		MonthSalaryTO monthSalary = new MonthSalaryTO();
//		System.out.println("slipBeans:::::::::" + slipBeans.get(0));
//		for (SlipBean slipBean : slipBeans) { // 분개저장 승인 반려 확인
//			slipDAO.approveSlip(slipBean);
//			slipNoList.put(slipBean.getSlipNo(), slipBean.getSlipStatus());
//		}
//
//		for (String te : slipNoList.keySet()) { // 임금,납품 반려시 마감완료되었던것 N으로 바꿔주는 작업
//			System.out.println("testtesttesttesttesttest" + te);
//			System.out.println("(String)slipNoList.get(te)" + (String) slipNoList.get(te));
//			String divison = (String) slipNoList.get(te);
//
//			if (divison.equals("반려")) {
//				System.out.println("들가나???");
//				jouranlSetartor = journalDAO.selectJournalSeparator(te);
//				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//				for (JournalSeparatorBean jsr : jouranlSetartor) {
//					if (jsr.getDeliveryNo() != null) {
//						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//
//						deliveryInfo.setDeliveryNo(jsr.getDeliveryNo());
//						deliveryInfo.setFinalizeStatus("N");
//						System.out.println("$$$$$$$$$$$$$$$$$$:::::" + deliveryInfo);
//						deliveryDAO.deliverUpdate(deliveryInfo);
//					} else if (jsr.getEmpCode() != null) {
//						monthSalary.setApplyYearMonth(jsr.getApplyYearMonth());
//						monthSalary.setEmpCode(jsr.getEmpCode());
//						monthSalary.setFinalizeStatus("N");
//						monthSalaryDAO.updateMonthSalary(monthSalary);
//					}
//				}
//			}
//		}
//		System.out.println("#$$$zzzzzzzzzzzzzzzzzzzzz::" + jouranlSetartor);
//		System.out.println("jouranlSetartor:::::" + jouranlSetartor);
//	}

	@Override
	public ArrayList<SlipBean> findRangedSlipList(HashMap<String, Object> map) {

		System.out.println(" 전표 서비스임플  ");

		return slipDAO.selectRangedSlipList(map);
	}



	@Override
	public String hrAddSlip(Map<String, ArrayList<SlipBean>> batchArray) {

		ArrayList<SlipBean> slipList = batchArray.get("slipData");
		ArrayList<JournalBean> journalList = null;

		SlipBean slipBean = slipList.get(0);

		StringBuffer slipNo = new StringBuffer();
		String slipNoDate = slipBean.getReportingDate().replace("-", ""); // 20190717
		slipNo.append(slipNoDate);
		slipNo.append("SLIP"); // 20190717SLIP

		journalList = slipBean.getJournalList();

		String code = "0000" + (slipDAO.selectSlipCount(slipNoDate) + 1) + ""; // 00003

		slipNo.append(code.substring(code.length() - 5)); // 00003
		slipBean.setSlipNo(slipNo.toString()); // 20190717SLIP00003
		slipBean.setApprovalEmpCode("");
		slipBean.setApprovalDate("");
		slipDAO.insertSlip(slipBean);

		for (JournalBean journalBean : journalList) {
			String SlipNo = slipBean.getSlipNo();
			String journalNo = journalDAO.selectJournalName(SlipNo);
			journalBean.setSlipNo(SlipNo);
			journalBean.setJournalNo(journalNo);
			journalDAO.insertJournal(journalBean);
			journalDetailDAO.insertJournalDetailList(journalNo);
		}

		return slipNo.toString();
	}

	//분개
	@Override
	public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return journalDAO.selectRangedJournalList(map);
	}

	@Override
	public ArrayList<JournalBean> findSingleJournalList(String slipNo) {

		return journalDAO.selectJournalList(slipNo);
	}

	// ===================================== 일반전표 분개삭제생성 XML까지 (XML은 수정 ) 2020-09-07
	// 조편백 시작 ====================================
	@Override
	public void deleteJournalRow(String journalNo) {
		journalDAO.deleteJournal(journalNo);

	}

	// ===================================== 일반전표 분개update 생성 2020-09-12 조편백 시작
	// ====================================
	@Override
	public void updateJournalList(HashMap<String, ArrayList<JournalBean>> journalList) {

		ArrayList<JournalBean> journalLists = journalList.get("journalList");

		for (JournalBean newJournalBeans : journalLists) {

			System.out.println("분개저장 UPDATE 서비스임플 : " + newJournalBeans);
			journalDAO.updateJournal(newJournalBeans);
		}
	}





	//분개상세

	@Override
	public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
		System.out.println("나오나1?" + journalNo);
		return journalDetailDAO.selectJournalDetailList(journalNo);
	}

	@Override
	public void addJournalDetailList(String journalNo) {

		journalDetailDAO.insertJournalDetailList(journalNo);

	}

	@Override
	public void editJournalDetail(JournalDetailBean journalDetailBean) {

		journalDetailDAO.updateJournalDetail(journalDetailBean);

	}

}
