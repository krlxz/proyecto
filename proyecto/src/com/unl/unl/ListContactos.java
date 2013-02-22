package com.unl.unl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

public class ListContactos extends Activity {

	ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.layout_list_contactos);
        
        lv=(ListView) findViewById(R.id.lvContactos);
        AdaptadorContacto adaptador=new AdaptadorContacto(this);
        lv.setAdapter(adaptador);
    }
}
