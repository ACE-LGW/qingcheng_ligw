package com.qingcheng.dao;

import com.qingcheng.pojo.goods.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * 数据访问层，使用通用Mapper（BrandMapper接口继承Mapper，即具有了Mapper的增删查改的整套方法）
 */
public interface BrandMapper extends Mapper<Brand> {
}
