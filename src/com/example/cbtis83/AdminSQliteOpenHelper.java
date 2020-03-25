package com.example.cbtis83;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQliteOpenHelper extends SQLiteOpenHelper {

	public AdminSQliteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL("Create Table Alumnos (NoControl integer primary key, Nombre text, Especialidad text, Semestre integer, Edad integer, Promedio integer)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL("drop table if exists Alumnos");
		arg0.execSQL("Create Table Alumnos (NoControl integer primary key, Nombre text, Especialidad text, Semestre integer, Edad integer, Promedio integer)");
		
	}

}
