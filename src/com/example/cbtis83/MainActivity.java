package com.example.cbtis83;
 import android.os.Bundle;
import android.app.Activity;
import android.content.Intent; 
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Abrir(View v){
    	Intent i= new Intent(this, Opciones.class);
    	startActivity(i);
    }
    
}
