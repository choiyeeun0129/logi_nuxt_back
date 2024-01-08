package kr.co.seoulit.erp.account.slip.repository;

import kr.co.seoulit.erp.account.slip.to.SlipBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlipReposiotry extends JpaRepository<SlipBean,String> {

}
