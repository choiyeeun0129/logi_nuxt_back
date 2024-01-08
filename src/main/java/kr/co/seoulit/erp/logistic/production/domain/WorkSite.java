package kr.co.seoulit.erp.logistic.production.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "WORK_SITE")
public class WorkSite {

    private String productionProcessCode;
    @Id
    private String workSiteCode;
    private String workSiteName;




    public WorkSite() {
    }
}
