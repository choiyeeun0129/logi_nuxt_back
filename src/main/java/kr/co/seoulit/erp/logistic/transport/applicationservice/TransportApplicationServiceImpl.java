package kr.co.seoulit.erp.logistic.transport.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.attendance.to.annualVacationMgtTO;
import kr.co.seoulit.erp.hr.company.to.DepartmentTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.transport.dao.TransportDAO;
import kr.co.seoulit.erp.logistic.transport.to.TransportTO;

@Component
public class TransportApplicationServiceImpl implements TransportApplicationService {

	@Autowired
	private TransportDAO transportDAO;
	
	public ArrayList<TransportTO> searchTransportList(String startDate, String endDate){
		HashMap<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		System.out.println("여까지 오나??????");
		return transportDAO.searchTransportList(param);
	}
	
	public ArrayList<TransportTO> searchCommercialVehicleList() {
		ArrayList<TransportTO> transportList = null;
			transportList = transportDAO.searchCommercialVehicleList();
			return transportList;
	}

	public ArrayList<TransportTO> searchTransportAbleList() {
		ArrayList<TransportTO> transportList = null;
			transportList = transportDAO.searchTransportAbleList();
			return transportList;
	}


	public void updateTransportList(String transportStatus, String contractNo, String dueDateOfContract, String commercialVehicle,
			String driver, String customerBasicAddress, String customerDetailAddress, String memo, String reportingDate) {
		// TODO Auto-generated method stub
		transportDAO.updateTransportList(transportStatus, contractNo, dueDateOfContract, commercialVehicle,
				driver);	
	}
	
	public ArrayList<TransportTO> searchCommercialVehicleInList() {
		ArrayList<TransportTO> transportList = null;
			transportList = transportDAO.searchCommercialVehicleInList();
			return transportList;
	}
	
	@Override
	public void modifyCommercialVehicleInList(ModelMap modelMap) {
		ArrayList<annualVacationMgtTO> annualVacationMgtList = (ArrayList<annualVacationMgtTO>) modelMap
				.get("annualVacationMgt");
		System.out.println("=================�뿰李④�由� 留덇컧======================");

		for (annualVacationMgtTO annualVacationMgt : annualVacationMgtList) {
			System.out.println("�뿰李�::" + annualVacationMgt);
			if (annualVacationMgt.getFinalizeStatus().equals("SHIPPING")) {
				annualVacationMgt.setFinalizeStatus("READY");
				transportDAO.updateCommercialVehicleInList(annualVacationMgt);
//			} else if (annualVacationMgt.getFinalizeStatus().equals("Y")) {
//				annualVacationMgt.setFinalizeStatus("N");
//				transportDAO.updateCommercialVehicleInList(annualVacationMgt);
//			}
		}
	}
	}
}