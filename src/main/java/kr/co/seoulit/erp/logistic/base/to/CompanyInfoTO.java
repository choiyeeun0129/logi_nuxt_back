package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyInfoTO extends BaseTO {
    private String companyCode;
    private String companyName;
    private String companyDivision;
    private String businessLicenseNumber;
    private String corporationLicenseNumber;
    private String companyCEOName;
    private String companyBusinessCondition;
    private String companyBusinessItem;
    private String companyZIPCode;
    private String companyBasicAddress;
    private String companyDetailAddress;
    private String companyTelNumber;
    private String companyFAXNumber;
    private String companyEstablishmentDate;
    private String companyOpenDate;
    private String homepage;
}
