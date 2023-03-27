package com.hdp.service;

import com.hdp.pojo.User;

public interface UserService extends BaseService<User>{
	User login(User obj);
}
