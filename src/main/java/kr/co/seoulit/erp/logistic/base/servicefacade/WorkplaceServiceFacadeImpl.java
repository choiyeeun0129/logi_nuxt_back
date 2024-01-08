package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.domain.Workplace;
import kr.co.seoulit.erp.logistic.base.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;


@Service
public class WorkplaceServiceFacadeImpl implements WorkplaceServiceFacade{

    @Autowired
    private WorkplaceRepository workRepository;
    private ModelMap modelMap=new ModelMap();
    @Override
    public ModelMap getWorkplaceList() {
        Iterable<Workplace> workplaceList = workRepository.findAll();
        modelMap.put("workplaceList", workplaceList);
        return modelMap;
    }

    @Override
    public ModelMap getWorkplaceDetailList(String workplaceCode) {
        Iterable<Workplace> workplaceDetailList= workRepository.findAllByWorkplaceCode(workplaceCode);
        modelMap.put("workplaceInfo", workplaceDetailList);

        return modelMap;
    }

    @Override
    public void insertWorkplaceCode(Workplace workplaceInfoTO) {
        workRepository.save(workplaceInfoTO);
    }

    @Transactional
    @Override
    public void deleteWorkplaceCode(String workplaceCode) {
        workRepository.deleteByWorkplaceCode(workplaceCode);
    }

    @Transactional
    @Override
    public void updateWorkplaceCode(Workplace workplaceInfoTO) {
        workRepository.save(workplaceInfoTO);
    }
}
