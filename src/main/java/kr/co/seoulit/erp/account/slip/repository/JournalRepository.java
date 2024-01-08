package kr.co.seoulit.erp.account.slip.repository;


import kr.co.seoulit.erp.account.slip.to.JournalBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalBean,String> {
}
