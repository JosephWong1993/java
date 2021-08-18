package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wong.dao.CheckGroupDao;
import com.wong.entity.PageResult;
import com.wong.entity.QueryPageBean;
import com.wong.pojo.CheckGroup;
import com.wong.pojo.CheckItem;
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

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //开始分页-设置分页条件
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<CheckGroup> page = checkGroupDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
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
