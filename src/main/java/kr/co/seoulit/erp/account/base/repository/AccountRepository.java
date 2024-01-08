package kr.co.seoulit.erp.account.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.erp.account.base.to.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

	Account findByAccountInnerCode(String accountInnerCode);

}
