package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.CareerInfoTO;

@Mapper
public interface CareerInfoDAO {
	public ArrayList<CareerInfoTO> selectCareerList(String code);

	public ArrayList<CareerInfoTO> selectCareerInfoList(String code);

	public void insertCareerInfo(CareerInfoTO careerInfo);

	public void updateCareerInfo(CareerInfoTO careerInfo);

	public void deleteCareerInfo(CareerInfoTO careerInfo);
}
