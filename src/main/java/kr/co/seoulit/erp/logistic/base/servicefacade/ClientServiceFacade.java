package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.domain.Finance;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientServiceFacade {

    public ModelMap searchClientList();
    public ModelMap searchClientDetailList(String customerCode);
    public void insertClient(Client clientdata);
    public void updateClient(Client clientdata);
    public void deleteClient(String customerCode);

    public ModelMap searchFinanceList();
    public ModelMap searchFinanceDetailList(String Code);
    public void insertFinance(Finance clientdata);
    public void updateFinance(Finance clientdata);
    public void deleteFinance(String accountAssociatesCode);
}
