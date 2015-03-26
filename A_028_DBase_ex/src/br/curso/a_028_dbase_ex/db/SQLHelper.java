package br.curso.a_028_dbase_ex.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

	public SQLHelper(Context context, String nomeBanco, int versaoBanco) {
		super(context, nomeBanco, null, versaoBanco);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {

			StringBuilder script = new StringBuilder();
			//
			script.append("CREATE TABLE if not exists [contatos] (   [idcontato] BIGINT NOT NULL,   [nome] NVARCHAR(50) NOT NULL,   [telefone] NVARCHAR(20) NOT NULL,   [datanascimento] DATETIME NOT NULL,   CONSTRAINT [] PRIMARY KEY ([idcontato]));");
			//
			String[] scripts = script.toString().split(";");
			//
			for (int i = 0; i < scripts.length; i++) {
				db.execSQL(scripts[i].toLowerCase());
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		StringBuilder script = new StringBuilder();
		//
		script.append("drop table if exists contatos;");
		//
		String[] scripts = script.toString().split(";");
		//
		for (int i = 0; i < scripts.length; i++) {
			db.execSQL(scripts[i].toLowerCase());
		}
	}

}
