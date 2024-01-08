package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.domain.Workplace;
import kr.co.seoulit.erp.logistic.base.to.WorkplaceInfoTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

public interface WorkplaceServiceFacade {
    public ModelMap getWorkplaceList();

    public ModelMap getWorkplaceDetailList(String workplaceCode);

    public void insertWorkplaceCode(Workplace workplaceInfoTO);

    public void deleteWorkplaceCode(String workplaceCode);

    void updateWorkplaceCode(Workplace workplaceInfoTO);
}
