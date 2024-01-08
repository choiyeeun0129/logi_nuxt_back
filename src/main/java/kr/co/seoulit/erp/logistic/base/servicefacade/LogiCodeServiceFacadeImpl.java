package kr.co.seoulit.erp.logistic.base.servicefacade;

import java.util.ArrayList;


import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDAO;
import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDTO;
import org.springframework.ui.ModelMap;

@Service
public class LogiCodeServiceFacadeImpl implements LogiCodeServiceFacade {



	@Autowired
	private LogiCodeDAO codeDAO;

	@Autowired
	private LogiCodeDetailDAO codeDetailDAO;

	private ModelMap modelMap=new ModelMap();

	@Override
	public ModelMap getCodeList() {

		try {

			ArrayList<LogiCodeTO> codeList = codeDAO.selectCodeList();
			for (LogiCodeTO bean : codeList) {
				bean.setCodeDetailTOList(codeDetailDAO.selectDetailCodeList(bean.getDivisionCodeNo()));
			}
			modelMap.put("codeList", codeList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	public String createDivisionCodeNo(String codeType) {
		String divisionCodeNo = codeDAO.createDivisionCodeNo(codeType);
		return divisionCodeNo;

	}

	@Override
	public void batchCodeListProcess(LogiCodeTO codeData) {
		String status = codeData.getStatus();
		switch (status) {
			case "INSERT":
				String codeType = codeData.getCodeType();
				String divisionCodeNo = createDivisionCodeNo(codeType);
				codeData.setDivisionCodeNo(divisionCodeNo);
				codeData.setStatus("normal");
				codeDAO.insertCode(codeData);
				break;

			case "UPDATE":
				codeDAO.updateCode(codeData);
				break;

			case "DELETE":
				codeDAO.deleteCode(codeData);
				break;

		}
	}

	@Override
	public ModelMap getDetailCodeList(String divisionCode) {
		try {
			ArrayList<LogiCodeDetailTO> detailCodeList = codeDetailDAO.selectDetailCodeList(divisionCode);
			modelMap.put("detailCodeList", detailCodeList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return modelMap;
	}

	@Override
	public ModelMap getSelectCode(String divisionCode) {
		try {
			LogiCodeTO logiCodeTO = codeDAO.selectCode(divisionCode);
			modelMap.put("logiCodeTO", logiCodeTO);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공1111");
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return modelMap;
	}

	@Override
	public void updateCode(LogiCodeTO logiCodeTO) {
		codeDAO.updateCode(logiCodeTO);
	}

	@Override
	public void deleteLogiCode(String divisionCodeNo) {
		codeDAO.deleteLogiCode(divisionCodeNo);
	}

	@Override
	public void batchDetailCodeListProcess(LogiCodeDetailTO detailCodeList) {
		String status = detailCodeList.getStatus();
		switch (status) {

			case "INSERT":
				codeDetailDAO.insertDetailCode(detailCodeList);
				break;

			case "UPDATE":
				codeDetailDAO.updateDetailCode(detailCodeList);
				break;

			case "DELETE":
				codeDetailDAO.deleteDetailCode(detailCodeList);
				break;

		}
	}

//	@Override
//	public HashMap<String, Object> changeCodeUseCheckProcess(ArrayList<LogiCodeDetailTO> detailCodeList) {
//
//		HashMap<String, Object> resultMap = new HashMap<>();
//
//		ArrayList<String> codeUseList = new ArrayList<>();
//		ArrayList<String> codeNotUseList = new ArrayList<>();
//
//		for (LogiCodeDetailTO bean : detailCodeList) {
//			String codeUseCheck = ((bean.getCodeUseCheck() == null) ? "" : bean.getCodeUseCheck().toUpperCase());
//			switch (codeUseCheck) {
//
//				case "N":
//					codeDetailDAO.changeCodeUseCheck(bean.getDivisionCodeNo(), bean.getDetailCode(), "N");
//					codeNotUseList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());
//					break;
//
//				default:
//					codeDetailDAO.changeCodeUseCheck(bean.getDivisionCodeNo(), bean.getDetailCode(), "");
//					codeUseList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());
//					break;
//			}
//		}
//		resultMap.put("USE", codeUseList);
//		resultMap.put("NOT_USE", codeNotUseList);
//		return resultMap;
//	}


	//


}
