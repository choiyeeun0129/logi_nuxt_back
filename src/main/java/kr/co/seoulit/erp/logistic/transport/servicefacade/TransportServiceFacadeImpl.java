package kr.co.seoulit.erp.logistic.transport.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.company.to.DepartmentTO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.transport.applicationservice.TransportApplicationService;
import kr.co.seoulit.erp.logistic.transport.to.TransportTO;

@Service
public class TransportServiceFacadeImpl implements TransportServiceFacade {
	
	@Autowired
	private TransportApplicationService transportApplicationService;
	
		@Override
		public ArrayList<TransportTO> searchTransportList(String startDate, String endDate) {
		return transportApplicationService.searchTransportList(startDate, endDate);
		}
	   
		
	   //출차 검색
	   @Override
	   public ArrayList<TransportTO> searchCommercialVehicleList() {

	      ArrayList<TransportTO> transportList = null;

	      try {
	    	  transportList = transportApplicationService.searchCommercialVehicleList();
	      } catch (DataAccessException e) {
	         e.printStackTrace();
	         throw e;
	      }

	      return transportList;
	   }
	   
	   @Override
	   public ArrayList<TransportTO> searchTransportAbleList() {

	      ArrayList<TransportTO> transportList = null;

	      try {
	    	  transportList = transportApplicationService.searchTransportAbleList();
	      } catch (DataAccessException e) {
	         e.printStackTrace();
	         throw e;
	      }
	      
	      return transportList;
	   }
	   
		@Override
		public void updateTransportList(String transportStatus, String contractNo, String dueDateOfContract, String commercialVehicle,
				String driver, String customerBasicAddress, String customerDetailAddress, String memo, String reportingDate) {
			// TODO Auto-generated method stub
			transportApplicationService.updateTransportList(transportStatus, contractNo, dueDateOfContract, commercialVehicle,
					driver, customerBasicAddress, customerDetailAddress, memo, reportingDate);
		}
		
		
		   //입차 관리
		   @Override
		   public ArrayList<TransportTO> searchCommercialVehicleInList() {

		      ArrayList<TransportTO> transportList = null;

		      try {
		    	  transportList = transportApplicationService.searchCommercialVehicleInList();
		      } catch (DataAccessException e) {
		         e.printStackTrace();
		         throw e;
		      }

		      return transportList;
		   }
		   
		   //입차로 변경
		   @Override
		   public void modifyCommercialVehicleInList(ModelMap modelMap) {
		   	// TODO Auto-generated method stub
		   	transportApplicationService.modifyCommercialVehicleInList(modelMap);
		   }
}
