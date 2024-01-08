package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WorkplaceInfoTO extends BaseTO {

    private String workplaceCode;
    private String companyCode;
    private String workplaceName;
    private String businessLicenseNumber;
    private String corporationLicenseNumber;
    private String workplaceCeoName;
    private String workplaceBusinessConditions;
    private String workplaceBusinessItems;
    private String workplaceZipCode;
    private String workplaceBasicAddress;
    private String workplaceDetailAddress;
    private String workplaceTelNumber;
    private String workplaceFaxNumber;
    private String workplaceEstablishmentDate;
    private String workplaceOpenDate;
    private String workplaceCloseDate;
    private String isMainOffice;
    private String approvalStatus;


}
