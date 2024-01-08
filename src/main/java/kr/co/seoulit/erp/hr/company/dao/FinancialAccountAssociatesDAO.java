package kr.co.seoulit.erp.hr.company.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.company.to.FinancialAccountAssociatesTO;

@Mapper
public interface FinancialAccountAssociatesDAO {

	public ArrayList<FinancialAccountAssociatesTO> selectFinancialAccountAssociatesListByCompany();

	public ArrayList<FinancialAccountAssociatesTO> selectFinancialAccountAssociatesListByWorkplace(
			String workplaceCode);

	public void insertFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

	public void updateFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

	public void deleteFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

}
