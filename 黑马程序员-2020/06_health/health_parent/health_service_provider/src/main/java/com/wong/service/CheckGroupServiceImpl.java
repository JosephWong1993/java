package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.CheckGroupDao;
import com.wong.pojo.CheckGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    private final CheckGroupDao checkGroupDao;

    public CheckGroupServiceImpl(CheckGroupDao checkGroupDao) {
        this.checkGroupDao = checkGroupDao;
    }

    /**
     * 添加检查组，同时需要关联检查项信息（操作中间关系表）
     */
    @Override
    public void add(Integer[] checkItemIds, CheckGroup checkGroup) {
        checkGroupDao.add(checkGroup);
        setCheckGroupAndCheckItem(checkItemIds, checkGroup.getId());
    }

    /**
     * 设置关联关系
     */
    public void setCheckGroupAndCheckItem(Integer[] checkItemIds, Integer checkGroupId) {
        //设置检查组和检查项的关联关系
        if (checkItemIds != null && checkItemIds.length > 0) {
            for (Integer checkItemId : checkItemIds) {
                Map map = new HashMap();
                map.put("checkGroupId", checkGroupId);
                map.put("checkItemId", checkItemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
