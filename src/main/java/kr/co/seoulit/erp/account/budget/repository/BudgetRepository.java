package kr.co.seoulit.erp.account.budget.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.erp.account.budget.to.BudgetBean;

public interface BudgetRepository extends JpaRepository<BudgetBean, String>{

	ArrayList<BudgetBean> findByDeptCodeAndWorkplaceCodeAndBudgetingCode(String deptCode, String workplaceCode, String budgetingCode);

//	BudgetBean findByEmpName(String name);
//
//	BudgetBean findByEmpCode(String empCode);
//
//	ArrayList<BudgetBean> findByDeptCode(String value);
//
//	ArrayList<BudgetBean> findAllByEmpName(String value);

	
}
