package kr.co.seoulit.erp.account.base.repository;


import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountControllRepository extends JpaRepository<AccountControlBean,String> {
}
