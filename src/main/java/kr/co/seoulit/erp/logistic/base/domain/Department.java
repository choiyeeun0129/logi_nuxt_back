package kr.co.seoulit.erp.logistic.base.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="DEPARTMENT")
@Data
@IdClass(DepartmentId.class)
public class Department implements Serializable {
    @Id @Column(name="WORKPLACE_CODE")
    private String workplaceCode;
    @Id @Column(name="DEPT_CODE")
    private String deptCode;
    private String deptName;
    private String workplaceName;
    private String companyCode;
    private String deptStartDate;
    private String deptEndDate;
}
