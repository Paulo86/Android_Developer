package br.curso.a_022_listview_adapter;

public class Heroi {

	private String nome;
	private int imagem;
	private String poder;

	public Heroi() {
		super();
	}

	public Heroi(String nome, int imagem, String poder) {
		super();
		this.nome = nome;
		this.imagem = imagem;
		this.poder = poder;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getImagem() {
		return imagem;
	}

	public void setImagem(int imagem) {
		this.imagem = imagem;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

}
