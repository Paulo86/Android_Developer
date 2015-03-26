package br.curso.lab_021_contato;

public class Contato {

	private long idcontato;
	private String nome;
	private String telefone;

	public Contato() {
		super();
		//
		this.idcontato = -1;
		this.nome = "Sem nome";
		this.telefone = "Sem telefone";
	}

	public Contato(long idcontato, String nome, String telefone) {
		super();
		this.idcontato = idcontato;
		this.nome = nome;
		this.telefone = telefone;
	}

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

	@Override
	public String toString() {
		return this.nome + " - " + this.telefone;
	}

}
