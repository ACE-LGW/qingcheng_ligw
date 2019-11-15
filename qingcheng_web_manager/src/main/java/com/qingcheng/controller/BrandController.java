package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * goods的前端访问控制器，方法请求路径类似：http://localhost:9101/brand/findAll.do
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    /*用注解方法调用服务，注本地的用Autowired，注远程的用Reference*/
    @Reference
    private BrandService brandService;

    /*查询所有*/
    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    /*分页查询所有*/
    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page,int size){
       return brandService.findPage(page,size);
    }

    /*按条件查询品牌*/
    @PostMapping("/findList")
    public List<Brand> findList( @RequestBody Map searchMap){
        return brandService.findList(searchMap);
    }

    /*品牌条件+分页查询*/
    @PostMapping("/findPageList")
    public PageResult<Brand> findPageList(@RequestBody Map searchMap,int page,int size){
        return brandService.findPageList(searchMap,page,size);
    }

    /*根据Id查询品牌*/
    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    /*添加品牌*/
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        /*测试异常
        int x=1/0;*/
        brandService.add(brand);
        return new Result();
    }

    /*修改品牌*/
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }

    /*根据id删除品牌*/
    @GetMapping("/delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }
}
