package com.unl.unl;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorContacto extends ArrayAdapter<Contacto> {

	private Context contexto;
	private ArrayList<Contacto> datos;
	
	public AdaptadorContacto(Context contexto)
	{
		super(contexto, R.layout.list_item_contacto,((ContactoAplicacion)contexto.getApplicationContext()).listContactos());
		this.contexto=contexto;	
		this.datos=((ContactoAplicacion) contexto.getApplicationContext()).listContactos();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item=convertView;
		ViewHolder holder;
		
		if(item==null)
		{
			LayoutInflater inflater = ((Activity)contexto).getLayoutInflater();
			item=inflater.inflate(R.layout.list_item_contacto, null);
			holder=new ViewHolder();
			holder.nombre=(TextView)item.findViewById(R.id.lblNombre);
			holder.numero=(TextView)item.findViewById(R.id.lbltelefono);
		
			item.setTag(holder);
		}
		else
			holder=(ViewHolder)item.getTag();
		
		
		holder.nombre.setText(datos.get(position).getNombre());
		holder.numero.setText(datos.get(position).getNumero());
		
		
		return item;
	}
}
