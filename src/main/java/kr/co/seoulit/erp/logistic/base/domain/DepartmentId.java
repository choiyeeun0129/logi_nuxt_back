package kr.co.seoulit.erp.logistic.base.domain;

import java.io.Serializable;
import lombok.*;
@Getter
@Setter
public class DepartmentId implements Serializable {
    private String workplaceCode;
    private String deptCode;

    // 생성자, getter, setter 등
}
