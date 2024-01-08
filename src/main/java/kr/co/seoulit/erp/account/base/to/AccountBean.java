package kr.co.seoulit.erp.account.base.to;

import java.util.ArrayList;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class AccountBean extends BaseTO{
	
	private ArrayList<AccountControlBean> accountControlList;
    private String accountInnerCode;
    private String parentAccountInnercode;
    private String accountCode;
    private String accountCharacter;
    private String accountName;
    private String accountUseCheck;
    private String accountDivision;
    private String accountDescription;
    private String editable;
    private String groupCode;
    private String lev;
    private String status;

}
