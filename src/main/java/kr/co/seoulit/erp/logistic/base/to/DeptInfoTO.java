package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DeptInfoTO extends BaseTO {
    private String workplaceCode;
    private String deptCode;
    private String deptName;
    private String workplaceName;
    private String companyCode;
    private String deptStartDate;
    private String deptEndDate;
}
