package com.xiaolianying.service.impl;

import com.xiaolianying.mapper.AdminMapper;
import com.xiaolianying.pojo.Admin;
import com.xiaolianying.pojo.AdminExample;
import com.xiaolianying.service.AdminService;
import com.xiaolianying.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //所有的业务逻辑层，一定要有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户名或到DB中查询相应用户对象
        //如果有查询条件，则要创建AdminExample的对象来封装条件
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() > 0) {
            Admin admin = list.get(0);
            //如果查询到用户对象，再进行密码的比对
            String mipwd = MD5Util.getMD5(pwd);
            if (mipwd.equals(admin.getaPass())) {
                return admin;
            }
        }
        return null;
    }
}
