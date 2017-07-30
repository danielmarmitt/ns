package br.caracter;

/**
 * Algoritmo
 * @author daniel.marmitt
 * Data Criação: 24/07/2017
 * Data de Modificação:30/07/2014
 */
public class StreamImple implements Stream {

	String vogais="aeiou";
	String consoantes="bcdfghjklmnpqrstvxwyz";
	String texto;
	/**
	 * Mensagem com a combinação encontrada
	 */
	String[] mensagem = new String[1];
	
	char proximoCaracterLeitura;
	/**
	 * Retorna falso, quando a leitura de toda a Stream estiver completa.
	 */
	boolean leituraCompleta=true;
	
	@Override
	public char getNext() {
		return proximoCaracterLeitura;
	}

	/**
	 * @author daniel.marmitt
	 * O método devolve o status, se a leitura de uma determinada String foi
	 * completamente lida.
	 * 
	 */
	@Override
	public boolean hasNext() {
		return leituraCompleta;
	}


	/**
	 * @author daniel.marmitt
	 * @param Recebe o texto que compara as vogais
	 */
	public String getValorLogico(String texto)
	{
		this.leituraCompleta=true;
		String letraSaida = "";
		mensagem[0]="Não foi encontrado uma combinação de vogal com consoante!";
		String[] conjunto = new String[1];
		
		int qtdVogais, qtdConsoantes = 0;
		int numLetras=texto.length();
		
		for(int i=0;i<numLetras;i++)
		{
			if((i+1)<=numLetras && (i+2)<=numLetras )
				this.proximoCaracterLeitura = texto.substring(i+1,i+2).charAt(0); 
		
			System.out.println("O próximo Caracter é: "+getNext());
			
			//Identifica uma vogal posterior a uma consoante
			if(vogais.indexOf(texto.substring(i, i+1).toLowerCase() ) >=0 )
			{
				/**
				 *O primeiro caracter Vogal da stream que não se repete após a 
				 * primeira Consoante o qual tem uma vogal como antecessora.	
				 */
				if(i>=1 && (consoantes.indexOf(texto.substring(i-1 , i).toLowerCase()) >=0 )){
						if(i>=1 && (vogais.indexOf(texto.substring(i-2 , i-1).toLowerCase()) >=0 )){
							boolean repeteCarac = caracterRepetido(texto.substring(0,i), texto.substring(i, i+1) ); 
							if(!repeteCarac){
								
								letraSaida = texto.substring(i, i+1);
								this.mensagem[0] = "A combinação encontrada é:"+texto.substring(i-2 , i-1)+texto.substring(i-1 , i)+texto.substring(i, i+1);
								conjunto[0] = "***********Vogal Ant:"+texto.substring(i-2 , i-1)+" - Consoante: " +texto.substring(i-1 , i)+ " - vogal Pós:"+texto.substring(i, i+1);
							}
						}
				}
			}
		}
		//System.out.println(conjunto[0]);
		
		return letraSaida;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/**
	 * 
	 * @param textoJaLido
	 * @return true:Caso o caratecer vogal esteja repetido
	 *         false:Caso não esteja o caracter vogal repetido
	 */
	private boolean caracterRepetido(String textoJaLido, String vogalAtual)
	{
		try {
			
			if (textoJaLido.indexOf(vogalAtual.toLowerCase() )>=0)
			 return true;
			
		} catch (Exception e) {
			System.out.println("Aconteceu um erro ao identificar um caracter repetido!");
		}
		return false;
	}

	public String[] getMensagem() {
		return mensagem;
	}

}
