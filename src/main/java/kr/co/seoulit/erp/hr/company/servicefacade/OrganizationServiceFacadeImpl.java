package kr.co.seoulit.erp.hr.company.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.company.applicationservice.CompanyApplicationService;
import kr.co.seoulit.erp.hr.company.applicationservice.DepartmentApplicationService;
import kr.co.seoulit.erp.hr.company.applicationservice.LogiWorkplaceApplicationService;
import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import kr.co.seoulit.erp.hr.company.to.DepartmentTO;
import kr.co.seoulit.erp.hr.company.to.PositionTO;
import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;

@Service
public class OrganizationServiceFacadeImpl implements OrganizationServiceFacade {

   @Autowired
   private CompanyApplicationService companyAS;
   @Autowired
   private LogiWorkplaceApplicationService workplaceAS;
   @Autowired
   private DepartmentApplicationService deptAS;
   

   @Override
   public ArrayList<CompanyTO> getCompanyList() {

      ArrayList<CompanyTO> companyList = null;

      try {

         companyList = companyAS.getCompanyList();

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return companyList;
   }

   @Override
   public ArrayList<WorkplaceTO> getWorkplaceList(String companyCode) {

      ArrayList<WorkplaceTO> workplaceList = null;

      try {

         workplaceList = workplaceAS.getWorkplaceList(companyCode);

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return workplaceList;
   }

   @Override
   public ArrayList<DepartmentTO> getDepartmentList(String searchCondition, String companyCode,
         String workplaceCode) {

      ArrayList<DepartmentTO> departmentList = null;

      try {

         departmentList = deptAS.getDepartmentList(searchCondition, companyCode, workplaceCode);

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return departmentList;
   }

   @Override
   public HashMap<String, Object> batchCompanyListProcess(ArrayList<CompanyTO> companyList) {

      HashMap<String, Object> resultMap = null;

      try {

         resultMap = companyAS.batchCompanyListProcess(companyList);

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return resultMap;
   }

   @Override
   public HashMap<String, Object> batchWorkplaceListProcess(ArrayList<WorkplaceTO> workplaceList) {

      HashMap<String, Object> resultMap = null;

      try {

         resultMap = workplaceAS.batchWorkplaceListProcess(workplaceList);

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return resultMap;
   }

   @Override
   public HashMap<String, Object> batchDepartmentListProcess(ArrayList<DepartmentTO> departmentList) {

      HashMap<String, Object> resultMap = null;

      try {

         resultMap = deptAS.batchDepartmentListProcess(departmentList); 

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return resultMap;
   }

   @Override
   public ArrayList<PositionTO> getPositionList() {

      ArrayList<PositionTO> positionList = null;

      try {
         System.out.println("=======================OrganizationServiceFacadeImpl   getPositionList�޼������===========================");
         positionList = companyAS.positionList();

      } catch (DataAccessException e) {
         e.printStackTrace();
         throw e;
      }

      return positionList;
   }

}