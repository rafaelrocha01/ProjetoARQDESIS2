package br.usjt.arqdesis.javabens;

import java.util.Calendar;
public class Empresa {
	int id;
	String cnpj;
	String razaSocial ;
	int conjunto;
	String horarioDeFuncionameto;
	int valorTemperatura;
	String horarioArCondicionado;
	
	public Empresa(){
		
	}
	
	public Empresa(String cnpj, String razaSocial, int conjunto, String horarioDeFuncionameto,
			int valorTemperatura, String horarioArCondicionado) {
		super();
		this.cnpj = cnpj;
		this.razaSocial = razaSocial;
		this.conjunto = conjunto;
		this.horarioDeFuncionameto = horarioDeFuncionameto;
		this.valorTemperatura = valorTemperatura;
		this.horarioArCondicionado = horarioArCondicionado;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaSocial() {
		return razaSocial;
	}

	public void setRazaSocial(String razaSocial) {
		this.razaSocial = razaSocial;
	}

	public int getConjunto() {
		return conjunto;
	}

	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}

	public String getHorarioDeFuncionameto() {
		return horarioDeFuncionameto;
	}

	public void String(String horarioDeFuncionameto) {
		this.horarioDeFuncionameto = horarioDeFuncionameto;
	}

	public int getValorTemperatura() {
		return valorTemperatura;
	}

	public void setValorTemperatura(int valorTemperatura) {
		this.valorTemperatura = valorTemperatura;
	}

	public String getHorarioArCondicionado() {
		return horarioArCondicionado;
	}

	public void setHorarioArCondicionado(String horarioArCondicionado) {
		this.horarioArCondicionado = horarioArCondicionado;
	}

	public void setHorarioDeFuncionameto(String horarioDeFuncionameto) {
		this.horarioDeFuncionameto = horarioDeFuncionameto;
	}
	
	
	
	
	

}
