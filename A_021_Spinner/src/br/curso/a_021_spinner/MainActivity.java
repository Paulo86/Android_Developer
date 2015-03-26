package br.curso.a_021_spinner;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	private Spinner sp_valor;
	private ArrayList<String> nomes;
	private ArrayAdapter<String> nomeadapter;

	private Spinner sp_produto;
	private ArrayList<Produto> produtos;
	private ArrayAdapter<Produto> produtoadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telaincial);
		//
		context = getBaseContext();
		//
		// Spinner Educacional
		nomes = new ArrayList<String>();
		nomes.add("<Selecione um Nome>");
		nomes.add("Hugo");
		nomes.add("Pedro");
		nomes.add("Alvaro");
		nomes.add("Maria");
		//
		nomeadapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_spinner_item, nomes);
		nomeadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		sp_valor = (Spinner) findViewById(R.id.sp_valor);
		sp_valor.setAdapter(nomeadapter);
		// sp_valor.setOnItemClickListener(l); Lista
		sp_valor.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				if (position != 0) {

					String st = (String) parent.getItemAtPosition(position);

					Toast.makeText(context, st, Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		}); // Spinner
		//
		sp_valor.setSelection(obterIndiceValor(sp_valor, "Maria"));

		// Spinner Produto
		produtos = new ArrayList<Produto>();
		produtos.add(new Produto(10, "DeskJet 500"));
		produtos.add(new Produto(20, "Laerjet 1200"));
		produtos.add(new Produto(30, "Plotter 500"));
		produtos.add(new Produto(40, "Epson 200lx"));
		//
		produtoadapter = new ArrayAdapter<Produto>(context,
				R.layout.simple_spinner_item, produtos);
		produtoadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		sp_produto = (Spinner) findViewById(R.id.sp_produto);
		sp_produto.setAdapter(produtoadapter);
		//
		sp_produto.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				Produto pAux = (Produto) parent.getItemAtPosition(position);
				//
				Toast.makeText(context, String.valueOf(pAux.getIdproduto()),
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		//
		sp_produto.setSelection(obterIndiceProduto(sp_produto, 30));

	}

	private int obterIndiceValor(Spinner sp, String valor) {
		int index = 0;
		//
		for (int i = 0; i < sp.getCount(); i++) {

			String valorsp = (String) sp.getItemAtPosition(i);
			//
			if (valor.equalsIgnoreCase(valorsp)) {
				index = i;
				break;
			}
		}
		//
		return index;
	}

	private int obterIndiceProduto(Spinner sp, long id) {
		int index = 0;
		//
		for (int i = 0; i < sp.getCount(); i++) {

			Produto pAux = (Produto) sp.getItemAtPosition(i);
			//
			if (pAux.getIdproduto() == id) {
				index = i;
				break;
			}
		}
		//
		return index;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
