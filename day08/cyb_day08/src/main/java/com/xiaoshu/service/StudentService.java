package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.SchoolMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.School;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class StudentService {

	@Autowired
	private StudentMapper sm;
	
	@Autowired
	private SchoolMapper scm;

	// 新增
	public void add(Student t) throws Exception {
		sm.insert(t);
	};

	// 修改
	public void updateStudent(Student t) throws Exception {
		sm.updateByPrimaryKeySelective(t);
	};

	
	// 删除
	public void deleteStudent(Integer id) throws Exception {
		sm.deleteByPrimaryKey(id);
	};
	

	public PageInfo<StudentVo> findStudentPage(StudentVo s, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<StudentVo> studentList = sm.queryStudent(s);
		PageInfo<StudentVo> pageInfo = new PageInfo<StudentVo>(studentList);
		return pageInfo;
	}



	public List<School> querySchool() {
		return scm.selectAll();
	}

	public List<StudentVo> findExcel(StudentVo studentVo) {
		return sm.queryStudent(studentVo);
	}


}
