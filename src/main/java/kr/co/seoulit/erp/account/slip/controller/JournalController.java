package kr.co.seoulit.erp.account.slip.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.slip.servicefacade.SlipServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import kr.co.seoulit.erp.account.slip.to.GeneralAccountLedgerBean;
import kr.co.seoulit.erp.account.slip.to.JournalBean;
import kr.co.seoulit.erp.account.slip.to.JournalDoubleBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/account")
public class JournalController {

	@Autowired
	private SlipServiceFacade slipServiceFacade;


	/**
	 * 황민상
	 * 분개장 조회
	 * journalDoubleList.size()==1  0이 아닌 1인 이유?
	 * 커리문보시면 합계를 구해오는 부분이 있습니다. 그 부분은 조회가 되든 안되든 무조건 나오기떄문에 검색 결과가 없을경우 실질적으로 1
	 * 그래서 1로 비교
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	@GetMapping( "/journal")
	public ResponseEntity<ArrayList<JournalDoubleBean>> findJournalDoubleList(
			@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate) {

		ArrayList<JournalDoubleBean> journalDoubleList = slipServiceFacade.findJournalDoubleList(fromDate, toDate);
		if(journalDoubleList.size()==1){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(journalDoubleList);

	}



	// ===================================== 일반전표 분개조회 2020-09-14 조편백 시작
	@RequestMapping(value = "/account/findSingleJournalList", method = RequestMethod.GET)
	public HashMap<String, Object> findSingleJournalList(@RequestParam String slipNo) {

		HashMap<String, Object> map = new HashMap<>();

		try {
			if (slipNo != "null") {
				ArrayList<JournalBean> journalList = slipServiceFacade.findSingleJournalList(slipNo);
				System.out.println("journalList  " + journalList);
				map.put("journalList", journalList);
				map.put("errorCode", 0);
				map.put("errorMsg", "errorMsg");
			}
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}

		return map;
	}

	// ===================================== 일반전표 분개삭제생성 XML까지 (XML은 수정 ) 2020-09-07
	// 조편백 시작
	@RequestMapping(value = "/account/deleteJournalRow")
	public void deleteJournalRow(@RequestParam String slipNo, @RequestParam String journalNo) {

		slipServiceFacade.deleteJournalRow(slipNo, journalNo);

	}

	// ===================================== 일반전표 분개 update생성 2020-09-12 조편백 시작
	@RequestMapping(value = "/account/updateJournalList", method = RequestMethod.POST)
	public void updateJournalList(@RequestBody HashMap<String, ArrayList<JournalBean>> journalList) {

		slipServiceFacade.updateJournalList(journalList);
	}


}
