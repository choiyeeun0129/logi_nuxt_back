package kr.co.seoulit.erp.hr.attendance.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.seoulit.erp.hr.attendance.to.ElasticTO;

@Mapper
public interface ElasticDAO {
	public ArrayList<ElasticTO> selectElasticList(@Param("empCode") String empCode, @Param("applyDay") String applyDay);

//	public void insertElastic(ElasticTO data);
	
	public void insertElastic(@Param("empCode") String empCode, @Param("applyDay") String applyDay,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public void deleteElastic(ElasticTO elastic);
}
