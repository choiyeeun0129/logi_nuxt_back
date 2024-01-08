package kr.co.seoulit.erp.account.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.base.to.CodeBean;

@Mapper
public interface AccCodeDAO {

    public ArrayList<CodeBean> selectCodeList();

    public void insertCode(CodeBean codeBean);

    public void updateCode(CodeBean codeBean);

    public void deleteCode(String Code);

}
