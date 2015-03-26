package br.curso.a_final.dao;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.curso.a_final.dbase.Dao;
import br.curso.a_final.vo.Paciente;

public class PacienteDao extends Dao {

	public PacienteDao(Context context) {
		super(context);
	}

	public void insList(ArrayList<Paciente> pacientes) {
		getWritableDatabase().delete("pacientes", null, null);
		//
		ContentValues cv = new ContentValues();
		//
		for (Paciente paciente : pacientes) {
			cv.clear();
			//
			cv.put("codigo", paciente.getCodigo());
			cv.put("nome", paciente.getNome());
			cv.put("idade", paciente.getIdade());
			cv.put("sexo", paciente.getSexo());
			cv.put("endereco", paciente.getEndereco());
			//
			getWritableDatabase().insert("pacientes", null, cv);
		}
	}

	public ArrayList<HashMap<String, String>> getAllPaciente() {
		ArrayList<HashMap<String, String>> pacientes = new ArrayList<HashMap<String, String>>();
		//
		Cursor cursor = null;
		//
		try {

			cursor = getWritableDatabase().rawQuery(
					"select codigo, nome from pacientes order by nome", null);
			//
			while (cursor.moveToNext()) {
				HashMap<String, String> item = new HashMap<String, String>();
				//
				item.put("codigo", String.valueOf(cursor.getInt(cursor
						.getColumnIndex("codigo"))));
				item.put("nome",
						cursor.getString(cursor.getColumnIndex("nome")));
				//
				pacientes.add(item);
			}

		} catch (Exception e) {
			@SuppressWarnings("unused")
			String res = e.toString();
		}
		
		
		//
		return pacientes;
	}

}
