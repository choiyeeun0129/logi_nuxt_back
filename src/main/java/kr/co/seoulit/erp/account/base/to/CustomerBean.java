package kr.co.seoulit.erp.account.base.to;

import kr.co.seoulit.common.to.*;
import lombok.*;


//================================ 2020-08-31 조편백 거래처 관리 Bean 생성 =================================

@EqualsAndHashCode(callSuper=false)
@Data
public class CustomerBean extends BaseTO{
	private String customerCode;
	private String workplaceCode;
	private String customerName;
	private String customerType;
	private String customerCeo;
	private String businessLicenseNumber;
	private String socialSecurityNumber;
	private String customerBusinessConditions;
	private String customerBusinessItems;
	private String customerZipCode;
	private String customerBasicAddress;
	private String customerDetailAddress;
	private String customerTelNumber;
	private String customerFaxNumber;
	private String accountNumber;
	private String cardNumber;
	private String customerNote;
	private String cardType;
	private String cardMemberName;
	private String cardOpenPlace;
	private String financialInstituteName;
	private String financialInstituteCode; 
	private String status;
 
}  



