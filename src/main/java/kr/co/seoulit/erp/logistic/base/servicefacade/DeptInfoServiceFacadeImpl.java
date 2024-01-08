package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.domain.Department;
import kr.co.seoulit.erp.logistic.base.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;

@Service
public class DeptInfoServiceFacadeImpl implements DeptInfoServiceFacade {

    @Autowired
    private DepartmentRepository DRepository;
    private ModelMap modelMap=new ModelMap();
    public ModelMap getDeptInfo() {
        try {
            Iterable<Department> deptInfo = DRepository.findAll();
            modelMap.put("deptInfo", deptInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());
        }


        return modelMap;
    }
}
