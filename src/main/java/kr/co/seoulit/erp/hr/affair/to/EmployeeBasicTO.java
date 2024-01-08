package kr.co.seoulit.erp.hr.affair.to;


import java.util.List;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeBasicTO extends BaseTO {
	 private String companyCode;
	 private String empCode;
	 private String empName;
	 private String empEngName;
	 private String socialSecurityNumber;
	 private String hireDate;
	 private String retirementDate;
	 private String userOrNot;
	 private String birthDate;
	 private String gender;
	 private String deptCode;
	 private String deptName;
	 
	 private String zipCode;
	 private String basicAddress;
	 private String image;
	 private String positionCode;
	 private String positionName;
	 private String updateDate;
	 private String email;
	 private String levelOfEducation;
	 
	 private List<WorkInfoTO> workInfoList;
	 private List<CareerInfoTO> careerInfoList;
	 private List<EducationInfoTO> educationInfoList;
	 private List<FamilyInfoTO> familyInfoList;

}