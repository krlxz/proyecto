package com.unl.unl;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {

	protected boolean active = true;
	 protected int splashTime = 1000;
	  
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE); 
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.splash);
	        
	        Thread splashThread = new Thread(){
	         @Override
	         public void run(){
	          try{
	           int waited = 0;
	           while(active && (waited < splashTime)){
	            sleep(200);
	            if(active){
	             waited += 50;
	            }
	            
	           }
	          } catch(InterruptedException e){
	           
	          } finally{
	           openApp();
	           stop();
	          }
	          
	         }
	        };
	        splashThread.start();
	    }
	    private void openApp(){
	     finish();
	        startActivity(new Intent(this,Login.class));
	    }
}
