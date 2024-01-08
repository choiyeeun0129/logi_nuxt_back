package kr.co.seoulit.erp.account.slip.repository;

import kr.co.seoulit.erp.account.slip.to.JournalDetailBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface JournalDetailRepository extends JpaRepository<JournalDetailBean,Integer> {

    ArrayList<JournalDetailBean> findByJournalNo(String journalNo);
}
