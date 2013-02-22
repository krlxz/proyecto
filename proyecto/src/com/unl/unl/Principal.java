package com.unl.unl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class Principal extends Activity implements OnTouchListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.principal);
	
		ImageView imgsga = (ImageView)findViewById(R.id.imgsga);
		imgsga.setOnTouchListener(this);
		
		ImageView imgeva=(ImageView)findViewById(R.id.imgeva);
		imgeva.setOnTouchListener(this);
		
		ImageView imgcorreo=(ImageView)findViewById(R.id.imgcorreo);
		imgcorreo.setOnTouchListener(this);
		
		ImageView imgcontactos=(ImageView)findViewById(R.id.imgcontactos);
		imgcontactos.setOnTouchListener(this);
	
		ImageView imgcalendario=(ImageView)findViewById(R.id.imgcalendar);
		imgcalendario.setOnTouchListener(this);
	
	ImageView imgnotificaciones=(ImageView)findViewById(R.id.imgnotificacion);
		imgnotificaciones.setOnTouchListener(this);
	
		
	}
	
		
	//método para crear el menu desplegable
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0, 1, Menu.NONE, "Desarrolladores").setIcon(R.drawable.desarrolladores);
		menu.add(0, 2, Menu.NONE, "Ubicación").setIcon(R.drawable.mapa);
		menu.add(0, 3, Menu.NONE, "Acerca de..").setIcon(R.drawable.info);
	return true;
	}
	
	//metodo para detectar el evento en el menu desplegable
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case 1: 
			//creación del intent para llamar a la actividad de desarrolladores.
			Intent d=new Intent(this,com.unl.unl.Desarrolladores.class);
			startActivity(d);			
			return true;
		case 2:
			Intent m=new Intent(this,com.unl.unl.Mapa.class);
			startActivity(m);					
			break;
		case 3:
			Intent a=new Intent(this,com.unl.unl.Acercade.class);
			startActivity(a);			
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(v.getId()==findViewById(R.id.imgsga).getId())
			{
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://estudiantes.unl.edu.ec/"));
				startActivity(intent);	 
			}
			
			if(v.getId()==findViewById(R.id.imgeva).getId())
			{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			 intent.setData(Uri.parse("http://eva.unl.edu.ec/login/index.php"));
			 startActivity(intent);	 
			}
			
			if(v.getId()==findViewById(R.id.imgcorreo).getId())
			{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			 intent.setData(Uri.parse("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2"));
			 startActivity(intent);	 
			}

			if(v.getId()==findViewById(R.id.imgcontactos).getId())
			{
			Intent intent = new Intent(this,com.unl.unl.Contactos.class);
			startActivity(intent);	 
			}
			
			if(v.getId()==findViewById(R.id.imgcalendar).getId())
			{
			Intent intent = new Intent(this,com.unl.unl.AgendaFinalActivity.class);
			startActivity(intent);	 
			}
		
			if(v.getId()==findViewById(R.id.imgnotificacion).getId())
			{
				Intent intent = new Intent(this,com.unl.unl.MainActivityNotificacion.class);
				startActivity(intent);	 
				}
			
			
			return true;
	}
		//método para salir de la aplicación medainte un dialogo
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	     if (keyCode == KeyEvent.KEYCODE_BACK) {
	      new AlertDialog.Builder(this)
	         .setIcon(android.R.drawable.ic_dialog_alert)
	         .setTitle("Salir")
	         .setMessage("Estás seguro que deseas salir de la aplicación")
	         .setNegativeButton(android.R.string.cancel, null)//sin listener
	         .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
	           @Override
	           public void onClick(DialogInterface dialog, int which){
	             //Salir
	           	Principal.this.finish();
	           	}
	         }
	        )
	         .show();
	       // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
	       return true;
	     }
	    //para las demas cosas, se reenvia el evento al listener habitual
	     return super.onKeyDown(keyCode, event);
	   
	    }
}
