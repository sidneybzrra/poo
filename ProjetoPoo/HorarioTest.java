package POO;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Thamires
 *
 */
public class HorarioTest {

	@Test
	public void getDiaDaSemana() {
		Horario h = new Horario("Segunda", 15, 17);
		assertEquals("Segunda",h.getDiaDaSemana());
		assertEquals(15, h.getHoraInicio());
		assertEquals(17,h.getHoraFim());
		
	}
	public void setDiaDaSemana(String diaDaSemana){
		Horario h = new Horario("Segunda", 15, 17);
		assertEquals("Terça",h.getDiaDaSemana());
		assertEquals(13, h.getHoraInicio());
		assertEquals(15,h.getHoraFim());
	}
	
	public void getHoraInicio(){
		Horario h = new Horario("Segunda", 15, 17);
		assertEquals("Terça",h.getDiaDaSemana());
		assertEquals(8, h.getHoraInicio());
		assertEquals(10,h.getHoraFim());
		
	}

		
}

