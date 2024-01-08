package kr.co.seoulit.erp.hr.company.to;




import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false) 
public class PositionTO extends BaseTO {
    
    private String positionName;
    private String positionCode;

}