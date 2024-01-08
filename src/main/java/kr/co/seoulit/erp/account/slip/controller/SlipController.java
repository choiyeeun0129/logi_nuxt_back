package kr.co.seoulit.erp.account.slip.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import kr.co.seoulit.erp.account.slip.servicefacade.SlipServiceFacade;

import kr.co.seoulit.erp.account.slip.to.SlipBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/account/")
public class SlipController {
	@Autowired
	private SlipServiceFacade slipServiceFacade;





	/// 황민상 restapi
	//GET 전체조회
	@GetMapping("/slips")
	public ResponseEntity<Map<String,Object>>  findSlipList() {
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<SlipBean> SlipList = slipServiceFacade.findSlipList();
		if(SlipList.size()==0){
			return ResponseEntity.notFound().build(); //없을경우
		}

		map.put("SlipList", SlipList);

		return ResponseEntity.ok(map);
	}
	//한개조회
	@GetMapping("/slips/{slipNo}")
	public ResponseEntity<Map<String,Object>> findSlipBySlipNo(@PathVariable String slipNo) {

		Map<String,Object> result=new HashMap<>();

		SlipBean slipBean=slipServiceFacade.findSlipBySlipNo(slipNo);
		//생성자보다는 builder패턴 사용!! 추천
		if(slipBean==null){
			return ResponseEntity.notFound().build(); //없을경우
		}
		result.put("slipForm",slipBean);
		return ResponseEntity.ok()
				.body(result);
	}


	//POST  등록
	@PostMapping("/slips")
	public ResponseEntity<Map<String,Object>> registerSlip(@RequestBody SlipBean slipBean) {
		HashMap<String, Object> map = new HashMap<>();
		String slipNo = slipServiceFacade.registerSlip(slipBean);

		map.put("newSlipNo",slipNo);
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	//delete  삭제
	@DeleteMapping("/slips")
	public ResponseEntity<Map<String,Object>>  deleteSlip(@RequestBody HashMap<String,ArrayList<SlipBean>> slipMap) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			slipServiceFacade.deleteSlip(slipMap);
			map.put("errorMsg","삭제되었습니다");
		}catch (Exception e){
			map.put("errorMsg","삭제실패하였습니다");
		}

		return ResponseEntity.ok(map);
	}
	//전표 분개 분개상세 전체수정
	@PutMapping("/slips")
	public ResponseEntity<Map<String,Object>> updateSlip(@RequestBody SlipBean slipBean) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			slipServiceFacade.updateSlip(slipBean);
			map.put("updateSlipNo",slipBean.getSlipNo());
			return ResponseEntity.ok(map);
		}catch (Exception e){
			map.put("errorMsg","업데이트실패하였습니다");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}

	}
	//전표 승인
	@PutMapping("/slips/{slipId}")
	public ResponseEntity<Map<String,Object>> approvalSlip(@PathVariable String slipId,@RequestBody SlipBean slipBean) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			slipServiceFacade.approveSlip(slipId,slipBean);
			map.put("updateSlipNo",slipBean.getSlipNo());
			return ResponseEntity.ok(map);
		}catch (Exception e){
			map.put("errorMsg","업데이트실패하였습니다");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}

	}




	// ===================================== 일반전표 전표 품의내역수정 update 2020-09-14 조편백 시작
	// ====================================
	@RequestMapping(value = "/updateSlip", method = RequestMethod.GET)
	public HashMap<String, Object> updateSlip(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			SlipBean slipBean = new SlipBean();
			slipBean.setSlipNo((String) param.get("slipNo"));
			slipBean.setSlipType((String) param.get("slipType"));
			slipBean.setExpenseReport((String) param.get("expenseReport"));
			slipServiceFacade.updateSlip(slipBean);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return map;

	}

	@RequestMapping(value = "/hrAddSlip", method = RequestMethod.POST)
	public HashMap<String, Object> hrAddSlip(@RequestBody Map<String, ArrayList<SlipBean>> batchArray) {

		HashMap<String, Object> map = new HashMap<>();
		System.out.println(batchArray);

		try {

			String slipNo = slipServiceFacade.hrAddSlip(batchArray);

			map.put("slipNo", slipNo);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");

			// System.out.println(slipNo + " : 잘된거 같네 ㅎ.ㅎ");
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
			e2.printStackTrace();
		}
		return map;
	}

	// ===================================== 일반전표 분개저장 insert 2020-09-14 조편백 시작
	// ====================================
	@RequestMapping(value = "/addSlip", method = RequestMethod.POST)
	public HashMap<String, Object> addSlip(@RequestBody Map<String, SlipBean> slipData) {

		HashMap<String, Object> map = new HashMap<>();
		System.out.println("=================================================" + slipData);

		try {
			String slipNo = slipServiceFacade.addSlip(slipData);
			map.put("slipNo", slipNo);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
			e2.printStackTrace();
		}
		return map;
	}

	// ===================================== 일반전표 전표 삭제 2020-09-14 조편백 시작
	// ====================================




	// ===================================== 일반전표 전표 조회 2020-09-14 조편백 시작
	// ====================================
	@RequestMapping(value = "/findRangedSlipList", method = RequestMethod.GET)
	public ArrayList<SlipBean> findRangedSlipList(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> map = new HashMap<>();
		ArrayList<SlipBean> slipbean = null;
		try {
			slipbean = slipServiceFacade.findRangedSlipList(param);
			map.put("slipList", slipbean);
			map.put("errorCode", 0);
			map.put("errorMsg", "등록완료");
		} catch (Exception e2) {
			map.put("errorCode", -1);
			map.put("errorMsg", e2.getMessage());
		}
		return slipbean;
	}




}
