package kr.co.seoulit.erp.sys.to;

import java.util.List;

import lombok.Data;

@Data
public class MenuTo {
	
    private String menuCode;
    private String menuName;
    private String menuUrl;
    private String icon;
    private String superMenuCode;
	private String usingStatus;
	private String level;
	private List<MenuTo> subMenuList;
	private String authorityLevel;
}
