package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Register;


import java.util.List;


public interface RegisterService {



     Register getCheckId(String uid);

     void saveRegister(Register register);
     List<Register> selectByCheck(List<Integer> list);

     long countByCheck(List<Integer> list);

     List<Register> selectById(List<String> ids);


     void updateRegister(List<Register> registers) ;
}
