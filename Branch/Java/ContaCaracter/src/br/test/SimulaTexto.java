package br.test;

import org.junit.Test;

import br.caracter.StreamImple;
import static org.junit.Assert.*;

/**
 * 
 * @author daniel.marmitt
 *
 */
public class SimulaTexto  {
	
	@Test
	public void simulaTextos()
	{
		StreamImple si = new StreamImple();
		//String valorRetorno=si.getValorLogico("Este algoritmo foi feito por Daniel Marmitt a ns");
		String valorRetorno=si.getValorLogico("aAbBABacafe");
		assertEquals("e", valorRetorno);
	}

}
