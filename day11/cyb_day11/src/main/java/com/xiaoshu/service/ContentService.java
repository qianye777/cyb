package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.ContentMapper;
import com.xiaoshu.dao.GoryMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentVo;
import com.xiaoshu.entity.Gory;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class ContentService {

	@Autowired
	private ContentMapper cm;

	@Autowired
	private GoryMapper gm;
	
	// 新增
	public void add(Content t) throws Exception {
		t.setCreatetime(new Date());
		cm.insert(t);
	};

	// 修改
	public void update(Content t) throws Exception {
		cm.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteContent(Integer id) throws Exception {
		cm.deleteByPrimaryKey(id);
	};

	public PageInfo<ContentVo> findContentPage(ContentVo c, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<ContentVo> cList = cm.queryContent(c);
		PageInfo<ContentVo> pageInfo = new PageInfo<ContentVo>(cList);
		return pageInfo;
	}


	public List<Gory> findGory() {
		return gm.selectAll();
	}

	public List<ContentVo> findEcharts() {
		return cm.findEcharts();
	}




}
