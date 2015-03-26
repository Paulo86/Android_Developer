package br.curso.a_ex_json;

import java.util.ArrayList;

public class Servico {
	private String id_os;
	private String valorpedido;
	private ArrayList<Ocorrencia> ocorrencias;

	public String getId_os() {
		return id_os;
	}

	public void setId_os(String id_os) {
		this.id_os = id_os;
	}

	public String getValorpedido() {
		return valorpedido;
	}

	public void setValorpedido(String valorpedido) {
		this.valorpedido = valorpedido;
	}

	public ArrayList<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(ArrayList<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

}
