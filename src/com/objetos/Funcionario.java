package com.objetos;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa{
	private String funcao;
	private double salario;
	
	public Funcionario(String nome, LocalDate dataNasc, double salario, String funcao) {
		super(nome, dataNasc);
		this.funcao = funcao;
		this.salario = salario;		
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcao, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcao, other.funcao)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
}
