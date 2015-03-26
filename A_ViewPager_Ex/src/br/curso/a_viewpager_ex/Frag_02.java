package br.curso.a_viewpager_ex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_02 extends Fragment {

	private Button btn_mudartela;

	//
	public interface IF02 {
		public void acionarMudanca(int indice);
	}

	public IF02 delegate;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.frag_02, container, false);
		//
		btn_mudartela = (Button) view.findViewById(R.id.frag_02_btn_mudartela);
		btn_mudartela.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (delegate != null) {
					delegate.acionarMudanca(2);
				}
			}
		});
		//
		return view;
	}

}
