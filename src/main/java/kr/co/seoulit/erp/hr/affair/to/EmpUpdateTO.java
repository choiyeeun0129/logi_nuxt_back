package kr.co.seoulit.erp.hr.affair.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpUpdateTO {
    private String birthDate;
    private String deptCode;
    private String empCode;
    private String empName;
    private String gender;
    private String authorityCodeNumber;
    private String basicAddress;
    private String detailAddress;
    private String email;
    private String levelOfEducation;
    private String phoneNumber;
    private String positionCode;
    private String userId;
    private String workplaceCode;
    private String zipCode;
}
