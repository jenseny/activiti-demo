package com.test.activiti.mapper;

import com.test.activiti.model.LeaveBill;

public interface LeaveBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveBill record);

    int insertSelective(LeaveBill record);

    LeaveBill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveBill record);

    int updateByPrimaryKey(LeaveBill record);
}