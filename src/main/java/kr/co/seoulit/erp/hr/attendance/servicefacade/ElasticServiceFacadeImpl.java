package kr.co.seoulit.erp.hr.attendance.servicefacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.attendance.applicationservice.ElasticApplicationService;
import kr.co.seoulit.erp.hr.attendance.to.ElasticTO;


@Service
public class ElasticServiceFacadeImpl implements ElasticServiceFacade{
	
	@Autowired   
	private ElasticApplicationService elasticApplicationService;
	
	@Override
	public ArrayList<ElasticTO> findElasticList(String empCode, String applyDay) {
		ArrayList<ElasticTO> elasticList=elasticApplicationService.findElasticList(empCode, applyDay);
			return elasticList;
		}

//	@Override
//	public void insertElastic(ArrayList<ElasticTO> data) {
//		// TODO Auto-generated method stub
//		elasticApplicationService.insertElastic(data);
//	}
	
	@Override
	public void insertElastic(String empCode ,String applyDay,String startTime,String endTime) {
		// TODO Auto-generated method stub
		elasticApplicationService.insertElastic(empCode , applyDay , startTime , endTime);
	}
	
	@Override
	public void deleteElastic(ArrayList<ElasticTO> elasticDelData) {
		System.out.println("facade"+elasticDelData);
		elasticApplicationService.deleteElastic(elasticDelData);
	}
}
