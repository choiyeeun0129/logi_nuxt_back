package kr.co.seoulit.erp.sys.dao;

import kr.co.seoulit.erp.sys.to.SysCodeDetailTo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeDetailDao {

	public List<SysCodeDetailTo> selectAllCodeDetailList();
	public List<SysCodeDetailTo> selectPayStepCodeDetailList(String itemClassificationCondition);

	public void insertDetailCode(SysCodeDetailTo codeDetailTo);

	public void updateDetailCode(SysCodeDetailTo codeDetailTo);

	public void deleteDetailCode(SysCodeDetailTo codeDetailTo);
}
