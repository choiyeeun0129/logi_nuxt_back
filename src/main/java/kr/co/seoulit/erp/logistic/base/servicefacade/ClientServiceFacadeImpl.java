package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.domain.Finance;
import kr.co.seoulit.erp.logistic.base.repository.ClientRepository;
import kr.co.seoulit.erp.logistic.base.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;




@Service
public class ClientServiceFacadeImpl implements ClientServiceFacade{
    @Autowired
    private ClientRepository crepository;
    @Autowired
    private FinanceRepository frepository;

    private ModelMap modelMap = new ModelMap();

    /*****************************
     일반거래처
     *****************************/
    public ModelMap searchClientList(){
        try {
            Iterable<Client> clientInfo = crepository.findAll();
            modelMap.put("clientInfo", clientInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @Override
    public ModelMap searchClientDetailList(String customerCode) {
        try {
            Iterable<Client> clientDetailInfo = crepository.findAllByCustomerCode(customerCode);

            modelMap.put("clientDetailInfo", clientDetailInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @Override
    public void insertClient(Client clientdata) { crepository.save(clientdata); }
    @Transactional
    @Override
    public void updateClient(Client clientdata) { crepository.save(clientdata); }

    @Transactional
    @Override
    public void deleteClient(String customerCode) {
        crepository.deleteByCustomerCode(customerCode);
    }


    /*****************************
     금융거래처
     *****************************/
    @Override
    public ModelMap searchFinanceList() {
        try {
            Iterable<Finance> financeInfo = frepository.findAll();
            modelMap.put("financeInfo", financeInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @Override
    public ModelMap searchFinanceDetailList(String Code) {
        try {
            Iterable<Finance> financedetailInfo = frepository.findAllByAccountAssociatesCode(Code);
            modelMap.put("financeDetailInfo", financedetailInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @Override
    public void insertFinance(Finance clientdata) { frepository.save(clientdata);}
    @Transactional
    @Override
    public void updateFinance(Finance clientdata) {
        frepository.save(clientdata);
    }
    @Transactional
    @Override
    public void deleteFinance(String accountAssociatesCode)
    { frepository.deleteByAccountAssociatesCode(accountAssociatesCode);}

}
