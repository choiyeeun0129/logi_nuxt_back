package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.attendance.dao.ElasticDAO;
import kr.co.seoulit.erp.hr.attendance.to.ElasticTO;


@Component
public class ElasticApplicationServiceImpl implements ElasticApplicationService{
	@Autowired
	private ElasticDAO elasticDAO;
	
	@Override
	public ArrayList<ElasticTO> findElasticList(String empCode, String applyDay) {
		// TODO Auto-generated method stub
	
		ArrayList<ElasticTO> elasticList=elasticDAO.selectElasticList(empCode, applyDay);
		
		for(ElasticTO elasticTO : elasticList  ) {
			String time = elasticTO.getStartTime();
			if(time.length() == 3) { StringBuffer t1 = new StringBuffer(time);
			t1.insert(1, ":");
			String t2 = t1.toString();
			elasticTO.setStartTime(t2);}
			else if(time.length() == 4) {StringBuffer tt1 = new StringBuffer(time);
			tt1.insert(2, ":");
			String tt2 = tt1.toString();
			elasticTO.setStartTime(tt2);
				
			}
			
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+elasticList);
		
		return elasticList;
	}

//	@Override
//	public void insertElastic(ArrayList<ElasticTO> data) {
//		// TODO Auto-generated method stub
//		for(ElasticTO elasticdata : data) {
//			elasticDAO.insertElastic(elasticdata);
//			}
//	}
	
	@Override
	public void insertElastic(String empCode ,String applyDay,String startTime,String endTime) {
		// TODO Auto-generated method stub
	
			elasticDAO.insertElastic(empCode , applyDay , startTime , endTime);
			
	}
	
	@Override
	public void deleteElastic(ArrayList<ElasticTO> elasticDelData) {
		// TODO Auto-generated method stub
	
		System.out.println("ApplicationService"+elasticDelData);
		
		for(ElasticTO elastic : elasticDelData) {
			System.out.println(elastic);
			elasticDAO.deleteElastic(elastic);
			}
		
	}
}
