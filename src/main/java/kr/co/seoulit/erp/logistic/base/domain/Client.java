package kr.co.seoulit.erp.logistic.base.domain;

import lombok.*;
import sun.jvm.hotspot.gc.shared.Generation;


import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
@Data
public class Client {
    @Id
    @Column(name="CUSTOMER_CODE")
    private String customerCode;
    private String socialSecurityNumber;
    private String customerType;
    private String businessLicenseNumber;
    private String customerCeo;
    private String customerName;
    private String workplaceCode;
    private String customerBasicAddress;
    private String customerBusinessConditions;
    private String customerZipCode;
    private String customerDetailAddress;
    private String customerNote;
    private String customerBusinessItems;
    private String customerTelNumber;
    private String customerFaxNumber;
}
