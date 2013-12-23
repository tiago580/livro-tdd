package com.br.tiago.livrotdd.cap5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CarroAlugadoTest {

	@Mock
	private AlugaCarro alugaCarro;

	@Before
	public void setUp() throws Exception {
		alugaCarro = Mockito.mock(Cliente.class);
	}
	
	@Test
	public void alugaCarroParaCliente(){
		CarroAlugado car = new CarroAlugado(alugaCarro);
		
		String resultadoEsperado = "CamiloGolf";
		Mockito.when(alugaCarro.getNomeCliente()).thenReturn("Camilo");
		Mockito.when(alugaCarro.getModeloCarro()).thenReturn("Golf");
		
		String verdadeiroResultado = car.getAlugaCarro().getNomeCliente() +
		car.getAlugaCarro().getModeloCarro();
		
		Mockito.verify(alugaCarro).getNomeCliente();
		Assert.assertEquals(resultadoEsperado, verdadeiroResultado);
	}
	
	@Test
	public void verificaSeUmMetodoNumcaFoiExecutado(){
		CarroAlugado carroAlugado = new CarroAlugado(alugaCarro);
		Mockito.when(alugaCarro.getModeloCarro()).thenReturn("Civic");
		
		String modeloCarro = carroAlugado.getAlugaCarro().getNomeCliente();
		Mockito.verify(alugaCarro, Mockito.never()).getNomeCliente();
	}

}
