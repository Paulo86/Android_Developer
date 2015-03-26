package br.curso.a_028_dbase.vo;

public class Torcedor {

	private int idtorcedor;
	private String nome;
	private String email;
	private String celular;
	private double altura;

	public Torcedor() {
		super();
		//
//		this.idtorcedor = -1;
//		this.nome = "SEM NOME";
//		this.email = "SEM EMAIL";
//		this.celular = "SEM CELULAR";
//		this.altura = -1;

	}

	public Torcedor(int idtorcedor, String nome, String email, String celular,
			double altura) {
		super();
		this.idtorcedor = idtorcedor;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.altura = altura;
	}

	public int getIdtorcedor() {
		return idtorcedor;
	}

	public void setIdtorcedor(int idtorcedor) {
		this.idtorcedor = idtorcedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
