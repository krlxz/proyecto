package com.unl.unl;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.Editable;
import android.text.GetChars;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login);
	
		View btnlogin= findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(this);    
		}

	@Override
	public void onClick(View vista) {
		//determina si hay acceso a internet y abre la agenda en caso de que haya intenet
		if (exiteConexionInternet()){
			
			EditText correo = (EditText)findViewById(R.id.txtemail);
			String correoo = correo.getText().toString();
			correoo = correoo.replaceAll(" ","");
			correoo = correoo+"@unl.edu.ec";
	        
			
			EditText password = (EditText)findViewById(R.id.txtcontrasenia);	
			String passwordd = password.getText().toString();
			
			
			if(vista.getId()==findViewById(R.id.btnlogin).getId())
		     {
				if (correoo.equals("")&&passwordd.equals("")){
					Toast.makeText(Login.this, "Llena los campos obligatorios", Toast.LENGTH_LONG).show();
					}else{
								
	       		HttpClient client = new DefaultHttpClient();
	       		HttpPost post = new HttpPost("https://www.google.com/accounts/ClientLogin");
	       		try {
	       			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	       			nameValuePairs.add(new BasicNameValuePair("Email",correoo));
	       			//nameValuePairs.add(new BasicNameValuePair("Email","casalasm@unl.edu.ec"));
	       			nameValuePairs
	       			.add(new BasicNameValuePair("Passwd",passwordd));
	       			//.add(new BasicNameValuePair("Passwd","1105025546cs"));
	       			nameValuePairs.add(new BasicNameValuePair("accountType", "GOOGLE"));
	       			nameValuePairs.add(new BasicNameValuePair("source","Google-cURL-Example"));
	       			nameValuePairs.add(new BasicNameValuePair("service", "ac2dm"));

	       			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	       			HttpResponse response = client.execute(post);
	       			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	       			String line = "";
	       			while ((line = rd.readLine()) != null) {
	       				System.out.println(line);
	       				if (line.startsWith("Auth=")) {
	       					String key = line.substring(5);
	       					Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_LONG).show();
	       					
	       					Login.this.finish();
	       					Intent i = new Intent(this,Principal.class);
	       					startActivity(i);
	       					
	       				}
	       				if(line.startsWith("Error=")){
	       					String key = line.substring(1);
	       					new AlertDialog.Builder(this)
	       			        .setIcon(android.R.drawable.ic_dialog_alert)
	       			        .setTitle("Error")
	       			        .setMessage("El correo institucional o la contraseña introducidos son correctos")		
	       			        .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener()
	       			        {
	       				           @Override
	       				           public void onClick(DialogInterface dialog, int which){
	       				           	}
	       			       		}
	       				    )
	       				    .show();       			           					
	       		
	       				}
	       				
	       			}
	       			
	       		} catch (IOException e) {
	       			e.printStackTrace();
	       				}
					}
		     }									
			}else{
					Toast.makeText(Login.this, "Necesitas conexión a internet para abrir tu agenda", Toast.LENGTH_LONG).show();
		}
	}
	
		public boolean exiteConexionInternet() {
			   ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			   NetworkInfo netInfo = cm.getActiveNetworkInfo();
			   if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			      return true;
			   }
			   return false;
			}
		
	

}
