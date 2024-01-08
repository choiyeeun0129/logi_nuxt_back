package kr.co.seoulit.erp.hr.company.to;


import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false) 
public class CompanyTO extends BaseTO {
	 private String companyTelNumber;
	 private String companyDivision;
	 private String companyBasicAddress;
	 private String companyOpenDate;
	 private String companyBusinessItems;
	 private String businessLicenseNumber;
	 private String companyName;
	 private String companyDetailAddress;
	 private String companyFaxNumber;
	 private String companyCeoName;
	 private String companyEstablishmentDate;
	 private String companyCode;
	 private String homepage;
	 private String corporationLicenseNumber;
	 private String companyBusinessConditions;
	 private String companyZipCode;

}