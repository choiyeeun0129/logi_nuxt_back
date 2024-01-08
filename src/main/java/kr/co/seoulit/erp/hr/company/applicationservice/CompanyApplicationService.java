package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import kr.co.seoulit.erp.hr.company.to.PositionTO;

public interface CompanyApplicationService {

   public ArrayList<CompanyTO> getCompanyList();
   
   public String getNewCompanyCode();
   
   public HashMap<String, Object> batchCompanyListProcess(ArrayList<CompanyTO> companyList);

   public ArrayList<PositionTO> positionList();
   
   
   
}