package edu.univem.selenium.aula.telas.cambio;


import edu.univem.selenium.aula.dominio.Moeda;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;

public class TelaCambioUOL {

	private SeleniumWebDriver selenium;
	private static final String URL = "http://economia.uol.com.br/cotacoes/cambio.jhtm";

	public TelaCambioUOL(SeleniumWebDriver selenium) {
		this.selenium = selenium;
	}

	public void abrir() {
		selenium.driver.get(URL);
		selenium.assertTitle("Câmbio: Cotações do Dólar, Euro e outras moedas - UOL Economia");
	}

	public Moeda consultarCotacaoDolarComercial() {
		selenium.selectByVisibleText(localizarComboMoedas(),
				"Estados Unidos - Dólar comercial");

		Moeda dolar = new Moeda();
		preencherCotacao(dolar);

		return dolar;
	}

	public Moeda consultarCotacaoPesoArgentino() {
		selenium.selectByVisibleText(localizarComboMoedas(), "Argentina - Peso");

		Moeda peso = new Moeda();
		preencherCotacao(peso);

		return peso;
	}

	public Moeda consultarCotacaoEuro() {
		selenium.selectByVisibleText(localizarComboMoedas(), "Alemanha - Euro");

		Moeda euro = new Moeda();
		preencherCotacao(euro);

		return euro;
	}

	private Moeda preencherCotacao(Moeda moeda) {
		moeda.setNome(selenium.getText("div.navegacao-cambio h2"));
		moeda.setHorario(selenium.getText(localizarMoedaHorario()));
		moeda.setCompra(selenium.getText(localizarMoedaCompra()));
		moeda.setVenda(selenium.getText(localizarMoedaVenda()));
		moeda.setPorcentagemVariacao(selenium
				.getText(localizarMoedaPorcentagemVariacao()));
		moeda.setMoedaVariacao(selenium.getText(localizarMoedaVariacao()));
		moeda.setValorMaximo(selenium.getText(localizarMoedaMaximo()));
		moeda.setValorMinimo(selenium.getText(localizarMoedaMinimo()));
		return moeda;
	}

	private String localizarMoedaHorario() {
		return "td.date";
	}

	private String localizarMoedaCompra() {
		return "td.bid";
	}

	private String localizarMoedaVenda() {
		return "td.ask";
	}

	private String localizarMoedaPorcentagemVariacao() {
		return "td[class='pctChange ultima']";

	}

	private String localizarMoedaVariacao() {
		return "td[class='varBid ultima']";
	}

	private String localizarMoedaMaximo() {
		return "td.high";
	}

	private String localizarMoedaMinimo() {
		return "td.low";
	}

	private String localizarComboMoedas() {
		return "div#combo-moedas form select";
	}

}
