package Modelagem;

import java.time.LocalDateTime;

public class Carro {

	private Modelo modelo;
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float valor;

	public Carro(Modelo modelo, String placa, LocalDateTime entrada) {
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
	}

	public String getDataHoraFormatada(LocalDateTime tempo) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m.s");
		return tempo.format(formato);
	}

	@Override
	public String toString() {
		return "Carro  placa=" + placa + getDataHoraFormatada(entrada);
	}

}
