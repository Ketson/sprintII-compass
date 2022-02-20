package br.com.compass.questao9;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	private double desconto;
	private String data_inicio;
	
	public Produto(Integer id, String nome, String descricao, double desconto, String data_inicio) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.data_inicio = data_inicio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	@Override
	public String toString() {
		return String.format("Produto: %d\t, %s\t, %s\t, %d\t, %s\t", this.id, this.nome, this.descricao, this.desconto, this.data_inicio);
	}
}
