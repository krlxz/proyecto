package com.unl.unl;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Contactos extends Activity {

	Button btAnadircontacto,btListarContacto;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        setContentView(R.layout.contactos);
        
//    	
        btAnadircontacto=(Button) findViewById(R.id.btAnadirContacto);
        btAnadircontacto.setOnClickListener(new OnClickListener() {	
			@Override
		
			public void onClick(View v) {
				
				Intent i= new Intent(getApplicationContext() ,AddContacto.class);
				startActivity(i);
			}
		});
        
        btListarContacto=(Button) findViewById(R.id.btListarContacto);
        btListarContacto.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent i= new Intent(getApplicationContext(), ListContactos.class);
				startActivity(i);
			}
		});
    }
    
}
