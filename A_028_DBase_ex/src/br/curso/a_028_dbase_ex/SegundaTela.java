package br.curso.a_028_dbase_ex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.curso.a_028_dbase_ex.dao.ContadoDao;
import br.curso.a_028_dbase_ex.vo.Contato;

public class SegundaTela extends Activity {

	private Context context;

	private EditText et_codigo;
	private EditText et_nome;
	private EditText et_telefone;
	private EditText et_datanascimento;

	private Button btn_excluir;
	private Button btn_cancelar;
	private Button btn_salvar;

	private long idContatoAux;

	private ContadoDao contatoDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segundatela);
		//
		context = getBaseContext();
		contatoDao = new ContadoDao(context);
		//
		idContatoAux = getIntent().getLongExtra(ContadoDao.IDCONTATO, -1);
		//
		et_codigo = (EditText) findViewById(R.id.segundatela_et_codigo);
		et_nome = (EditText) findViewById(R.id.segundatela_et_nome);
		et_telefone = (EditText) findViewById(R.id.segundatela_et_telefone);
		et_datanascimento = (EditText) findViewById(R.id.segundatela_et_datanascimento);
		//
		btn_excluir = (Button) findViewById(R.id.segundatela_btn_excluir);
		btn_cancelar = (Button) findViewById(R.id.segundatela_btn_cancelar);
		btn_salvar = (Button) findViewById(R.id.segundatela_btn_salvar);
		//
		if (idContatoAux != -1) {
			Contato contato = contatoDao.obterContatoById(idContatoAux);
			//
			et_codigo.setText(String.valueOf(contato.getIdcontato()));
			et_nome.setText(contato.getNome());
			et_telefone.setText(contato.getTelefone());
			et_datanascimento.setText(contato.getDatanascimento());
			//
			btn_excluir.setVisibility(View.VISIBLE);
		} else {
			btn_excluir.setVisibility(View.GONE);
		}
		//
		btn_cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		//
		btn_excluir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				contatoDao.apagarContato(idContatoAux);
				//
				onBackPressed();
			}
		});
		//
		btn_salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Contato contato = new Contato();
				//
				contato.setNome(et_nome.getText().toString());
				contato.setTelefone(et_telefone.getText().toString());
				contato.setDatanascimento(et_datanascimento.getText()
						.toString());
				//
				if (idContatoAux == -1) {
					idContatoAux = contatoDao.proximoIdContato();
					contato.setIdcontato(idContatoAux);
				} else {
					contato.setIdcontato(idContatoAux);
				}
				//
				contatoDao.inserirAtualizarContato(contato);
				//
				et_codigo.setText(String.valueOf(idContatoAux));
				btn_excluir.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public void onBackPressed() {
		Intent mIntent = new Intent(context, MainActivity.class);
		startActivity(mIntent);
		//
		super.onBackPressed();
	}

}
