package br.curso.ex_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag_01 extends Fragment{
	
	private TextView tv_valor;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		final View view = inflater.inflate(R.layout.frag_01, container, false);
		
		tv_valor = (TextView) view.findViewById(R.id.frag_01_tv_texto);
		
		return view;
	}
	
	public void mudar_Texto(String texto){
		tv_valor.setText(texto);
	}

}
