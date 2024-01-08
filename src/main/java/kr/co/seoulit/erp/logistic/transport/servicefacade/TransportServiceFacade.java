package kr.co.seoulit.erp.logistic.transport.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.logistic.transport.to.TransportTO;

public interface TransportServiceFacade {
	
	public ArrayList<TransportTO> searchTransportList(String startDate, String endDate);
	
	public ArrayList<TransportTO> searchCommercialVehicleList();
	
	public ArrayList<TransportTO> searchTransportAbleList();
	
	public void updateTransportList(String transportStatus, String contractNo, String dueDateOfContract, String commercialVehicle,
			String driver, String customerBasicAddress, String customerDetailAddress, String memo, String reportingDate);

	//입차 조회
	public ArrayList<TransportTO> searchCommercialVehicleInList();
	
	//입차 변경
	public void modifyCommercialVehicleInList(ModelMap modelMap);
}
