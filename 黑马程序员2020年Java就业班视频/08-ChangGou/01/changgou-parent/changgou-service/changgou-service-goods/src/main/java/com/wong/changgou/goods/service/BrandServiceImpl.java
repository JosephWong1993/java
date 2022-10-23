package com.wong.changgou.goods.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wong.changgou.goods.dao.BrandMapper;
import com.wong.changgou.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<Brand> searchPage(Map<String, String> searchMap, int pageNo, int pageSize) {
        // 使用分页器进行分页
        PageHelper.startPage(pageNo, pageSize);
        // 构建查询对象
        Example example = new Example(Brand.class);

        // 这个要求必须结合着 brandMapper.selectCountByExample(example); 来用，相当于执行select count(name) from tb_brand
//        example.setCountProperty("name");
//        example.setOrderByClause("name desc"); // 相当于 select * from tb_brand order by name desc
//        example.setDistinct(true); // 相当于 select distinct name from tb_brand

        // 构建查询条件对象
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null && searchMap.size() > 0) {
            if (StringUtils.isNotEmpty(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            if (StringUtils.isNotEmpty(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }
        }

        return (Page<Brand>) brandMapper.selectByExample(example);
    }
}