package kr.co.seoulit.erp.hr.salary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;

@Repository
public interface MonthSalaryRepository extends CrudRepository<MonthSalaryTO, Integer> {

}
