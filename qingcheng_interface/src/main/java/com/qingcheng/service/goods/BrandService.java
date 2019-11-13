package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import java.util.List;
import java.util.Map;
/**
 * 服务接口，声明方法
 */
public interface BrandService {

    /*查找所有品牌*/
    public List<Brand> findAll();

    /*分页查找品牌*/
    public PageResult<Brand> findPage(int page,int size);

    /*按条件查询品牌,传参为Map对象*/
    public List<Brand> findList(Map<String, Object> searchMap);

    /*品牌条件+分页查询*/
    public PageResult<Brand> findPageList(Map<String,Object> searchMap,int page,int size);

    /*根据Id查询品牌*/
    public Brand findById(Integer id);

    /*添加品牌*/
    public void add(Brand brand);

   /* 修改品牌*/
    public void update(Brand brand);

   /* 删除品牌*/
    public void delete(Integer id);
}
