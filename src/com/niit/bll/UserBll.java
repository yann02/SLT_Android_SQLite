package com.niit.bll;

import android.content.Context;

import com.niit.dao.UserDao;
import com.niit.model.UserModel;

public class UserBll {
	private UserDao dao;
	public  UserBll(Context context) {
		dao = new UserDao(context);
	}
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public boolean Login(UserModel user){
		
		return dao.Login(user);
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean Register(UserModel user){
		return dao.Register(user);
	}

	//作业：
	//1-完善用户登录和注册
	//2-完成一个简易通讯录（新增联系人、查看联系人（ListView））
}
