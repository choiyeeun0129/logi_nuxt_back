package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.domain.CompanyInfo;
import kr.co.seoulit.erp.logistic.base.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


@Service
public class CompanyInfoServiceFacadeImpl implements CompanyInfoServiceFacade {
    @Autowired
    private CompanyInfoRepository irepository;
    private ModelMap modelMap = new ModelMap();

    public ModelMap getCompanyInfo(){

        try {
            Iterable<CompanyInfo> companyInfo = irepository.findAll();
            modelMap.put("companyInfo", companyInfo);
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
