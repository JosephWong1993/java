package com.wong.changgou.goods.controller;

import com.github.pagehelper.Page;
import com.wong.changgou.entity.PageResult;
import com.wong.changgou.entity.Result;
import com.wong.changgou.entity.StatusCode;
import com.wong.changgou.goods.service.BrandService;
import com.wong.changgou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll() {
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询全部品牌成功", brandList);
    }

    /**
     * 根据ID查询品牌数据
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
//        int i = 1 / 0;
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", brand);
    }

    /***
     * 新增品牌数据
     */
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 修改品牌数据
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Brand brand) {
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 根据ID删除品牌数据
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 分页搜索实现
     */
    @GetMapping(value = "/searchPage/{pageNo}/{pageSize}")
    public Result<List<Brand>> searchPage(@RequestParam Map<String, String> searchMap, @PathVariable int pageNo, @PathVariable int pageSize) {
        Page<Brand> page = brandService.searchPage(searchMap, pageNo, pageSize);
        PageResult<Brand> pageResult = new PageResult<>(page.getTotal(), page.getResult());
        return new Result<>(true, StatusCode.OK, "根据条件分页查询成功", pageResult);
    }
}