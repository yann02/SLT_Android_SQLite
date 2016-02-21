package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.niit.model.UserModel;

public class UserDao {
	private DBHelper dbHelper;
	
	 public UserDao(Context context){
		 dbHelper = new DBHelper(context);
	 }

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public boolean Login(UserModel user){
		SQLiteDatabase database = dbHelper.getReadableDatabase();//打开数据库
		String sql = "select * from user where username = ? and password = ?";
		Cursor cursor = database.rawQuery(sql, new String[]{user.getUsername(),user.getUserpwd()});//查询结果
		if(cursor.moveToFirst() == true){//如果能够将游标移到第一行,说明我们查到了数据
			cursor.close();
			database.close();//数据库的关闭
			return true;
		}
		else {
			database.close();
			return false;
		}
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean Register(UserModel user){
		SQLiteDatabase database = dbHelper.getReadableDatabase();
		String sql = "insert into user(username,password) values (?,?)";
		database.execSQL(sql, new String[]{user.getUsername(),user.getUserpwd()});
		database.close();
		return true;
	}
	
	public List<UserModel> getAllUsers(){
		List<UserModel> lists = new ArrayList<UserModel>();
		SQLiteDatabase database=dbHelper.getReadableDatabase();
		String sql="SELECT * FROM USER";
		Cursor cursor=database.rawQuery(sql,null);
		while (cursor.moveToNext()) {//如果游标能够指向下一条记录
			UserModel model=new UserModel();
			model.setUserid(cursor.getInt(cursor.getColumnIndex("id")));
			model.setUsername(cursor.getString(cursor.getColumnIndex("username")));
			model.setUserpwd(cursor.getString(cursor.getColumnIndex("password")));
			lists.add(model);
		}
		cursor.close();//游标先关闭
		database.close();//数据库关闭
		return lists;
	}

}
