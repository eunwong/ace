package com.huacainfo.ace.gesp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huacainfo.ace.common.model.UserProp;
import com.huacainfo.ace.common.result.ListResult;
import com.huacainfo.ace.common.result.MessageResponse;
import com.huacainfo.ace.common.result.PageResult;
import com.huacainfo.ace.common.result.SingleResult;
import com.huacainfo.ace.gesp.dao.BsSmsTaskDao;
import com.huacainfo.ace.gesp.model.BsSmsTask;
import com.huacainfo.ace.gesp.service.BsSmsTaskService;
import com.huacainfo.ace.portal.service.DataBaseLogService;

@Service ("bsSmsTaskService")
public class BsSmsTaskServiceImpl   implements BsSmsTaskService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Autowired
	private BsSmsTaskDao daoMapper;
	 
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	private DataBaseLogService dataBaseLogService;
	
	 
	
	@Override
	public PageResult<Map<String, Object>> findList(Map<String, Object> condition, int start, int limit, String orderBy)
			throws Exception {
		PageResult<Map<String, Object>> rst = new PageResult<Map<String, Object>>();
		
		List<Map<String, Object>> list =this.daoMapper.findList(condition, start,
				start + limit, orderBy);
		rst.setRows(list);
		//if (start <= 1) {
			int allRows = this.daoMapper.findCount(condition);
			rst.setTotal(allRows);
		//}
		return rst;
	}
	
	@Override
	public PageResult<Map<String, Object>> findListForSendSMS(Map<String, Object> condition, int start, int limit, String orderBy)
			throws Exception {
		PageResult<Map<String, Object>> rst = new PageResult<Map<String, Object>>();
		
		List<Map<String, Object>> list =this.daoMapper.findListForSendSMS(condition, start,
				start + limit, orderBy);
		rst.setRows(list);
		//if (start <= 1) {
			int allRows = this.daoMapper.findListForSendSMSCount(condition);
			rst.setTotal(allRows);
		//}
		return rst;
	}

	@Override
	public MessageResponse insert(BsSmsTask o, UserProp userProp) throws Exception {
		int effectCount=this.daoMapper.insert(o);
		return new MessageResponse(0, "添加完成！");
	}

	@Override
	public MessageResponse update(BsSmsTask o, UserProp userProp) throws Exception {
		this.daoMapper.update(o);
		return new MessageResponse(0, "更新完成！");
	}
	
	@Override
	public MessageResponse insertSelective(BsSmsTask o, UserProp userProp) throws Exception {
		int effectCount=this.daoMapper.insertSelective(o);
		return new MessageResponse(0, "添加完成！");
	}

	@Override
	public MessageResponse updateSelective(BsSmsTask o, UserProp userProp) throws Exception {
		int effectCount=this.daoMapper.updateSelective(o);
		return new MessageResponse(0, "更新完成！");
	}

	@Override
	public SingleResult<Map<String, Object>> selectByPrimaryKey(String id) throws Exception {
		SingleResult<Map<String, Object>> rst = new SingleResult<Map<String, Object>>();
		rst.setValue(this.daoMapper.selectByPrimaryKey(id));
		return rst;
	}

	@Override
	public MessageResponse deleteById(String id, UserProp userProp) throws Exception {
		MessageResponse rst = new MessageResponse(0,"删除成功！");
		this.daoMapper.deleteByPrimaryKey(id);
 		return rst;
	}

	@Override
	public ListResult<Map<String, Object>> findListTop(Map<String, Object> condition, String orderBy) throws Exception {
		ListResult<Map<String, Object>> rst = new ListResult<Map<String, Object>>();
		List<Map<String, Object>> list = this.daoMapper.findListTop(condition,orderBy);
		rst.setValue(list);
		return rst;
	}

	@Override
	public ListResult<Map<String, Object>> findListByMember(Map<String, Object> condition, String orderBy) {
		ListResult<Map<String, Object>> rst = new ListResult<Map<String, Object>>();
		List<Map<String, Object>> list = this.daoMapper.findListByMember(condition,orderBy);
		rst.setValue(list);
		return rst;
	}
	 
	 
	
}
