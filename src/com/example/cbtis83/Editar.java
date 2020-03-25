package com.example.cbtis83;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends Activity {
	public EditText etNoA,etNomA,etsemA,etEdadA,etPromA;
	EditText espA,semA;
	String noCtrol;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar);
		etNoA = (EditText) findViewById(R.id.etNoA);
		etNomA = (EditText) findViewById(R.id.etNomA);
		semA = (EditText) findViewById(R.id.semA);
		espA = (EditText) findViewById(R.id.espA); 
		etEdadA = (EditText) findViewById(R.id.etedadA);
		etPromA = (EditText) findViewById(R.id.etPromA);
	}

	public void BUSCAR(View v){
		AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "escuela", null, 1);
		SQLiteDatabase base = admin.getWritableDatabase();
		noCtrol=etNoA.getText().toString();
		Cursor fila=base.rawQuery("Select Nombre, Especialidad, Semestre, Edad, Promedio from Alumnos where NoControl="+noCtrol, null);
		
		if(fila.moveToFirst()){
			etNomA.setText(fila.getString(0));
			semA.setText(fila.getString(1));
			espA.setText(fila.getString(2));
			etEdadA.setText(fila.getString(3));
			etPromA.setText(fila.getString(4));
		}
		else
			Toast.makeText(this, "Elemento no encontrado", Toast.LENGTH_LONG).show();

	}
	public void EDITAR(View v){
		AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "escuela", null, 1);
		SQLiteDatabase base = admin.getWritableDatabase();
		String NoControl = etNoA.getText().toString();
		String Nombre = etNomA.getText().toString();
		String Edad = etEdadA.getText().toString();
		String Promedio = etPromA.getText().toString();
		String Semestre = semA.getText().toString();
		String Esp = espA.getText().toString();
		ContentValues registros = new ContentValues();
		registros.put("NoControl", NoControl);
		registros.put("Nombre", Nombre);
		registros.put("Especialidad", Esp);
		registros.put("Semestre", Semestre);
		registros.put("Edad", Edad);
		registros.put("Promedio", Promedio);
		int re = base.update("Alumnos", registros, "NoControl="+noCtrol, null);
		base.close();
		if(re==1)
			Toast.makeText(this, "Elemento Actualizado", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Elemento no encontrado", Toast.LENGTH_LONG).show();		

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar, menu);
		return true;
	}

}
