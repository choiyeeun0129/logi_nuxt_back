package kr.co.seoulit.erp.hr.base.to;

import lombok.Data;

@Data
public class ReportTO {
   private String empName, hiredate, occupation, employmentType, position, address, detailAddress, deptName;
}