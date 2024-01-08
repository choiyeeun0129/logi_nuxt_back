package kr.co.seoulit.erp.account.budget.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name="BUDGET")
@IdClass(value=BudgetBeanPK.class)
public class BudgetBean implements Serializable{

	@Id
	private String budgetingCode;
	
	@Id
	private String deptCode;
	@Id
	private String workplaceCode;
	@Id
	private String accountInnerCode;
	@Id
	private String accountPeriodNo;
	
//	private int m1Budget;
//	private int m2Budget;
//	private int m3Budget;
//	private int m4Budget;
//	private int m5Budget;
//	private int m6Budget;
//	private int m7Budget;
//	private int m8Budget;
//	private int m9Budget;
//	private int m10Budget;
//	private int m11Budget;
//	private int m12Budget;
	@Column(name = "M1_BUDGET")
	private int m1Budget;
	@Column(name = "M2_BUDGET")
	private int m2Budget;
	@Column(name = "M3_BUDGET")
	private int m3Budget;
	@Column(name = "M4_BUDGET")
	private int m4Budget;
	@Column(name = "M5_BUDGET")
	private int m5Budget;
	@Column(name = "M6_BUDGET")
	private int m6Budget;
	@Column(name = "M7_BUDGET")
	private int m7Budget;
	@Column(name = "M8_BUDGET")
	private int m8Budget;
	@Column(name = "M9_BUDGET")
	private int m9Budget;
	@Column(name = "M10_BUDGET")
	private int m10Budget;
	@Column(name = "M11_BUDGET")
	private int m11Budget;
	@Column(name = "M12_BUDGET")
	private int m12Budget;
}
