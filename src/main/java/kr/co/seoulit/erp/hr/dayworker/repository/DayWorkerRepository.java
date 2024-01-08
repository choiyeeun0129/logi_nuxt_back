package kr.co.seoulit.erp.hr.dayworker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;

@Repository
public interface DayWorkerRepository extends CrudRepository<DayWorkerTO, String>{
	public List<DayWorkerTO> findByEmpCodeAndEmpName(String empCode, String empName);
}
