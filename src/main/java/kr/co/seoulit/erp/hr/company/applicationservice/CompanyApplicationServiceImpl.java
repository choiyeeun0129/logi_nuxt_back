package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDetailDAO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.hr.company.dao.CompanyDAO;
import kr.co.seoulit.erp.hr.company.dao.PositionDAO;
import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import kr.co.seoulit.erp.hr.company.to.PositionTO;

@Component
public class CompanyApplicationServiceImpl implements CompanyApplicationService {

   @Autowired
   private CompanyDAO companyDAO;
   @Autowired
   private LogiCodeDetailDAO codeDetailDAO;
   @Autowired
   private PositionDAO positionDAO;
   
   public ArrayList<CompanyTO> getCompanyList() {

      return companyDAO.selectCompanyList();
   }

   public String getNewCompanyCode() {

      ArrayList<CompanyTO> companyList = null;
      String newCompanyCode = null;

         companyList = companyDAO.selectCompanyList();

         TreeSet<Integer> companyCodeNoSet = new TreeSet<>();

         for (CompanyTO bean : companyList) {

            if (bean.getCompanyCode().startsWith("COM-")) {

               try {

                  Integer no = Integer.parseInt(bean.getCompanyCode().split("COM-")[1]);
                  companyCodeNoSet.add(no);

               } catch (NumberFormatException e) {

               // "COM-" ���� �κ��� Integer �� ��ȯ���� ���ϴ� ��� : �׳� ���� �ݺ��� ����


               }

            }

         }

         if (companyCodeNoSet.isEmpty()) {
            newCompanyCode = "COM-" + String.format("%02d", 1);
         } else {
            newCompanyCode = "COM-" + String.format("%02d", companyCodeNoSet.pollLast() + 1);
         }
         
      return newCompanyCode;
   }

   public HashMap<String, Object> batchCompanyListProcess(ArrayList<CompanyTO> companyList) {

      HashMap<String, Object> resultMap = new HashMap<>();

         ArrayList<String> insertList = new ArrayList<>();
         ArrayList<String> updateList = new ArrayList<>();
         ArrayList<String> deleteList = new ArrayList<>();

         LogiCodeDetailTO detailCodeBean = new LogiCodeDetailTO();

         
      // 2���� �ݺ��� ���� : ���ļ� �ص� ���������, �߰�/����/������ ��ġ�� �߰��� ������ ��ȣ�� ���� �� ����
         for (CompanyTO bean : companyList) { // 1�� �ݺ� : INSERT �� ���� => �߰��� ������ ��ȣ�� ������ �ϱ� ���ؼ�..

            String status = bean.getStatus();

            switch (status) {   

            case "INSERT":

               // ���ο� ȸ���ȣ ���� �� bean �� set
               String newCompanyCode = getNewCompanyCode();
               bean.setCompanyCode(newCompanyCode);

               // ȸ�� ���̺� insert
               companyDAO.insertCompany(bean);
               insertList.add(bean.getCompanyCode());

               // CODE_DETAIL ���̺� Insert
               detailCodeBean.setDivisionCodeNo("CO-01");
               detailCodeBean.setDetailCode(bean.getCompanyCode());
               detailCodeBean.setDetailCodeName(bean.getCompanyName());

               codeDetailDAO.insertDetailCode(detailCodeBean);

               break;

            }

         }

         for (CompanyTO bean : companyList) {    // 2�� �ݺ� : UPDATE , DELETE �� ����


            String status = bean.getStatus();

            switch (status) {

            case "UPDATE":

               companyDAO.updateCompany(bean);
               updateList.add(bean.getCompanyCode());

               // CODE_DETAIL ���̺� Update
               detailCodeBean.setDivisionCodeNo("CO-01");
               detailCodeBean.setDetailCode(bean.getCompanyCode());
               detailCodeBean.setDetailCodeName(bean.getCompanyName());

               codeDetailDAO.updateDetailCode(detailCodeBean);

               break;

            case "DELETE":

               companyDAO.deleteCompany(bean);
               deleteList.add(bean.getCompanyCode());

               // CODE_DETAIL ���̺� Delete
               detailCodeBean.setDivisionCodeNo("CO-01");
               detailCodeBean.setDetailCode(bean.getCompanyCode());
               detailCodeBean.setDetailCodeName(bean.getCompanyName());

               codeDetailDAO.deleteDetailCode(detailCodeBean);

               break;

            }

         }

         resultMap.put("INSERT", insertList);
         resultMap.put("UPDATE", updateList);
         resultMap.put("DELETE", deleteList);

      return resultMap;
   }
   
  
   public ArrayList<PositionTO> positionList()  {

      return positionDAO.selectPositionList();
   }   

}