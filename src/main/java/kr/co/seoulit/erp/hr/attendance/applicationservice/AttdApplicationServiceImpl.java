package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.attendance.dao.AnnualVacationDAO;
import kr.co.seoulit.erp.hr.attendance.dao.DayAttdDAO;
import kr.co.seoulit.erp.hr.attendance.dao.DayAttdMgtDAO;
import kr.co.seoulit.erp.hr.attendance.dao.MonthAttdMgtDAO;
import kr.co.seoulit.erp.hr.attendance.dao.RestAttdDAO;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;
import kr.co.seoulit.erp.hr.attendance.to.MonthAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.RestAttdTO;
import kr.co.seoulit.erp.hr.attendance.to.annualVacationMgtTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

@Component
public class AttdApplicationServiceImpl implements AttdApplicationService {

	@Autowired
	private DayAttdDAO dayAttdDAO;
	@Autowired
	private RestAttdDAO restAttdDAO;
	@Autowired
	private DayAttdMgtDAO dayAttdMgtDAO;
	@Autowired
	private MonthAttdMgtDAO monthAttdMgtDAO;
	@Autowired
	private AnnualVacationDAO annualVacationDAO;

	//�뜝�럩占썲뜝�럡�맟
		public void findAnnualVacationMgtList(ModelMap modelMap) {

			annualVacationDAO.batchAnnualVacationMgtProcess(modelMap);

		}
		@Override
		public void modifyAnnualVacationMgtList(ModelMap modelMap) {

			ArrayList<annualVacationMgtTO> annualVacationMgtList = (ArrayList<annualVacationMgtTO>) modelMap
					.get("annualVacationMgt");
			System.out.println("=================�뿰李④�由� 留덇컧======================");

			for (annualVacationMgtTO annualVacationMgt : annualVacationMgtList) {
				System.out.println("�뿰李�::" + annualVacationMgt);
				if (annualVacationMgt.getFinalizeStatus().equals("N")) {
					annualVacationMgt.setFinalizeStatus("Y");
					annualVacationDAO.updateAnnualVacationMgtList(annualVacationMgt);
				} else if (annualVacationMgt.getFinalizeStatus().equals("Y")) {
					annualVacationMgt.setFinalizeStatus("N");
					annualVacationDAO.updateAnnualVacationMgtList(annualVacationMgt);
				}
			}
		}

	@Override
	public ArrayList<DayAttdTO> findDayAttdList(String empCode, String applyDay) {
		// TODO Auto-generated method stub

		ArrayList<DayAttdTO> dayAttdList = dayAttdDAO.selectDayAttdList(empCode, applyDay);

		for (DayAttdTO dayAttdTO : dayAttdList) {
			String time = dayAttdTO.getTime();
			if (time.length() == 3) {
				StringBuffer t1 = new StringBuffer(time);
				t1.insert(1, ":");
				String t2 = t1.toString();
				dayAttdTO.setTime(t2);
			} else if (time.length() == 4) {
				StringBuffer tt1 = new StringBuffer(time);
				tt1.insert(2, ":");
				String tt2 = tt1.toString();
				dayAttdTO.setTime(tt2);

			}

		}
		System.out.println(dayAttdList);

		return dayAttdList;
	}

	@Override
	public HashMap<String, Object> registDayAttd(DayAttdTO dayAttd) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("empCode", dayAttd.getEmpCode());
		map.put("attdTypeCode", dayAttd.getAttdTypeCode());
		map.put("attdTypeName", dayAttd.getAttdTypeName());
		map.put("applyDay", dayAttd.getApplyDay());
		map.put("time", dayAttd.getTime());
		System.out.println(
				"�뜝�럥�맶�뜝�럥�쑅�뜝�럡�맖�뜝�럥�맶�뜝�럥�쑅�뜝�럡萸뉛옙�쐻占쎈윥占쎈젗占쎈쐻占쎈윥�얘퍜�삕占쎄뎡�뜝�럥�맶�뜝�럥�쑋占쎌뼚짹占쎌맶�뜝�럥�쑅占쎈쐻占쎈쑆占쎈솕�뜝�럩援뀐옙�쐻占쎈윪獄�釉앹삕占쎌맶�뜝�럥�쐾�뜝�럥占싼띿삕占쎌맶�뜝�럥�쑅占쎈쨨�뜝占�"
						+ map);

