package br.caracter;

public class Run {

	public static void main(String[] args) {
		StreamImple sImp = new StreamImple();
		//String letraSaida = sImp.getValorLogico("Este Algoritmo foi desenvolvido por Daniel Marmitt para a ns");
		String letraSaida = sImp.getValorLogico("aAbBABacafe");
		System.out.println("Letra Sa�da");
		System.out.println(letraSaida);
		System.out.println("--------------------------");

		//Mensagem da combina��o encontrada
		System.out.println("Conjunto Sa�da");
		System.out.println(sImp.getMensagem()[0]);

	}

}
