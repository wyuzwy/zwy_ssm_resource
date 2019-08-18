package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Register;
import com.zhangwenyu.resource.bean.RegisterExample;
import com.zhangwenyu.resource.dao.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    RegisterMapper registerMapper;


    public Register getCheckId(String uid){

        Register register = registerMapper.selectByPrimaryKey(uid);
        return register;
    }

    public void saveRegister(Register register){
        registerMapper.insertSelective(register);

    }

    public List<Register> selectByCheck(List<Integer> list){
        RegisterExample registerExample = new RegisterExample();
        RegisterExample.Criteria criteria = registerExample.createCriteria();
        criteria.andRegisterCheckIn(list);
        List<Register> registers = registerMapper.selectByExample(registerExample);

        return registers;
    }

    public long countByCheck(List<Integer> list){
        RegisterExample registerExample = new RegisterExample();
        RegisterExample.Criteria criteria = registerExample.createCriteria();
        criteria.andRegisterCheckIn(list);
        long i = registerMapper.countByExample(registerExample);
        return i;

    }

    public List<Register> selectById(List<String> ids){

        RegisterExample registerExample = new RegisterExample();
        RegisterExample.Criteria criteria = registerExample.createCriteria();
        criteria.andRegisterIdIn(ids);
        List<Register> registers = registerMapper.selectByExample(registerExample);
        return registers;
    }


    public void updateRegister(List<Register> registers) {
        for (Register register : registers) {
            registerMapper.updateByPrimaryKey(register);
        }
    }
}
