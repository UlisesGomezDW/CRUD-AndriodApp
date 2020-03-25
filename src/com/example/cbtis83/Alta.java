package com.example.cbtis83;

 

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase; 
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
 

public class Alta extends Activity {
	public EditText etNo,etNom, etEdad,etProm;
	Spinner esp,sem;
	String espec="";
	Integer Nsem;
	String [] Esp={"Programación","Contrucción","Contabilidad","M. Automotriz",
			"S.M. Compúto"};
	Integer [] Seme={1,2,3,4,5,6};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alta);
		etNo = (EditText) findViewById(R.id.etNo);
		etNom = (EditText) findViewById(R.id.etNom);
		sem = (Spinner) findViewById(R.id.sem);
		esp = (Spinner) findViewById(R.id.esp);
		etEdad = (EditText) findViewById(R.id.etedad);
		etProm = (EditText) findViewById(R.id.etProm);
		ArrayAdapter<String >adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Esp);
		ArrayAdapter<Integer >adaptador= new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,Seme);
		
		esp.setAdapter(adapter);
		sem.setAdapter(adaptador);
		
		esp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
				case 0: 
					espec="Programación";
				break;
				case 1:
					espec="Contabilidad";
				break;	
				case 2:
					espec="Contrucción";
				break;
				case 3:
					espec="M. Automotriz";
				break;
				case 4:
					espec="S.M. Compúto";
				break;
				}			
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub			
			}
			 
		});
		
		 sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				switch(arg2){
				case 0: 
					Nsem=1;
				break;
				case 1: 
					Nsem=2;
				break;
				case 2: 
					Nsem=3;
				break;
				case 3: 
					Nsem=4;
				break;
				case 4: 
					Nsem=5;
				break;
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub			
			}}); 
	}
 
	public void ALTA(View v){
		AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "escuela", null, 1);
		SQLiteDatabase base = admin.getWritableDatabase();
		String NoControl = etNo.getText().toString();
		String Nombre = etNom.getText().toString();
		String Edad = etEdad.getText().toString();
		String Promedio = etProm.getText().toString(); 
		ContentValues registros = new ContentValues();
		registros.put("NoControl", NoControl);
		registros.put("Nombre", Nombre);
		registros.put("Especialidad", espec);
		registros.put("Semestre", Nsem);
		registros.put("Edad", Edad);
		registros.put("Promedio", Promedio);
		base.insert("Alumnos", null, registros);
		Toast.makeText(this, "Guardando....", Toast.LENGTH_LONG).show();
		finish();
	}
}
