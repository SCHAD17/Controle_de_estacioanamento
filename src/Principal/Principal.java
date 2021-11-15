package Principal;

import java.util.ArrayList;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Principal {

	// atributos static s�o atributos de classe
	private static Carro[] vagas = new Carro[100]; // o estacionamento tem 100 vagas numeradas de 0..99
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	// private ArrayList<Modelo> modelos = new ArrayList<Modelo>();
	// eventualmente outros atributos static

	public static void main(String[] args) {
		// outras variaveis locais
		// menu
		// opcao
		// chamar metodos static que correspondam as opcoes de menu

		marcas.add(new Marca("FIAT"));
		marcas.add(new Marca("FERRARI"));
		marcas.add(new Marca("PORSCHE"));
		marcas.add(new Marca("LAMBORGHINI"));
		marcas.add(new Marca("BMW"));
		marcas.add(new Marca("MERCEDES"));
		marcas.get(0).addModelo("MAREA");
		marcas.get(0).addModelo("UNO");

		Menu();

	}

	private static void Menu() {
		int menu = 6;
		while (menu > 5) {

			System.out.println("Controle Estacionamento");
			System.out.println("1)REGISTRAR ENTRADA CARRO");
			System.out.println("2)REGISTRAR SAIDA CARRO");
			System.out.println("3)CADASTRO MARCAS E MODELOS");
			System.out.println("4)OCUPAÇAO ESTACIONAMENTO");
			System.out.println("5)RELATORIO GERENCIAL");

			System.out.println("Escolha uma opçao:");
			Scanner scanner = new Scanner(System.in);
			menu = scanner.nextInt();
		}

		switch (menu) {
		case 1:
			entradaCarro();
			break;
		case 2:
			saidaCarro();
			break;
		case 3:
			cadastroMarca();
			break;
		case 4:
			ocupacao();
			break;
		case 5:
			relatorio();
			break;
		default:
			Menu();
		}
	}

	private static void entradaCarro() {
		// criar o carro e cadastra-lo no vetor na posicao correta
		System.out.println("Escolha a marca do carro:");

		int i = 0;
		int menu = 0;
		int num = 0;
		int j = 0;
		int menu1 = 0;
		int k = 0;
		int m = 0;

		String string = new String();
		String confirma = new String();
		String placa = new String();
		Modelo modelo = new Modelo(string);
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		Carro carro = new Carro(modelo, placa, agora);

		while (i < marcas.size()) {
			num = i + 1;
			System.out.println(num + ")" + marcas.get(i));
			i++;
		}
		if (i == marcas.size()) {
			num = i + 1;
			System.out.println(num + ")NOVA MARCA");
		}

		System.out.println("Escolha uma opçao:");
		Scanner scanner = new Scanner(System.in);
		menu = scanner.nextInt();

		if (menu <= marcas.size()) {
			while (j < marcas.get(menu - 1).getSizeModelo()) {
				num = j + 1;
				System.out.println(num + ")" + marcas.get(menu - 1).getNomeModelo(j));
				j++;
			}
			if (j >= marcas.get(menu - 1).getSizeModelo()) {
				num = j + 1;
				System.out.println(num + ")NOVO MODELO");
			}
		}
		if (menu > marcas.size())
			cadastroMarca();
		// if (menu > marcas.size())
		// entradaCarro();

		System.out.println("Escolha uma opçao:");
		menu1 = scanner.nextInt();

		if (menu1 <= marcas.get(menu - 1).getSizeModelo()) {
			// System.out.println("O modelo do carro é:" + marcas.get(menu-1) +" "+
			// marcas.get(menu-1).getNomeModelo(menu1-1));
			// System.out.println("Confirma? (S/N)");
			// confirma = scanner.nextLine();
			// if (confirma == "S")
			carro.setModelo(marcas.get(menu - 1).getNomeModelo(menu1 - 1));
			// else
			// entradaCarro();
		}
		if (menu1 > marcas.get(menu - 1).getSizeModelo())
			cadastroMarca();

		// if (menu1 marcas.size())
		// entradaCarro();

		System.out.println("Digite a placa do carro:");
		placa = scanner.next();
		carro.setPlaca(placa);
		String hojeFormatado = agora.format(formatado);
		// carro.setEntrada(hojeFormatado);
		carro.setEntrada(agora);
		carro.setEntradaFormatado(hojeFormatado);

		System.out.println("O carro que dará entrada é");
		System.out.println(marcas.get(menu - 1) + " " + carro.getModelo());
		System.out.println("Placa: " + carro.getPlaca());
		System.out.println("Horário de Entrada: " + carro.getEntradaFormatado());
		// System.out.println("Confirma? (S/N)");
		// confirma = scanner.next();

		while (vagas[k] != null)
			k++;
		if (vagas[k] == null) {
			m = k + 1;
			vagas[k] = carro;
			System.out.println("O carro está parado na vaga de número: " + m);
		} else
			System.out.println("O estacionamento está sem vagas!");

		Menu();

	}

	private static float saidaCarro() {
		float preco = 0;
		int menu = 0;
		// logica para calcular preco do estacionamento e coloca-lo no historico
		System.out.println("Selecione uma opção");
		System.out.println("1)Selecionar a partir da lista de vagas");
		// System.out.println("2)Digitar Placa");
		System.out.println("2)Voltar Menu Principal");
		Scanner scanner = new Scanner(System.in);
		menu = scanner.nextInt();
		LocalDateTime agora = LocalDateTime.now();
		String placa = new String();
		String string = new String();
		Modelo modelo = new Modelo(string);
		Carro carro = new Carro(modelo, placa, agora);
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String entradaFormatado = carro.getEntrada().format(formatado);

		switch (menu) {
		case 1: {
			int i = 0;
			int selecao = 0;

			for (i = 0; i < 100; i++) {
				System.out.println((i + 1) + ")" + vagas[i]);
			}
			System.out.println("Digite a vaga que deseja selecionar:");
			selecao = scanner.nextInt() - 1;
			// placa = vagas[selecao].getPlaca();
			int precobase = 10;
			int preco15min = 2;
			long minutosdiv = 0;
			long precodiv = 0;
			int menu1 = 0;

			if (vagas[selecao] == null) {
				System.out.println("Digite a vaga que deseja selecionar:");
				selecao = scanner.nextInt() - 1;
			}

			else
				vagas[selecao] = carro;

			carro.setSaida(LocalDateTime.now());
			String saidaFormatado = carro.getSaida().format(formatado);
			LocalDateTime from = carro.getEntrada();
			LocalDateTime to = carro.getSaida();
			LocalDate entradaData = carro.formatEntradaLocalDate(carro.getEntrada());
			Duration duration = Duration.between(from, to);
			System.out.println("Tempo no estacionamento: " + duration.toMinutes() + " minutos");

			if (duration.toMinutes() <= 60) {
				preco = precobase;
			}
			if (duration.toMinutes() > 60) {
				minutosdiv = duration.toMinutes() - 60;
				precodiv = minutosdiv / 15;
				preco = precobase + precodiv * preco15min;
			}
			System.out.println("O preço final é: " + preco + " reais");
			System.out.println("Deseja realizar saida?");
			System.out.println("Escolha uma opção:");
			System.out.println("1)Sim");
			System.out.println("2)Não");
			menu1 = scanner.nextInt();
			Carro carrohistorico = new Carro(modelo, placa, preco, saidaFormatado, entradaFormatado, entradaData);
			switch (menu1) {
			case 1: {

				carrohistorico.setPlaca(placa);
				carrohistorico.setModelo(modelo);
				// carrohistorico.setEntrada(carro.getEntrada());
				carrohistorico.setValor(preco);
				carrohistorico.setEntradaFormatado(carro.getEntrada().format(formatado));
				carrohistorico.setSaidaFormatado(carro.getSaida().format(formatado));
				carrohistorico.setEntradaData(entradaData);

				vagas[selecao] = null;
				historico.add(carrohistorico);
				System.out.println("Saida do Carro efetuada!");
				Menu();
			}

				break;
			case 2:
				saidaCarro();
				break;
			default:
				saidaCarro();
			}
		}

			break;

		/*
		 * case 2:{
		 * 
		 * System.out.println("Digite a placa do carro:"); placa = scanner.next(); int i
		 * = 0; int precobase = 10; int preco15min = 2; long minutosdiv = 0; long
		 * precodiv = 0; int menu1 = 0;
		 * 
		 * 
		 * 
		 * while(vagas[i].getPlaca() != placa){ i++; } if (vagas[i].getPlaca() ==
		 * placa){ vagas[i].setSaida(LocalDateTime.now()); LocalDateTime from =
		 * vagas[i].getEntrada(); LocalDateTime to = vagas[i].getSaida(); Duration
		 * duration = Duration.between(from, to);
		 * System.out.println("Tempo no estacionamento: "+ duration.toMinutes() +
		 * " minutos");
		 * 
		 * if (duration.toMinutes()<=60){ preco = precobase; } if
		 * (duration.toMinutes()>60){ minutosdiv = duration.toMinutes() - 60; precodiv =
		 * minutosdiv/15 ; preco = precobase + precodiv*preco15min; }
		 * System.out.println("O preço final é: "+ preco + " reais");
		 * System.out.println("Deseja realizar saida?");
		 * System.out.println("Escolha uma opção:"); System.out.println("1)Sim");
		 * System.out.println("2)Não"); menu1 = scanner.nextInt(); switch(menu1){ case
		 * 1:{ vagas[i]=null; System.out.println("Saida do Carro efetuada!"); }
		 * 
		 * break; case 2: saidaCarro(); break; default: saidaCarro(); } }
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * break;
		 */
		case 2:
			Menu();
			break;
		default:
			saidaCarro();
		}

		return preco;
	}

	private static void cadastroMarca() {
		// criar o carro e cadastra-lo no vetor na posicao correta
		int menu = 0;
		int menu1 = 0;
		int menu2 = 0;
		int menu3 = 0;
		int i = 0;
		int num = 0;
		System.out.println("Selecione uma opção:");
		System.out.println("1)Adicionar Nova Marca");
		System.out.println("2)Adicionar um Modelo a uma Marca existente?");
		System.out.println("3)Voltar ao Menu Principal");
		Scanner scanner = new Scanner(System.in);
		menu = scanner.nextInt();
		String string = new String();
		String modelo = new String();
		Marca marca = new Marca(string);
		String marcaproc = new String();
		// int index =0;

		switch (menu) {
		case 1: {
			System.out.println("Digite a Nova Marca:");
			string = scanner.next();
			marcas.add(new Marca(string));
			System.out.println("Deseja mais Marcas?");
			// System.out.println("Deseja Adicionar Modelos à Marca?");
			System.out.println("Selecione uma opção:");
			System.out.println("1)Sim");
			System.out.println("2)Não");
			menu1 = scanner.nextInt();
			while (menu1 == 1) {
				System.out.println("Digite a Nova Marca:");
				string = scanner.next();
				marcas.add(new Marca(string));
				System.out.println("Deseja mais Marcas?");
				// System.out.println("Deseja Adicionar Modelos à Marca?");
				System.out.println("Selecione uma opção:");
				System.out.println("1)Sim");
				System.out.println("2)Não");
				menu1 = scanner.nextInt();
			}
			cadastroMarca();

			/*
			 * switch(menu1){
			 * 
			 * case 1:{ if (menu1==1){
			 * System.out.println("Digite o novo modelo para adicionar à Marca "+ string);
			 * modelo = scanner.next(); marcas.get(0).addModelo(modelo);
			 * System.out.println("Deseja adicionar mais um modelo à Marca?");
			 * System.out.println("Selecione uma opção:"); System.out.println("1)Sim");
			 * System.out.println("2)Não"); menu2 = scanner.nextInt(); while (menu2==1){
			 * System.out.println("Digite o novo modelo para adicionar à Marca "+ string);
			 * modelo = scanner.next(); marcas.get(0).addModelo(modelo);
			 * System.out.println("Deseja adicionar mais um modelo à Marca?");
			 * System.out.println("Selecione uma opção:"); System.out.println("1)Sim");
			 * System.out.println("2)Não"); menu2 = scanner.nextInt(); }
			 * 
			 * } }
			 * 
			 * break; case 2: cadastroMarca(); break; default: cadastroMarca(); }
			 */
		}
			break;
		case 2: {
			System.out.println("Escolha uma Marca:");
			while (i < marcas.size()) {
				num = i + 1;
				System.out.println(num + ")" + marcas.get(i));
				i++;
			}
			menu3 = scanner.nextInt();
			System.out.println("Digite o novo modelo para adicionar à Marca " + marcas.get(menu3 - 1));
			modelo = scanner.next();
			marcas.get(menu3 - 1).addModelo(modelo);
			System.out.println("Deseja adicionar mais um modelo à Marca?");
			System.out.println("Selecione uma opção:");
			System.out.println("1)Sim");
			System.out.println("2)Não");
			menu2 = scanner.nextInt();
			while (menu2 == 1) {
				System.out.println("Digite o novo modelo para adicionar à Marca " + marcas.get(menu3 - 1));
				modelo = scanner.next();
				marcas.get(menu3 - 1).addModelo(modelo);
				System.out.println("Deseja adicionar mais um modelo à Marca?");
				System.out.println("Selecione uma opção:");
				System.out.println("1)Sim");
				System.out.println("2)Não");
				menu2 = scanner.nextInt();
			}
			cadastroMarca();

		}
			break;
		case 3:
			Menu();
		default:
			cadastroMarca();
		}
	}

	// outros métodos static conforme especificacao do trabalho e necessidades de
	// implementacao
	private static void ocupacao() {
		int ocupacao = 0;
		int i = 0;
		int menu = 0;

		System.out.println("Selecione uma opção");
		System.out.println("1)Listar Vagas e Carros");
		System.out.println("2)Mostrar a porcentagem de ocupação");
		System.out.println("3)Voltar Menu Principal");
		Scanner scanner = new Scanner(System.in);
		menu = scanner.nextInt();

		switch (menu) {
		case 1: {
			for (i = 0; i < 100; i++) {
				System.out.println((i + 1) + ")" + vagas[i]);
			}
		}
			break;

		case 2: {
			for (i = 0; i < 100; i++) {
				if (vagas[i] != null)
					ocupacao++;
			}
			System.out.println("A ocupação das vagas é " + ocupacao + "/100");
		}
			break;

		case 3:
			Menu();
			break;
		default:
			ocupacao();
		}
		Menu();

	}

	// outros m�todos static conforme especificacao do trabalho e necessidades de
	// implementacao
	private static void relatorio() {
		String data = new String();
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		// boolean comparacao;
		int ano = 0;
		int mes = 0;
		int dia = 0;
		System.out.println("Entradas no histórico: " + historico.size());
		System.out.println(historico.get(0));

		System.out.println("Digite o ano em que deseja procurar: (AAAA)");
		ano = scanner.nextInt();
		System.out.println("Digite o mes em que deseja procurar: (MM)");
		mes = scanner.nextInt();
		System.out.println("Digite o dia em que deseja procurar: (dd)");
		dia = scanner.nextInt();

		LocalDate dateTime = LocalDate.of(ano, mes, dia);

		while (i < historico.size()) {
			if (historico.get(i).getEntradaData() != dateTime) {
				i++;
			}
			if (historico.get(i).getEntradaData() == dateTime)
				System.out.println(historico.get(i));

		}

	}

	// logica para calcular preco do estacionamento e coloca-lo no historico
	// public static boolean isSameDay(LocalDateTime timestamp, LocalDate
	// timestampToCompare){
	// return timestamp.truncatedTo(ChronoUnit.DAYS)
	// .isEqual(timestampToCompare.truncatedTo(ChronoUnit.DAYS));
	// }

}
