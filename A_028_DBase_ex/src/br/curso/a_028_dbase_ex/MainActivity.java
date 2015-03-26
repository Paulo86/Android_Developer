package br.curso.a_028_dbase_ex;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.curso.a_028_dbase_ex.dao.ContadoDao;

public class MainActivity extends Activity {

	private Context context;
	private ListView lv_contatos;

	private SimpleAdapter adapter;
	private ContadoDao contatoDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		contatoDao = new ContadoDao(context);
		//
		lv_contatos = (ListView) findViewById(R.id.telainicial_lv_contatos);
		String[] from = { ContadoDao.NOMECONTATO, ContadoDao.TELEFONECONTATO };
		int[] to = { R.id.row_tv_nome, R.id.row_tv_telefone };
		adapter = new SimpleAdapter(context, contatoDao.listaContatos_HM(),
				R.layout.row, from, to);
		lv_contatos.setAdapter(adapter);
		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				HashMap<String, String> item = (HashMap<String, String>) parent
						.getItemAtPosition(position);

				Intent mIntent = new Intent(context, SegundaTela.class);
				mIntent.putExtra(ContadoDao.IDCONTATO,
						Long.parseLong(item.get(ContadoDao.IDCONTATO)));
				//
				startActivity(mIntent);
				//
				finish();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_novo_contato:

			Intent mIntent = new Intent(context, SegundaTela.class);
			mIntent.putExtra(ContadoDao.IDCONTATO, -1);
			//
			startActivity(mIntent);
			//
			finish();

			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

}