		return dayAttdDAO.batchInsertDayAttd(map);

	}

//@Override
//public void removeDayAttdList(ArrayList<DayAttdTO> dayAttdList) {
//	// TODO Auto-generated method stub
//	
//	for(DayAttdTO dayAttd : dayAttdList){
//		dayAttdDAO.deleteDayAttd(dayAttd);
//	}
//	
//	
//}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay) {

		ArrayList<RestAttdTO> restAttdList = restAttdDAO.selectRestAttdListByToday(empCode, toDay);
		return restAttdList;
	}

	@Override
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList) {

		// TODO Auto-generated method stub
		for (DayAttdMgtTO dayAttdMgt : dayAttdMgtList) {
			if (dayAttdMgt.getStatus().equals("update")) {
				dayAttdMgt.setFinalizeStatus("Y");
				dayAttdMgtDAO.updateAttd(dayAttdMgt);
			} else if (dayAttdMgt.getStatus().equals("cancel")) {
				dayAttdMgt.setFinalizeStatus("N");
				dayAttdMgtDAO.updateAttd(dayAttdMgt);
			}
		}
	}

	@Override
	public ArrayList<MonthAttdMgtTO> findMonthAttdMgtList(String applyYearMonth) {
		// TODO Auto-generated method stub

		HashMap<String, Object> map = new HashMap<>();
		map.put("applyYearMonth", applyYearMonth);
		monthAttdMgtDAO.batchMonthAttdMgtProcess(map);
		@SuppressWarnings("unchecked")
		ArrayList<MonthAttdMgtTO> monthAttdMgtList = (ArrayList<MonthAttdMgtTO>) map.get("result");
		System.out.println(monthAttdMgtList);

		return monthAttdMgtList;
	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String, String> attdApplMap) {
		// TODO Auto-generated method stub
		ArrayList<RestAttdTO> restAttdList = null;
//		HashMap<String, Object> map = new HashMap<>();
//		
//		if(deptName.equals("�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕�占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첑占쎈쐻占쎈윞�굜�굝�쐻占쎈윥鸚룐뫅�삕占쎈�占쎄콬�뜝�럡�렊占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈뭵占쎈쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�")) {
//			restAttdList = restAttdDAO.selectRestAttdListByAllDept(startDate);
//		}else {
//			map.put("deptName", deptName);
//			map.put("startDate", startDate);
//			map.put("endDate", endDate);
		restAttdList = restAttdDAO.selectRestAttdListByDept(attdApplMap);
//		}

		return restAttdList;
	}

	@Override
	public void registRestAttd(RestAttdTO restAttd) {
		// TODO Auto-generated method stub

		restAttdDAO.insertRestAttd(restAttd);

	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdList(String empCode, String startDate, String endDate, String code) {
		// TODO Auto-generated method stub

		ArrayList<RestAttdTO> restAttdList = null;
		HashMap<String, Object> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("startDate", startDate);
		map.put("endDate", endDate);

		System.out.println("empCode+" + "/" + "startDate+" + "/" + "endDate");
		System.out.println(empCode + "/" + startDate + "/" + endDate);

		if (code == "")
			restAttdList = restAttdDAO.selectRestAttdList(map);
		else {
			map.put("code", code);
			restAttdList = restAttdDAO.selectRestAttdListCode(map);
		}
		return restAttdList;
	}

//	@Override
//	public void removeRestAttdList(ArrayList<RestAttdTO> restAttdList) {
//		// TODO Auto-generated method stub
//		
//		for(RestAttdTO restAttd : restAttdList){
//			restAttdDAO.deleteRestAttd(restAttd);
//		}
//		
//	}

//	********************* 占쎈눇�뙼�맪占쏙퐦�삕占쎄땍占쎈쐻占쎈윥獄��엺�쐻占쎈윪�앓우삕�땻�떣�쐻占쎈쑟�얜뀘�쐻�뜝占� �뜝�럥苑욃뜝�럡�꼤嶺뚯빢�삕 _2020.09.04 _占쎈쐻占쎈윪占쎄땍占쎈쐻占쎈윪野껓옙 *********************

	@Override
	public ArrayList<DayAttdMgtTO> findDayAttdMgtList(@Param("applyDay") String applyDay) {
		// TODO Auto-generated method stub

		HashMap<String, Object> param = new HashMap<>();
		param.put("applyDay", applyDay);
		dayAttdMgtDAO.batchDayAttdMgtProcess(param);
		/*
		 * ResultTO resultTO = (ResultTO) resultMap.get("resultTO");
		 * if(Integer.parseInt(resultTO.getErrorCode()) < 0){ throw new
		 * DataAccessException(resultTO.getErrorMsg()) {}; }
		 */
		@SuppressWarnings("unchecked")
		ArrayList<DayAttdMgtTO> dayAttdMgtList = (ArrayList<DayAttdMgtTO>) param.get("result");
		return dayAttdMgtList;

	}

	@Override
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList) {
		// TODO Auto-generated method stub

		for (MonthAttdMgtTO monthAttdMgt : monthAttdMgtList) {

			System.out.println("占쎈쐻占쎈윪占쎄샵占쎈쐻占쎈윥占쎈빢占쎈쐻占쎈윥筌β뮪�쐻占쎈윪占쎄샵占쎈쐻占쎈윥占쎈빢占쎈쐻占쎈윥筌ο옙" + monthAttdMgt);
			if (monthAttdMgt.getStatus().equals("update")) {
				monthAttdMgt.setFinalizeStatus("Y");
				monthAttdMgtDAO.updateMonthAttdMgtList(monthAttdMgt);
			} else if (monthAttdMgt.getStatus().equals("cancel")) {
				monthAttdMgt.setFinalizeStatus("N");
				monthAttdMgtDAO.cancelMonthAttdMgtList(monthAttdMgt);
			}

		}

	}

	@Override
	public void insertDayAttd(DayAttdTO dayAttd) { // test
		// TODO Auto-generated method stub
		dayAttdDAO.insertDayAttd(dayAttd);
	}

	@Override
	public ArrayList<DayAttdMgtTO> findDayAttdMgtListAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dayAttdMgtDAO.selectDayAttdMgtProcessAll(map);
	}

	@Override
	public ArrayList<DayAttdMgtTO> dayDeadlineRegister(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

		HashMap<String, Object> map1 = new HashMap<String, Object>();

		Map<String, ArrayList<DayAttdMgtTO>> list = (Map<String, ArrayList<DayAttdMgtTO>>) map.get("DayAttdMgtToList");

		ArrayList<DayAttdMgtTO> DayAttdMgtList = list.get("DayAttdMgtToList");

		for (DayAttdMgtTO DayAttdMgtTo : DayAttdMgtList) {

			map1.put("empCode", DayAttdMgtTo.getEmpCode());

			map1.put("applyDays", DayAttdMgtTo.getApplyDays());

			map1.put("finalizeStatus", "Y");

			dayAttdMgtDAO.updateDayAttdMgtList(map1);
		}

		return null;
	}

	@Override // 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�삕�뜝�럩紐긷뜝�럩留뜹뜝�럥�맶占쎈쐻�뜝占�
	public HashMap<String, Object> findDayAttdMgtList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dayAttdMgtDAO.batchDayAttdMgtProcesses(map);
		return map;
	}

	@Override
	public void dayDeadlineCancel(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

		HashMap<String, Object> map1 = new HashMap<String, Object>();

		Map<String, ArrayList<DayAttdMgtTO>> list = (Map<String, ArrayList<DayAttdMgtTO>>) map.get("DayAttdMgtToList");

		ArrayList<DayAttdMgtTO> DayAttdMgtList = list.get("DayAttdMgtToList");

		for (DayAttdMgtTO DayAttdMgtTo : DayAttdMgtList) {

			map1.put("empCode", DayAttdMgtTo.getEmpCode());

			map1.put("applyDays", DayAttdMgtTo.getApplyDays());

			map1.put("finalizeStatus", "N");

			dayAttdMgtDAO.CanCelDayAttdMgtList(map1);
		}
	}

	@Override
	public ArrayList<HrDetailCodeTO> searchRestAttendanceType() {
		// TODO Auto-generated method stub
		return restAttdDAO.selectRestDatailCodeName();
	}

	// 占쎈쐻占쎈윪占쎄땍占쎈쐻占쎈윪野껓옙 占쎈쐻占쎈윪�앗껋쐺獄�占쏙옙�떁濚밸㉡�삕 占쎈섀饔낅챸占썩뼺鍮놂옙留졾뜝�럡�쀯옙�띿삕占쎈쨧
	// 占쎈쐻占쎈윞占쎈��占쎈쐻占쎈윪占쎌졆
	@Override
	public void deleteDayAttd(ArrayList<DayAttdTO> dayAttdData) {
		// TODO Auto-generated method stub
		for (DayAttdTO dayAttd : dayAttdData) {
			dayAttdDAO.deleteDayAttd(dayAttd);
		}

	}

