package br.curso.a_028_dbase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.curso.a_028_dbase.vo.Torcedor;

public class TorcedorDao extends SQLiteOpenHelper {

	public static final String DATABASE = "/sdcard/DBase/copa.db3";
	public static final int VERSAO = 1;
	public static final String TABELA = "torcedores";
	public static final String FILTRO = "idtorcedor = ?";
	public static final String[] COLUNAS = {

	"idtorcedor", "nome", "email", "celular", "altura"

	};

	public TorcedorDao(Context context) {
		super(context, DATABASE, null, VERSAO);
	}

	public void ins(Torcedor torcedor) {
		ContentValues cv = new ContentValues();
		//
		cv.put("idtorcedor", torcedor.getIdtorcedor());
		cv.put("nome", torcedor.getNome());
		cv.put("email", torcedor.getEmail());
		cv.put("celular", torcedor.getCelular());
		cv.put("altura", torcedor.getAltura());
		//

		getWritableDatabase().insert(TABELA, null, cv);
	}

	public void upd(Torcedor torcedor) {
		String[] argumentos = new String[] { String.valueOf(torcedor
				.getIdtorcedor()) };

		ContentValues cv = new ContentValues();
		//
		// cv.put("idtorcedor", torcedor.getIdtorcedor());
		cv.put("nome", torcedor.getNome());
		cv.put("email", torcedor.getEmail());
		cv.put("celular", torcedor.getCelular());
		cv.put("altura", torcedor.getAltura());
		//
		getWritableDatabase().update(TABELA, cv, FILTRO, argumentos);

	}

	public void del(int idtorcedor) {
		String[] argumentos = new String[] { String.valueOf(idtorcedor) };
		//
		getWritableDatabase().delete(TABELA, FILTRO, argumentos);
	}

	public Torcedor obterTorcedor(int idtorcedor) {
		Torcedor torcedor = new Torcedor();
		torcedor.setIdtorcedor(-1);
		torcedor.setNome("Sem Nome");
		//
		Cursor cursor = null;
		//
		String[] argumentos = new String[] { String.valueOf(idtorcedor) };

		try {

			cursor = getReadableDatabase().query(TABELA, COLUNAS, FILTRO,
					argumentos, null, null, null);
			
			while(cursor.moveToNext()){
				torcedor.setIdtorcedor(cursor.getInt(cursor.getColumnIndex("idtorcedor")));
				torcedor.setNome(cursor.getString(cursor.getColumnIndex("nome")));
				torcedor.setEmail(cursor.getString(cursor.getColumnIndex("email")));
				torcedor.setCelular(cursor.getString(cursor.getColumnIndex("celular")));
				torcedor.setAltura(cursor.getDouble(cursor.getColumnIndex("altura")));
			}
			
			cursor = null;

		} catch (Exception e) {
		}
		//
		return torcedor;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE if not exists [torcedores] (   [idtorcedor] INT NOT NULL,   [nome] NVARCHAR(100) NOT NULL,   [email] NVARCHAR NOT NULL,   [celular] NVARCHAR NOT NULL,   [altura] REAL NOT NULL,   CONSTRAINT [] PRIMARY KEY ([idtorcedor]));");
		//
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists torcedores;");
		//
		onCreate(db);
	}

}
