package com.example.cbtis83;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Baja extends Activity{
public EditText etNoE;
TextView Nom;
String noCtrol;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baja);
		etNoE = (EditText) findViewById(R.id.etNoE);
		Nom = (TextView) findViewById(R.id.INom);
		
	}


	public void BUSCAR(View v){
		AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "escuela", null, 1);
		SQLiteDatabase base = admin.getWritableDatabase();
		noCtrol=etNoE.getText().toString();
		Cursor fila=base.rawQuery("Select Nombre from Alumnos where NoControl="+noCtrol, null);
		if(fila.moveToFirst()){
			Nom.setText(fila.getString(0));
		}
		else
			Toast.makeText(this, "Elemento no encontrado", Toast.LENGTH_LONG).show();

	}
	
	private void Aceptar() {
		AdminSQliteOpenHelper admin= new AdminSQliteOpenHelper(this, "escuela", null, 1);
		SQLiteDatabase base = admin.getWritableDatabase();
		
		noCtrol=etNoE.getText().toString();
		int registro = base.delete("Alumnos", "NoControl="+noCtrol, null);
		base.close();
		if(registro==1)
			Toast.makeText(this, "Elemento eliminado", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(this, "Elemento no encontrado", Toast.LENGTH_LONG).show();		
	}
	
	private void Cancelar() {
		finish();
	}
	
	public void BORRAR(View v){
		AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
		confirmar.setTitle("Advertencia");
		confirmar.setMessage("¿Estas seguro de eliminar el registro?");
		confirmar.setCancelable(false);
		confirmar.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Aceptar();
				
			}
			
		});
		confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Cancelar();
				
			}
			
		});
		confirmar.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.baja, menu);
		return true;
	}
}
