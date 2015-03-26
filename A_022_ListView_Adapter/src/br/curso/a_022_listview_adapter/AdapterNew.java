package br.curso.a_022_listview_adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterNew extends BaseAdapter {

	private LayoutInflater mInflate;
	private ArrayList<Heroi> herois;

	public AdapterNew(Context context, ArrayList<Heroi> herois) {
		super();
		this.mInflate = LayoutInflater.from(context);
		// this.mInflate = (LayoutInflater)
		// context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.herois = herois;
	}

	@Override
	public int getCount() {
		return herois.size();
	}

	@Override
	public Object getItem(int position) {
		return herois.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = mInflate.inflate(R.layout.celula, null);
		}

		Heroi hAux = herois.get(position);

		ImageView iv_foto = (ImageView) convertView
				.findViewById(R.id.celula_iv_foto);
		TextView tv_nome = (TextView) convertView
				.findViewById(R.id.celula_tv_nome);

		iv_foto.setImageResource(hAux.getImagem());
		tv_nome.setText(hAux.getNome());

		return convertView;
	}

}

