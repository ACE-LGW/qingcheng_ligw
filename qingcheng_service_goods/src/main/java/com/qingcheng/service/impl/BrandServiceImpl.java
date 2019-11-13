package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
import java.util.Map;

/**
 * 服务接口方法的实现类，方法的具体实现
 */
@Service
public class BrandServiceImpl implements BrandService {

    /*用注解方法调用数据访问层，注本地的用Autowired，注远程的用Reference*/
    @Autowired
    private BrandMapper brandMapper;

    /*查询所有品牌*/
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /*分页查询所有品牌*/
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        /*调用Mybatis分页插件*/
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();

        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }

    /*实现按条件查询*/
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        /*调用封装的Example条件*/
        Example example = createExample(searchMap);

        return brandMapper.selectByExample(example);
    }

    /*根据id删除品牌*/
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /*修改品牌*/
    @Override
    public void update(Brand brand) {
        //该方法根据主键修改，且如果brand包含null值，null会被忽略，null不会更新到数据库，null对应的数据库原值不会被覆盖
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /*添加品牌*/
    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    /*根据Id查询品牌*/
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /* 品牌条件+分页查询*/
    @Override
    public PageResult<Brand> findPageList(Map<String, Object> searchMap, int page, int size) {
        /*调用封装的Example条件*/
        Example example = createExample(searchMap);
        /*调用Mybatis分页插件*/
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectByExample(example);

        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }

    /*封装Example条件，可以共用*/
    public Example createExample(Map<String, Object> searchMap) {
        /*实例化example,接受一个需要查询类的class*/
        Example example = new Example(Brand.class);

        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            if (searchMap.get("name") != null && !"".equals((String) searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");/*模糊查询*/
            }
            if (searchMap.get("letter") != null && !"".equals((String) searchMap.get("letter"))) {
                criteria.andEqualTo("letter", (String) searchMap.get("letter"));/*精确查询*/
            }
        }
        return example;
    }
}
