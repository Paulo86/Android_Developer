package br.curso.a_028_dbase_ex.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

	private Context context;
	protected SQLiteDatabase db;

	public Dao(Context context) {
		this.context = context;
	}

	public void abrirBanco() {
		SQLHelper SQLHelper_var = new SQLHelper(context, Constantes.BANCO_NOME,
				Constantes.BANCO_VERSAO);
		//
		this.db = SQLHelper_var.getWritableDatabase();
	}

	public void fecharBanco() {
		if (this.db != null) {
			this.db.close();
		}
	}

}
