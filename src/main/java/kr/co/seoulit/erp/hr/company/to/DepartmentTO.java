package kr.co.seoulit.erp.hr.company.to;


import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DepartmentTO extends BaseTO  {
	 private String workplaceName;
	 private String deptName;
	 private String deptCode;
	 private String workplaceCode;
	 private String companyCode;
	 private String deptEndDate;
	 private String deptStartDate;
}