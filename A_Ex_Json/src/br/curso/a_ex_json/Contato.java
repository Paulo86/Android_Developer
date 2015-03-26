package br.curso.a_ex_json;

import org.json.JSONObject;

public class Contato {

	private long idcontato;
	private String nome;
	private String telefone;

	public long getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(long idcontato) {
		this.idcontato = idcontato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public JSONObject toJSONObject() {
		JSONObject jsonObject = new JSONObject();
		//
		try {
			jsonObject.put("idcontato", String.valueOf(getIdcontato()));
			jsonObject.put("nome", getNome());
			jsonObject.put("telefone", getTelefone());
			//
			return jsonObject;

		} catch (Exception e) {
			return null;
		}
	}

}
