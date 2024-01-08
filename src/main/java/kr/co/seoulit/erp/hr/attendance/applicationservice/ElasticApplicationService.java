package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.ArrayList;

import kr.co.seoulit.erp.hr.attendance.to.ElasticTO;

public interface ElasticApplicationService {
	public ArrayList<ElasticTO> findElasticList(String empCode, String applyDay);

//	public void insertElastic(ArrayList<ElasticTO> data);
	public void insertElastic(String empCode, String applyDay, String startTime, String endTime);

	public void deleteElastic(ArrayList<ElasticTO> elasticDelData);
}
