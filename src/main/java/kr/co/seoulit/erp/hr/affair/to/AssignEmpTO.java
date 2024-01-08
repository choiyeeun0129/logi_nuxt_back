package kr.co.seoulit.erp.hr.affair.to;



import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class AssignEmpTO extends BaseTO{
   private String empAssignCode;
   private String empCode;
   private String assignType;
   private String empName; 
   private String assignDate;
   private String empPosition; 
   private String currentDivision;
   private String assignDivision;
   private String empAssign;
   private String assignCode;
}