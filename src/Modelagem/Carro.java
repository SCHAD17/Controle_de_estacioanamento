package Modelagem;

import java.util.ArrayList;

public class Marca {

	private String nome;
	private ArrayList<Modelo> modelos;

	public Marca(String nome) {
		this.nome = nome;
		modelos = new ArrayList<Modelo>();
	}

	public Marca(String nome, ArrayList<Modelo> modelos) {
		this.nome = nome;
		this.modelos = modelos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}

	public void addModelo(String string) {
		modelos.add(new Modelo(string));

	}

	public int getSizeModelo() {
		return modelos.size();
	}

	public Modelo getNomeModelo(int j) {
		return modelos.get(j);

	}

	@Override
	public String toString() {
		return nome;
	}
}
