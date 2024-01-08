package kr.co.seoulit.erp.hr.company.controller;

import java.util.ArrayList;

import kr.co.seoulit.erp.hr.company.servicefacade.OrganizationServiceFacade;

import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import kr.co.seoulit.erp.hr.company.to.PositionTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr/company/*")
@CrossOrigin("*")
public class CompanyController {


   @Autowired
   private OrganizationServiceFacade orgSF;


   private ModelMap modelMap = new ModelMap();

   @RequestMapping(value="/searchCompany",method=RequestMethod.GET)
   public ModelMap searchCompanyList() {

      ArrayList<CompanyTO> companyList = null;

      try {

         companyList = orgSF.getCompanyList();
        //         companyList=    
         modelMap.put("gridRowJson", companyList);
         modelMap.put("errorCode", 1);
         modelMap.put("errorMsg", "����");

      } catch (DataAccessException e2) {
         e2.printStackTrace();
         modelMap.put("errorCode", -2);
         modelMap.put("errorMsg", e2.getMessage());

      }
      System.out.println("나온다 "+modelMap);
      return modelMap;
   }

   @RequestMapping(value="/batchCompanyListProcess",method=RequestMethod.POST)
   public ModelMap batchListProcess(@RequestParam String batchList) {

//      ArrayList<CompanyTO> companyList = gson.fromJson(batchList, new TypeToken<ArrayList<CompanyTO>>() {
//      }.getType());

      try {

//         HashMap<String, Object> resultMap = orgSF.batchCompanyListProcess(companyList);
//
//         modelMap.put("result", resultMap);
         modelMap.put("errorCode", 1);
         modelMap.put("errorMsg", "����");

      } catch (DataAccessException e2) {
         e2.printStackTrace();
         modelMap.put("errorCode", -2);
         modelMap.put("errorMsg", e2.getMessage());

      }
      return modelMap;
   }
   
   @RequestMapping(value="/searchPosition",method=RequestMethod.GET)
   public ModelMap searchPositionList() {


      ArrayList<PositionTO> positionList = null;


      try {
         System.out.println("=======================��Ʈ�ѷ�       searchPositionList�޼������===========================");
         positionList = orgSF.getPositionList();
        //         companyList=    
         modelMap.put("gridRowJson", positionList);
         modelMap.put("errorCode", 1);
         modelMap.put("errorMsg", "����");

      } catch (DataAccessException e2) {
         e2.printStackTrace();
         modelMap.put("errorCode", -2);
         modelMap.put("errorMsg", e2.getMessage());

      }
      return modelMap;
   }

}