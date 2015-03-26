package br.curso.a_final.dbase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Dao extends SQLiteOpenHelper {

	private static String DATABASE = "/sdcard/dbpacientes.db3";
	private static int VERSAO = 1;

	public Dao(Context context) {
		super(context, DATABASE, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder comando = new StringBuilder();
		comando.append("CREATE TABLE if not exists [pacientes] (   [codigo] INT NOT NULL,   [nome] NVARCHAR(200) NOT NULL,   [idade] INT NOT NULL,   [sexo] NVARCHAR(2) NOT NULL,   [endereco] NVARCHAR(20) NOT NULL,   CONSTRAINT [] PRIMARY KEY ([codigo]));");
		//
		db.execSQL(comando.toString().toLowerCase());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String comando = "drop table if exists pacientes ";
		//
		db.execSQL(comando);
		onCreate(db);
	}

}