//	@SuppressWarnings("unchecked")
//	//	********************* 占쎈눇�뙼�맪占쏙퐦�삕占쎄땍占쎈쐻占쎈윥獄��엺�쐻占쎈윪�앓우삕�땻�떣�쐻占쎈쑟�얜뀘�쐻�뜝占� 占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾 _2020.09.04 _占쎈쐻占쎈윪占쎄땍占쎈쐻占쎈윪野껓옙 *********************
//	@Override
//	public void modifyRestAttdList(HashMap<String,ArrayList<RestAttdTO>> attdApplMap) {
//		// TODO Auto-generated method stub	
//		
//		HashMap<String, String> data = new HashMap<>();
//		
//		ArrayList<RestAttdTO> list = attdApplMap.get("checkData");
//		
//		System.out.println("?????????????????"+list);
//		
//		for(RestAttdTO attd : list) {			
//			
//			data.put("applovalStatus", attd.getApplovalStatus());
//			data.put("rejectCause", attd.getRejectCause());
//			data.put("empCode", attd.getEmpCode());
//			data.put("couse", attd.getCause());
//			data.put("restAttdCode", attd.getRestAttdCode());
//			
//			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZ"+data);
//			restAttdDAO.updateRestAttd(data);
//		}				
//	}

	// =============================占쎈눇�뙼�맪占쏙퐦�삕占쎌졆占쎈쐻占쎈윥獄��엺�쐻占쎈윪�앓우삕�땻�떣�쐻占쎈쑟�얜뀘�쐻�뜝占�
	// 占쎈쐻占쎈윪占쎄섈占쎈쐻占쎈윪占쎌젳 2020-09-20 占쎈쐻占쎈윪占쎄땍占쎈쐻占쎈윪野껓옙
	// =====================================
	@Override
	public ArrayList<RestAttdTO> modifyRestAttdList(List<RestAttdTO> restAttdTo, String deptCode, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		HashMap<String, String> attdApplMap = new HashMap<>();
		HashMap<String, String> data = new HashMap<>();
		ArrayList<RestAttdTO> restAttdList = null;

		for (RestAttdTO attd : restAttdTo) {
			if (attd.getApplovalStatus().equals("apploval")) {
				attd.setApplovalStatus("占쎈쐻占쎈윥獄��엺�쐻占쎈윪�억옙");
			} else if (attd.getApplovalStatus().equals("cancel")) {
				attd.setApplovalStatus("占쎈쐻占쎈윥獄��엺�쐻占쎈윪�앓우삕�굢�냵�삕泳�怨살삕�댆占�");
			} else {
				attd.setApplovalStatus("占쎈쎗占쎈즵�몭�씛�삕占쎌죳");
			}
			data.put("applovalStatus", attd.getApplovalStatus());
			data.put("rejectCause", attd.getRejectCause());
			data.put("empCode", attd.getEmpCode());
			data.put("couse", attd.getCause());
			data.put("restAttdCode", attd.getRestAttdCode());

			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZ" + data);

			restAttdDAO.updateRestAttd(data);
		}

		attdApplMap.put("deptCode", deptCode);
		attdApplMap.put("startDate", startDate);
		attdApplMap.put("endDate", endDate);

		restAttdList = findRestAttdListByDept(attdApplMap);

		return restAttdList;

	}

}
