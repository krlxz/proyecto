package com.unl.unl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import android.app.Application;

public class ContactoAplicacion extends Application {

	private static ArrayList<Contacto> contactos;
	
	@Override
	public void onCreate() {
		super.onCreate();
		contactos = new ArrayList<Contacto>();
	
	}

	public boolean addContacto(Contacto contacto)
	{
		try
		{
			contactos.add(contacto);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public ArrayList<Contacto> listContactos()
	{
		return contactos;
	}

}
