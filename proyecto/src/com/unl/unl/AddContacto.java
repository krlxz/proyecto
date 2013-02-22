package com.unl.unl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContacto extends Activity {

	Button btGuardar, btCancelar;
	EditText tbNombre, tbTelefono;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_contacto);
        
        tbNombre=(EditText) findViewById(R.id.tbNombre);
        tbTelefono=(EditText) findViewById(R.id.tbTelefono);
   
        
        btGuardar=(Button) findViewById(R.id.btGuardar);
        btGuardar.setOnClickListener(new OnClickListener() {		
			@Override
		
			public void onClick(View v) {
				Contacto c = new Contacto(tbNombre.getText().toString(), tbTelefono.getText().toString());
				ContactoAplicacion contacto = new ContactoAplicacion();
				contacto.addContacto(c);
				//Toast.makeText(this, "Guardado con exito", Toast.LENGTH_LONG).show();
				finish();
				
			}
		});
        
        btCancelar=(Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    
    }
}
