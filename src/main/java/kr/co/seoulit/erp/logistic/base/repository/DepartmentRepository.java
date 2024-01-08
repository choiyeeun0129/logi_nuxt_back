package kr.co.seoulit.erp.logistic.base.repository;

import kr.co.seoulit.erp.logistic.base.domain.Department;
import kr.co.seoulit.erp.logistic.base.domain.DepartmentId;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, DepartmentId> {
}
