package kr.co.seoulit.erp.account.base.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.base.to.DetailCodeBean;

@Mapper
public interface AccDetailCodeDAO {

    ArrayList<DetailCodeBean> selectDetailCodeList(HashMap<String, Object> param);

    void insertDetailCode(DetailCodeBean codeDetailBean);

    void updateDetailCode(DetailCodeBean codeDetailBean);

    void deleteDetailCode(String codeNo);

}
