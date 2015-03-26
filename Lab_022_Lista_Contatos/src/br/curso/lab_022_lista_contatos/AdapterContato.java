package br.curso.lab_022_lista_contatos;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterContato extends BaseAdapter {

	private ArrayList<HashMap<String, String>> contatos;
	private LayoutInflater mInflate;
	private int idlayout;

	public AdapterContato(Context context,
			ArrayList<HashMap<String, String>> contatos) {
		super();
		//
		this.contatos = contatos;
		this.mInflate = LayoutInflater.from(context);
		this.idlayout = R.layout.celula;
	}

	public AdapterContato(Context context, int resource,
			ArrayList<HashMap<String, String>> contatos) {
		super();
		//
		this.contatos = contatos;
		this.mInflate = LayoutInflater.from(context);
		this.idlayout = resource;
	}

	@Override
	public int getCount() {
		return contatos.size();
	}

	@Override
	public Object getItem(int position) {
		return contatos.get(position);
	}

	@Override
	public long getItemId(int position) {
		HashMap<String, String> item = contatos.get(position);
		//
		return Long.parseLong(item.get(Constantes.ID));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Verificando a possibilidade de reutilizacao da celula
		if (convertView == null) {
			convertView = mInflate.inflate(idlayout, null);
		}

		// Resgatando o registro do ArrayList na posicao passada
		HashMap<String, String> item = contatos.get(position);

		// Criar as variaveis e ligar a tela atraves findviewbyid

		TextView tv_nome = (TextView) convertView
				.findViewById(R.id.celula_tv_nome);
		TextView tv_telefone = (TextView) convertView
				.findViewById(R.id.celula_tv_telefone);

		tv_nome.setText(item.get(Constantes.NOME));
		tv_telefone.setText(item.get(Constantes.TELEFONE));

		return convertView;
	}

}
