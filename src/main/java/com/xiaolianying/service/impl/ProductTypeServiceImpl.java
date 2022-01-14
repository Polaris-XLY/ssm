package com.xiaolianying.service.impl;

import com.xiaolianying.mapper.ProductTypeMapper;
import com.xiaolianying.pojo.ProductType;
import com.xiaolianying.pojo.ProductTypeExample;
import com.xiaolianying.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {

        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
