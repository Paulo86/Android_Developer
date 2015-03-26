package br.curso.ex_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Frag_01 extends Fragment {
	
	public interface IFrag_01{
		public void mostramensagem(String mensagem);
	}
	
	public IFrag_01 delegate;
	
	private Button btn_faz_qualquer_coisa;
	
	private String mensagem = "Olá!!! Eu sou o Frag_01";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		// setContentView
		final View view = inflater.inflate(R.layout.frag_01, container, false);
		//
		btn_faz_qualquer_coisa = (Button) view
				.findViewById(R.id.frag_01_btn_faz_qualquer_coisa);
		btn_faz_qualquer_coisa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if ( delegate != null){
					delegate.mostramensagem(mensagem);
				}
				// Toast.makeText(getActivity(), "Olá!!! Eu sou o Frag_01",
				// Toast.LENGTH_SHORT).show();
			}
		});
		//
		return view;
	}
}
