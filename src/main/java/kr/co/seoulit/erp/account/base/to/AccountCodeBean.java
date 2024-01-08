package kr.co.seoulit.erp.account.base.to;



import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
	@Data
	public class AccountCodeBean  extends BaseTO{

			private String accountLevel;
			private String leaf;
			private String accountInnerCode;
			private String parentAccountInnerCode;
			private String accountCode;
			private String accountCharacter;
			private String accountName;
			private String accountDispalyNameWithCode;
			private String accountDisplayName;
			private String accountDivision;
			private String accountUseCheck;
			private String accountDescription;
			private String groupCode;
			
	}
