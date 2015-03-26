package br.curso.a_viewpager_ex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag_01 extends Fragment {
	
	private MainActivity app;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//app = (MainActivity) getActivity();
		//app.fazqualquercoisa();

		final View view = inflater.inflate(R.layout.frag_01, container, false);

		return view;
	}

}
