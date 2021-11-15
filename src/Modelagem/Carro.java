package Modelagem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Carro {

	private Modelo modelo;
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float valor;
	private DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private String saidaFormatado;
	private String entradaFormatado;
	private LocalDate entradaData;

	public LocalDate formatEntradaLocalDate(LocalDateTime entrada) {
		LocalDate entradaData = entrada.toLocalDate();
		return entradaData;
	}

	public LocalDate getEntradaData() {
		return entradaData;
	}

	public void setEntradaData(LocalDate entradaData) {
		this.entradaData = entradaData;
	}

	public Carro(Modelo modelo, String placa, LocalDateTime entrada) {
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
	}

	public Carro(Modelo modelo, String placa, LocalDateTime entrada, LocalDateTime saida, float valor) {
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
		this.valor = valor;
	}

	public Carro(Modelo modelo, String placa, LocalDateTime entrada, float valor, String saidaFormatado,
			String entradaFormatado) {
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
		this.valor = valor;
		this.saidaFormatado = saidaFormatado;
		this.entradaFormatado = entradaFormatado;
	}

	public Carro(Modelo modelo, String placa, float valor, String saidaFormatado, String entradaFormatado,
			LocalDate entradaData) {
		this.modelo = modelo;
		this.placa = placa;
		this.valor = valor;
		this.saidaFormatado = saidaFormatado;
		this.entradaFormatado = entradaFormatado;
		this.entradaData = entradaData;
	}

	public Carro(Modelo modelo) {
		this.modelo = modelo;
	}

	public Carro(String placa) {
		this.placa = placa;
	}

	public Carro(float valor) {
		this.valor = valor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String formatEntrada(LocalDateTime entrada) {
		String entradaFormatado = entrada.format(formatado);
		return entradaFormatado;
	}

	public String formatSaida(LocalDateTime saida) {
		String saidaFormatado = saida.format(formatado);
		return saidaFormatado;
	}

	public DateTimeFormatter getFormatado() {
		return formatado;
	}

	public void setFormatado(DateTimeFormatter formatado) {
		this.formatado = formatado;
	}

	public String getSaidaFormatado() {
		return saidaFormatado;
	}

	public void setSaidaFormatado(String saidaFormatado) {
		this.saidaFormatado = saidaFormatado;
	}

	public String getEntradaFormatado() {
		return entradaFormatado;
	}

	public void setEntradaFormatado(String entradaFormatado) {
		this.entradaFormatado = entradaFormatado;
	}

	@Override
	public String toString() {
		if (saida == null) {
			return "Modelo: " + modelo + " | Placa: " + placa + " | Entrada: " + entradaFormatado;
		} else {
			return "Modelo: " + modelo + " | Placa: " + placa + " | Entrada: " + entradaFormatado + " | Saida: "
					+ saidaFormatado + " | Preco: " + valor;

		}

	}

}
