package kr.co.seoulit.erp.logistic.sales.dao;

import kr.co.seoulit.erp.logistic.sales.to.ContractInfoTO;
import kr.co.seoulit.erp.logistic.sales.to.OutputTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface OutputDAO {
    public ArrayList<OutputTO> getOutputList();
    public ArrayList<OutputTO> getOutputDetailList(String outputNumber);
    public String getOutputMaxNo();
    void addNewOutput(Map<String, Object> params);

    void delete(String outputNumber);
    public void deleteOutput(String outputNumber);

}
