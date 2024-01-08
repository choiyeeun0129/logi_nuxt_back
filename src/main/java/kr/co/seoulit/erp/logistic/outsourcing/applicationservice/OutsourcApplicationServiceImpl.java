package kr.co.seoulit.erp.logistic.outsourcing.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.outsourcing.dao.ForwardDAO;
import kr.co.seoulit.erp.logistic.outsourcing.dao.OutInspectionDAO;
import kr.co.seoulit.erp.logistic.outsourcing.dao.OutsourcOrderDAO;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutInspectionTO;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;

@Component
public class OutsourcApplicationServiceImpl implements OutsourcApplicationService {

	@Autowired
	private OutsourcOrderDAO orderDAO;

	@Autowired
	private ForwardDAO forwardDAO;

	@Autowired
	private OutInspectionDAO inspectionDAO;

	@Override
	public ArrayList<MrpGatheringTO> searchMrpGatheringList(
			String dateSearchCondtion,
			String startDate,
			String endDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("dateSearchCondtion", dateSearchCondtion);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		System.out.println(param);

		return orderDAO.selectMrpGatheringList(param);
		//return orderDAO.selectOutsourcInfoList(param);
	}

	@Override
	public int getStandardUnitPrice(String itemCode) {
		return orderDAO.getStandardUnitPrice(itemCode);
	}

	@Override
	public void insertOutsourc(ArrayList<OutsourcTO> outsourcList) {

		orderDAO.insertOutsourc(outsourcList);

		ArrayList<String> mrpGatheringNoList = new ArrayList<String>();

		for (OutsourcTO to : outsourcList) {
			mrpGatheringNoList.add(to.getMrpGatheringNo());
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		String mrpGatheringNoStr = mrpGatheringNoList.toString().replace("[", "").replace("]", "");
		System.out.println(mrpGatheringNoStr);
		map.put("mrpGatheringNoList", mrpGatheringNoStr.toString());
		orderDAO.updateNecessaryAmount(map);
	}

	@Override
	public ArrayList<OutsourcTO> searchOutsourcInfoList(String dateSearchCondtion, String startDate, String endDate) {
		HashMap<String, String> param = new HashMap<>();
		param.put("dateSearchCondtion", dateSearchCondtion);
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		return orderDAO.selectOutsourcInfoList(param);
	}

	@Override
	public HashMap<String, Object> getReleaseSimulationList(String mrpGatheringNo, String id, String seq) {

		HashMap<String, Object> param = new HashMap<>();
		param.put("mrpGatheringNo", mrpGatheringNo);
		param.put("id", id);
		param.put("seq", seq);

		forwardDAO.getReleaseSimulationList(param);

		return param;

	}

	@Override
	public void updateStock(String itemCode, String mrpGatheringNo, String id, String seq) {

		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("seq", seq);

		ArrayList<OutsourcTO> list = forwardDAO.selectForwardStatus(mrpGatheringNo);

		for (OutsourcTO to : list) {
			String str = to.getForwardStatus();
			System.out.println("to.getForwardStatus()");
			System.out.println(str);
			boolean b = "Y".equals(str);
			System.out.print("boolean: ");
			System.out.println(b);
			if (b) {
				System.out.println("return");
				return;
			}
		}

		forwardDAO.updateStock(map);

		System.out.println(mrpGatheringNo + "이거뭐로 넘어오니~~~~~~~~~");
		forwardDAO.updateStatus(mrpGatheringNo);

		forwardDAO.deleteTemp(map);
	}

	@Override
	public ArrayList<OutInspectionTO> getOutInspectionInfoList() {

		return inspectionDAO.selectOutInspectionInfoList();

	}

	@Override
	public HashMap<String, Object> outInspectionCompletion(String outsourcNo
//			, String actualCompletionAmount
	) {

		HashMap<String, Object> param = new HashMap<>();
		param.put("outsourcNo", outsourcNo);
//		param.put("actualCompletionAmount", actualCompletionAmount);

		inspectionDAO.outInspectionCompletion(param);

		return param;
	}

	@Override
	public ArrayList<OutsourcTO> searchForwardableList(String searchDateCondition, String startDate, String endDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("searchDateCondition", searchDateCondition);
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		return forwardDAO.searchForwardInfoList(param);
	}

	@Override
	public void forwardTempDelete(String id, String seq) {

		HashMap<String, String> param = new HashMap<>();
		param.put("id", id);
		param.put("seq", seq);

		forwardDAO.deleteTemp(param);

	}

	@Override
	public ArrayList<OutsourcTO> searchOutsourcInfoList() {
		return orderDAO.selectOutsourcInfoList();
	}

		@Override
		public void updateForwardStatus (String outsourcNo){
			HashMap<String, String> param = new HashMap<>();
			param.put("outsourcNo", outsourcNo);

			orderDAO.updateForwardStatus(param);
		}


}
