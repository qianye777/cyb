package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Gory;
import com.xiaoshu.entity.GoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoryMapper extends BaseMapper<Gory> {
    long countByExample(GoryExample example);

    int deleteByExample(GoryExample example);

    List<Gory> selectByExample(GoryExample example);

    int updateByExampleSelective(@Param("record") Gory record, @Param("example") GoryExample example);

    int updateByExample(@Param("record") Gory record, @Param("example") GoryExample example);
}