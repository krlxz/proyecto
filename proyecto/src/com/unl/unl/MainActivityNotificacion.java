package com.unl.unl;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivityNotificacion extends Activity implements OnClickListener{

	Button notificacion;
	NotificationManager nm;
	static final int unico = 001;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notificacion);
		
		notificacion=(Button) findViewById(R.id.notificaciones);
		nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(unico);
		notificacion.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		
		Intent i= new Intent (this,MainActivityNotificacion.class);
		PendingIntent pi= PendingIntent.getActivity(this, 0, i, 0);
		int contador=0;
		String cuerpo="Notificación";
		String titulo="Prueba";
		contador=contador+1;
		Notification n = new Notification(R.drawable.ic_launcher, cuerpo, System.currentTimeMillis());
		n.setLatestEventInfo(this, titulo, cuerpo+contador, pi);
		n.defaults=Notification.DEFAULT_ALL;
		nm.notify(unico, n);
		finish();
		
	}

	

}
