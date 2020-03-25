package com.example.cbtis83;
 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
 
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
 

public class Opciones extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opciones);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_op, menu);
		return true; 
	}
 
	 public boolean onMenuItemSelected(int f, MenuItem item){
		switch(item.getItemId()){
		
		case R.id.op1:
			Intent i= new Intent(this, Alta.class);
	    	startActivity(i);	 
			return true;
			
		case R.id.op2:
			Intent a= new Intent(this, Baja.class);
	    	startActivity(a);
			return true;	
		
		case R.id.op3:
			Intent e= new Intent(this, Editar.class);
	    	startActivity(e);
			return true;
		
		case R.id.op4:
			Intent b= new Intent(this, Buscar.class);
	    	startActivity(b); 
		}
    	return false;
    	
    } 
	
	public void Alta(View v){
    	Intent i= new Intent(this, Alta.class);
    	startActivity(i);
    }
	
	public void Baja(View v){
    	Intent a= new Intent(this, Baja.class);
    	startActivity(a);
    }
	
	public void Editar(View v){
    	Intent e= new Intent(this, Editar.class);
    	startActivity(e);
    }
	public void Buscar(View v){
    	Intent b= new Intent(this, Buscar.class);
    	startActivity(b);
    }
}
