package kr.co.seoulit.erp.logistic.base.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="COMPANY")
@Data
public class CompanyInfo {
    @Id
    @Column(name="COMPANY_CODE")
    private String companyCode;
    private String companyName;
    private String companyDivision;
    private String businessLicenseNumber;
    private String corporationLicenseNumber;
    @Column(name="COMPANY_CEO_NAME")
    private String companyCEOName;
    private String companyBusinessConditions;
    private String companyBusinessItems;
    @Column(name="COMPANY_ZIP_CODE")
    private String companyzipCode;
    private String companyBasicAddress;
    private String companyDetailAddress;
    private String companyTelNumber;
    @Column(name="COMPANY_FAX_NUMBER")
    private String companyFAXNumber;
    private String companyEstablishmentDate;
    private String companyOpenDate;
    private String homepage;
}
