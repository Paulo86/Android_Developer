package br.curso.a_028_dbase_ex.dao;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.curso.a_028_dbase_ex.db.Dao;
import br.curso.a_028_dbase_ex.vo.Contato;

public class ContadoDao extends Dao {

	public static final String TABELA = "contatos";
	public static final String IDCONTATO = "idcontato";
	public static final String NOMECONTATO = "nome";
	public static final String TELEFONECONTATO = "telefone";
	public static final String DATANASCIMENTOCONTATO = "datanascimento";

	public ContadoDao(Context context) {
		super(context);
	}

	public ArrayList<HashMap<String, String>> listaContatos_HM() {
		ArrayList<HashMap<String, String>> contatos = new ArrayList<HashMap<String, String>>();
		//
		abrirBanco();
		//
		StringBuilder sb = new StringBuilder();
		sb.append(" select idcontato, nome, telefone from contatos order by nome");
		//
		Cursor cursor = db.rawQuery(sb.toString().toLowerCase(), null);
		//
		while (cursor.moveToNext()) {
			HashMap<String, String> row = new HashMap<String, String>();
			//
			row.put(IDCONTATO, String.valueOf(cursor.getLong(cursor
					.getColumnIndex(IDCONTATO))));
			row.put(NOMECONTATO,
					cursor.getString(cursor.getColumnIndex(NOMECONTATO)));
			row.put(TELEFONECONTATO,
					cursor.getString(cursor.getColumnIndex(TELEFONECONTATO)));
			//
			contatos.add(row);
		}
		//
		cursor = null;
		//
		fecharBanco();
		//
		return contatos;
	}

	public void inserirAtualizarContato(Contato contato) {
		abrirBanco();
		//
		ContentValues cv = new ContentValues();
		cv.put(IDCONTATO, contato.getIdcontato());
		cv.put(NOMECONTATO, contato.getNome());
		cv.put(TELEFONECONTATO, contato.getTelefone());
		cv.put(DATANASCIMENTOCONTATO, contato.getDatanascimento());
		//
		if (db.insert(TABELA, null, cv) == -1) {
			StringBuilder sbWhere = new StringBuilder();
			sbWhere.append(IDCONTATO).append(" = '")
					.append(contato.getIdcontato()).append("' ");
			db.update(TABELA, cv, sbWhere.toString().toLowerCase(), null);
		}
		//
		fecharBanco();
	}

	public long proximoIdContato() {
		long proximoID = 0;
		//
		abrirBanco();
		//
		StringBuilder sb = new StringBuilder();
		sb.append("select max(idcontato)+1 as id from contatos");
		//
		Cursor cursor = db.rawQuery(sb.toString().toLowerCase(), null);
		//
		while (cursor.moveToNext()) {
			proximoID = cursor.getLong(cursor.getColumnIndex("id"));
		}
		//
		if (proximoID == 0) {
			proximoID = 1;
		}
		//
		fecharBanco();
		//
		return proximoID;
	}

	public void apagarContato(long idcontato) {
		abrirBanco();
		//
		StringBuilder sbWhere = new StringBuilder();
		sbWhere.append(IDCONTATO).append(" = '").append(idcontato).append("' ");
		db.delete(TABELA, sbWhere.toString().toLowerCase(), null);
		//
		fecharBanco();
	}

	public Contato obterContatoById(long idcontato) {
		Contato contato = null;
		//
		abrirBanco();
		//
		StringBuilder sbWhere = new StringBuilder();
		sbWhere.append("select * from contatos where ").append(IDCONTATO)
				.append(" = '").append(idcontato).append("' ");
		//
		Cursor cursor = db.rawQuery(sbWhere.toString().toLowerCase(), null);
		//
		while (cursor.moveToNext()) {
			contato = new Contato();
			//
			contato.setIdcontato(cursor.getLong(cursor
					.getColumnIndex(IDCONTATO)));
			contato.setNome(cursor.getString(cursor.getColumnIndex(NOMECONTATO)));
			contato.setTelefone(cursor.getString(cursor
					.getColumnIndex(TELEFONECONTATO)));
			contato.setDatanascimento(cursor.getString(cursor
					.getColumnIndex(DATANASCIMENTOCONTATO)));
		}
		//
		fecharBanco();
		//
		return contato;
	}
}
