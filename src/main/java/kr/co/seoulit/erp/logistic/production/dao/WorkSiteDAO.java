package kr.co.seoulit.erp.logistic.production.dao;


import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface WorkSiteDAO {

    //작업장/작업장 로그 = 작업장 조회(Spring)
    public ArrayList<WorkSiteTO> selectWorkSiteList();

    public ArrayList<WorkSiteLogTO> selectProductionProcessCode(HashMap<String, String> map);
}

