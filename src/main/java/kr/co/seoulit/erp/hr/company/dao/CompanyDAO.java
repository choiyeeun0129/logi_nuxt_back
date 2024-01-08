package kr.co.seoulit.erp.hr.company.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.company.to.CompanyTO;

@Mapper
public interface CompanyDAO {
   
   public ArrayList<CompanyTO> selectCompanyList();
   
   public void insertCompany(CompanyTO TO);
   
   public void updateCompany(CompanyTO TO);

   public void deleteCompany(CompanyTO TO);
   
}