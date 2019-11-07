package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;

public interface IUserService  {
    /*创建用户 vo对象的定义方便管理*/
    CreateUserResponse createUser(CreateUserRequest request)
        throws AdException;



}
