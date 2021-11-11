package Principal;

import java.util.ArrayList;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {
	
	// atributos static são atributos de classe
	private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	
	// eventualmente outros atributos static
	
	public static void main(String[] args) {
		// outras variaveis locais
		// menu
		// opcao
		// chamar metodos static que correspondam as opcoes de menu
	}
	
	private static void entradaCarro() {
		// criar o carro e cadastra-lo no vetor na posicao correta
	}
	
	private static float saidaCarro() {
		float preco = 0;
		// logica para calcular preco do estacionamento e coloca-lo no historico
		return preco;
	}
	
	// outros m�todos static conforme especificacao do trabalho e necessidades de implementacao
}
