package kr.co.seoulit.erp.logistic.base.repository;

import kr.co.seoulit.erp.logistic.base.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
    public Iterable<Client> findAllByCustomerCode(String customerCode);
    public void deleteByCustomerCode(String clientCode);
}
