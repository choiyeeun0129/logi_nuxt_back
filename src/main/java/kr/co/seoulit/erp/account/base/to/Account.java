package kr.co.seoulit.erp.account.base.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	private String accountInnerCode;
	
	private String parentAccountInnerCode;
	private String accountCode;
	private String accountCharacter;
	private String accountName;
	private String accountDisplayNameWithCode;
	private String accountDisplayName;
	private String accountDivision;
	private String accountUseCheck;
	private String accountDescription;
	private String groupCode;
	private String editable;
	private String target;
	private String budget;
	private String status;
}
