package com.example.cbtis83;
 

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class Buscar extends Activity {
	public EditText etNoB;
	public TextView txtNom,txtEsp,txtsem,txtE,txtPro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		etNoB = (EditText) findViewById(R.id.etNoB);
        txtNom = (TextView) findViewById(R.id.txtNom);
        txtEsp = (TextView) findViewById(R.id.txtEsp);
        txtsem = (TextView) findViewById(R.id.txtsem);
        txtE = (TextView) findViewById(R.id.txtE);
        txtPro = (TextView) findViewById(R.id.txtPro);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar, menu);
		return true;
	}

}
