package kr.co.seoulit.erp.logistic.base.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORKPLACE")
@Data
public class Workplace {
    @Id
    @Column(name="WORKPLACE_CODE")
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
    private String workplaceEstablishDate;
    private String workplaceOpenDate;
    private String workplaceCloseDate;
    private String isMainOffice;
    private String approvalStatus;
}
