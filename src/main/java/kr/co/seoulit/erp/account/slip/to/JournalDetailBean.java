package kr.co.seoulit.erp.account.slip.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@RequiredArgsConstructor
@SequenceGenerator(
        name = "JOURNAL_DETAIL_GENERATOR",
        sequenceName = "JOURNAL_DETATIL_SEQ"
        ,allocationSize=1//	시퀀스 한 번 호출에 증가하는 수 (성능 최적화에 사용), 데이터베이스 시퀀스 값이 하나씩 증가하도록 설정되어 있으면 이 값을 반드시 1로 설정해야 한다.
)
@Table(name="JOURNAL_DETAIL")
public class JournalDetailBean extends BaseTO{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="JOURNAL_DETAIL_GENERATOR")
    private long journalDetailNo;
    private String journalNo;
    private String accountControlName;
    private String accountControlType;
    private String journalDescription;


}
