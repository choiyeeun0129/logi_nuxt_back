package kr.co.seoulit.erp.logistic.base.repository;

import kr.co.seoulit.erp.logistic.base.domain.Workplace;
import org.springframework.data.repository.CrudRepository;

public interface WorkplaceRepository extends CrudRepository<Workplace, String> {
    public Iterable<Workplace> findAllByWorkplaceCode(String workplaceCode);
    public void deleteByWorkplaceCode(String workplaceCode);
}
