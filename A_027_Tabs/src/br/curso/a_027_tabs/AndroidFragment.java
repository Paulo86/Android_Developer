package br.curso.a_027_tabs;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class AndroidFragment extends ListFragment {

	String[] android_version = {

	"Jelly Bean", "Icen Cream Sandwish", "HoneyComb", "Ginger Bread", "Froyo"

	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android_version);

		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
