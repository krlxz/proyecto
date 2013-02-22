package com.unl.unl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Desarrolladores extends Activity implements OnTouchListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.desarrolladores);
		
		ImageView bc = (ImageView)findViewById(R.id.imgcarlos);
		bc.setOnTouchListener(this);
		
		ImageView be = (ImageView)findViewById(R.id.imgedgar);
		be.setOnTouchListener(this);
		
		ImageView bf = (ImageView)findViewById(R.id.imgfreddy);
		bf.setOnTouchListener(this);
		
		ImageView bj = (ImageView)findViewById(R.id.imgjorge);
		bj.setOnTouchListener(this);
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(v.getId()==findViewById(R.id.imgcarlos).getId())
        {
			Intent intent = new Intent(this,com.unl.unl.Biografiac.class);
			 startActivity(intent);
        }
		
		if(v.getId()==findViewById(R.id.imgedgar).getId())
        {
			Intent intent = new Intent(this,com.unl.unl.Biografiae.class);
			 startActivity(intent);
        }
		
		if(v.getId()==findViewById(R.id.imgfreddy).getId())
        {
			Intent intent = new Intent(this,com.unl.unl.Biografiaf.class);
			 startActivity(intent);
        }
		
		if(v.getId()==findViewById(R.id.imgjorge).getId())
        {
			Intent intent = new Intent(this,com.unl.unl.Biografiaj.class);
			 startActivity(intent);
        }
		
		return false;
	}
	
}
