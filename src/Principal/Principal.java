package Principal;

import java.util.ArrayList;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);

	// atributos static s�o atributos de classe
	private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();

	// eventualmente outros atributos static

	public static void main(String[] args) {
		// outras variaveis locais
		// menu
		// opcao
		// chamar metodos static que correspondam as opcoes de menu
		int opcao;
		do {
			System.out.println("\n==> Menu\n");
			System.out.println("   0 - sair");
			System.out.println("   1 - cadastrar entrada Carro");
			System.out.println("   2 - efetuar saida do carro");
			System.out.println("   3 - Cadastrar marca");
			System.out.println("   4 - Cadastrar modelo");
			System.out.println("   5 - Mostrar ocupação do estacionamento");
			System.out.println("   6 - Mostrar o relatorio gerencial consoliddado");
			System.out.print("\n   Opcao: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("   Obrigado por usar o sistema!");
				scanner.close();
				break;
			case 1:
				entradaCarro();
				break;
			case 2:
				saidaCarro();
				break;
			case 3:
				// cadastrar a marca
				break;
			case 4:
				// cadastrar o modelo
				break;
			case 5:
				// mostrar ocupação do estacionamento
				break;
			case 6:
				// mostrar o relatorio
				break;

			default:
				System.out.println("   Opcao invalida!");
				break;
			}
		} while (opcao != 0);

	}

	private static void entradaCarro() {
		// criar o carro e cadastra-lo no vetor na posicao correta
		String carro;
		System.out.println("\n==> Entrada do carro\n");
		scanner.nextLine();
		System.out.print("  Carro placa: ");
		carro = scanner.nextLine();
		Carro c1 = new Carro(null, carro, LocalDateTime.now());

	}

	private static float saidaCarro() {
		float preco = 0;
		// logica para calcular preco do estacionamento e coloca-lo no historico
		return preco;
	}

	// outros m�todos static conforme especificacao do trabalho e necessidades de
	// implementacao

	public static void main(String[] args){
		modelos.add(new Modelo("Toyota"));
		modelos.add(new Modelo("Honda"));
		private static void cadastrarmarca() {
			System.out.println("\n==> Cadastro de marca");
			String nome;

			scanner.nextLine();
			System.out.print("   Marca: ");
			nome = scanner.nextLine();


			Modelo modelo = new modelo(nome);
			lista.add(modelo);}
	}
}
