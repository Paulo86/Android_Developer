package br.curso;

public class Produto {

	private long idproduto;
	private String nome;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(long idproduto, String nome) {
		super();
		this.idproduto = idproduto;
		this.nome = nome;
	}

	public long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(long idproduto) {
		this.idproduto = idproduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
