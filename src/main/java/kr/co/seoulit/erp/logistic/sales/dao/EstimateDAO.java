package kr.co.seoulit.erp.logistic.sales.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.sales.to.EstimateTO;

@Mapper
public interface EstimateDAO {

	public EstimateTO selectEstimate(String estimateNo);

	public int selectEstimateCount(String estimateDate);

	public void insertEstimate(EstimateTO TO);

	public void updateEstimate(EstimateTO TO);

	public void changeContractStatusOfEstimate(HashMap<String, String> param);

	public ArrayList<EstimateTO> selectEstimateList(HashMap<String, String> param);

}
