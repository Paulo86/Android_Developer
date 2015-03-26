package br.curso.a_027_tabs;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class AppleFragment extends ListFragment {

	String[] apple_version = {

	"Mountain Lion", "Lion", "Snow Leopard", "Leopard", "Tiger", "Panther"

	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, apple_version);

		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
