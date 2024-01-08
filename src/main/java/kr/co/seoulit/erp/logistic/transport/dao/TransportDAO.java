package kr.co.seoulit.erp.logistic.transport.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.seoulit.erp.hr.attendance.to.annualVacationMgtTO;
import kr.co.seoulit.erp.logistic.transport.to.TransportTO;

@Mapper
public interface TransportDAO {
	public ArrayList<TransportTO> searchTransportList(HashMap<String, String> param);
	public ArrayList<TransportTO> searchCommercialVehicleList();
	public ArrayList<TransportTO> searchTransportAbleList();
	public void updateTransportList(
			@Param("transportStatus") String transportStatus, 
			@Param("contractNo") String contractNo,
			@Param("commercialVehicle") String commercialVehicle,
			@Param("driver") String driver, 
			@Param("memo") String memo
			);
	public ArrayList<TransportTO> searchCommercialVehicleInList();
	public void updateCommercialVehicleInList(annualVacationMgtTO annualVacationMgtList);
}
