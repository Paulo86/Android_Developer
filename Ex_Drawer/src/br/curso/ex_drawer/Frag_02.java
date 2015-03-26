package br.curso.ex_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_02 extends Fragment {

	private Button btn_mudar;
	//private MainActivity host;

	public interface IFrag_02 {
		public void mudarTT(String texto);
	}

	private IFrag_02 mDelegate;

	public void setmDelegate(IFrag_02 mDelegate) {
		this.mDelegate = mDelegate;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.frag_02, container, false);
		//
		btn_mudar = (Button) view.findViewById(R.id.frag_02_btn_mudar);
		//host = (MainActivity) getActivity();
		//
		btn_mudar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(mDelegate != null){
					mDelegate.mudarTT("Hugo");
				}
				
				
				//host.mudar_texto("Hugo");
				//host.fechar_drawer();
			}
		});
		//
		return view;
	}

}
