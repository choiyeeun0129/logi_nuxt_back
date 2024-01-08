package kr.co.seoulit.erp.logistic.base.repository;

import kr.co.seoulit.erp.logistic.base.domain.Finance;
import org.springframework.data.repository.CrudRepository;

public interface FinanceRepository extends CrudRepository<Finance,String> {
    public Iterable<Finance> findAllByAccountAssociatesCode(String accountAssociatesCode);
    public void deleteByAccountAssociatesCode(String accountAssociatesCode);
}
