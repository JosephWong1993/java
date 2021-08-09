package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wong.constant.MessageConstant;
import com.wong.dao.CheckItemDao;
import com.wong.entity.PageResult;
import com.wong.entity.QueryPageBean;
import com.wong.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 检查项服务
 */
@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增检查项
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    /**
     * 分页
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //开始分页-设置分页条件
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<CheckItem> page = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据id删除检查项，业务规则：如果当前检查项已经被关联到某个检查组，则不能删除
     */
    @Override
    public void deleteById(Integer id) {
        //查询当前检查项是否已经关联到检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count > 0) {
            //已经被关联，不能删除
            throw new RuntimeException(MessageConstant.CHECKITEM_HAS_ASSOCIATION);
        }
        //未被关联，可以删除
        checkItemDao.deleteById(id);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }
}
