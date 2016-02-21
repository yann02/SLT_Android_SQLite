package com.niit.dao;

import android.R.integer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库操作帮助类
 * @author Admin
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	
	static String dbname = "user.db";//设置数据库名为user.db
	static int dbVersion = 1;//设置当前数据库版本为1

	/**
	 * 
	 * @param context:上下文
	 * @param name：数据库名
	 * @param factory：查询数据库时候返回一个自定义的cursor
	 * @param version:数据库版本
	 */
	public DBHelper(Context context) {
		super(context, dbname, null, dbVersion);
	}

	//创建数据库，只执行一次
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id integer primary key autoincrement, username varchar(20), password varchar(20))";
		db.execSQL(sql);//执行SQL语句
	}

	//升级数据库
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
