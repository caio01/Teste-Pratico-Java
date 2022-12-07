package com.main;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.objetos.Funcionario;

public class Main {

	public static void main(String[] args) {
		ArrayList<Funcionario> listFunc = new ArrayList<Funcionario>();
		
		//3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela.
		Funcionario f0 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), 2009.44, "Operador");
		listFunc.add(f0);
		Funcionario f1 = new Funcionario("João", LocalDate.of(1990, 5, 12), 2284.38, "Operador");
		listFunc.add(f1);
		Funcionario f2 = new Funcionario("Caio", LocalDate.of(1961, 5, 2), 9836.14, "Coordenador");
		listFunc.add(f2);
		Funcionario f3 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), 19119.88, "Diretor");
		listFunc.add(f3);
		Funcionario f4 = new Funcionario("Alice", LocalDate.of(1995, 1, 5), 2234.68, "Recepcionista");
		listFunc.add(f4);
		Funcionario f5 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), 1582.72, "Operador");
		listFunc.add(f5);
		Funcionario f6 = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), 4071.84, "Contador");
		listFunc.add(f6);
		Funcionario f7 = new Funcionario("Laura", LocalDate.of(1994, 7, 8), 3017.45, "Gerente");
		listFunc.add(f7);
		Funcionario f8 = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), 1606.85, "Eletricista");
		listFunc.add(f8);
		Funcionario f9 = new Funcionario("Helena", LocalDate.of(1996, 9, 2), 2799.93, "Gerente");
		listFunc.add(f9);
		
		//3.2 – Remover o funcionário “João” da lista.
		removeFunc(listFunc, "João");
		
		//3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
		//• informação de data deve ser exibido no formato dd/mm/aaaa;
		//• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
		imprimeFunc(listFunc);
		
		//3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
		aumentoSalario(listFunc, 10);
		
		//3.6 – Imprimir os funcionários, agrupados por função.
		imprimeFuncAgrupPorFunc(listFunc);
		imprimeFunc(listFunc);
		
		//3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		ArrayList<Funcionario> listFunc2 = new ArrayList<Funcionario>();
		for(Funcionario f : listFunc) {
			if (f.getDataNasc().getMonthValue() == 10 ||
				f.getDataNasc().getMonthValue() == 12) {
				listFunc2.add(f);
			}
		}
		imprimeFunc(listFunc2);
		
		//3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
		imprimeNomeIdadeFuncMaisvelho(listFunc);
		
		
		//3.10 – Imprimir a lista de funcionários por ordem alfabética.
		ordenaFuncEmOrdemAlf(listFunc);
		imprimeFunc(listFunc);
		
		
		//3.11 – Imprimir o total dos salários dos funcionários.
		imprimeTotalSalarios(listFunc);
		
		//3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
		imprimeQtdSalarioMinPorFunc(listFunc, 1212);
		
		
	}
	
	private static void imprimeFunc(ArrayList<Funcionario> listFunc) {
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		for(Funcionario f : listFunc) {
			System.out.print(f.getNome() + "  ");
			System.out.print(f.getDataNasc().format(formatar) + "  ");
			System.out.print(df.format(f.getSalario()) + "  ");
			System.out.println(f.getFuncao());
		}
		System.out.println();
	}
	
	private static void removeFunc(ArrayList<Funcionario> listFunc, String nomeFunc) {
		for(Funcionario f : listFunc) {
			if (f.getNome() == nomeFunc) {
				listFunc.remove(f);
				break;
			}
		}
	}
	
	private static void aumentoSalario(ArrayList<Funcionario> listFunc, int valorPercent) {
		for(Funcionario f : listFunc) {
			f.setSalario(f.getSalario() + f.getSalario()*valorPercent/100);
		}
	}
	
	private static void imprimeNomeIdadeFuncMaisvelho(ArrayList<Funcionario> listFunc) {
		int menorAnoNasc = 2022;
		int count = 0;
		for(Funcionario f : listFunc) {
			if (f.getDataNasc().getYear() < menorAnoNasc) {
				menorAnoNasc = f.getDataNasc().getYear();
				count = listFunc.indexOf(f);
			}
		}
		int idade = 2022 - listFunc.get(count).getDataNasc().getYear();
		System.out.println("Nome: " + listFunc.get(count).getNome() + "   Idade: " + idade);
		System.out.println();
	}
	
	private static void ordenaFuncEmOrdemAlf(ArrayList<Funcionario> listFunc) {
		Collections.sort(listFunc, new Comparator<Funcionario>() {
	        @Override
	        public int compare(Funcionario  f1, Funcionario  f2)
	        {
	            return  f1.getNome().compareTo(f2.getNome());
	        }
	    });
	}
	
	private static void imprimeTotalSalarios(ArrayList<Funcionario> listFunc) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		int totSalario = 0;
		for(Funcionario f : listFunc) {
			totSalario += f.getSalario();
		}
		System.out.println(df.format(totSalario));
		System.out.println();
	}
	
	private static void imprimeQtdSalarioMinPorFunc(ArrayList<Funcionario> listFunc, double valorSalarioMin) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		for(Funcionario f : listFunc) {
			System.out.print(f.getNome() + "  ");
			System.out.println(df.format(f.getSalario()/valorSalarioMin));
		}
		System.out.println();
	}
	
	private static void imprimeFuncAgrupPorFunc(ArrayList<Funcionario> listFunc) {
		Collections.sort(listFunc, new Comparator<Funcionario>() {
	        @Override
	        public int compare(Funcionario  f1, Funcionario  f2)
	        {
	            return  f1.getFuncao().compareTo(f2.getFuncao());
	        }
	    });
	}

}
