package POO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Horario {
	
	public static final String SEGUNDA = "SEG";
	public static final String TERÇA = "TER";
	public static final String QUARTA = "QUA";
	public static final String QUINTA = "QUI";
	public static final String SEXTA = "SEX";
	public static String diaDaSemana;
	public static int horaInicio;
	public static  int horaFim;
	private List<Sala> horarios;
	
	
	public Horario (String diaDaSemana, int horaInicio, int horaFim){
		
		this.diaDaSemana = diaDaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.horarios = new LinkedList<Sala>();
	}
	public Horario(){}
	
	public String getDiaDaSemana(){
		return this.diaDaSemana;
	}
	public void setDiaDaSemana(String diaDaSemana){
		this.diaDaSemana = diaDaSemana;
	}
	public int getHoraInicio(){
		return this.horaInicio;
	}
	public void setHoraInicio(int horaInicio){
		this.horaInicio = horaInicio;
	}
	public int getHoraFim(){
		return this.horaFim;
	}
	public void setHoraFim(int horaFim){
		this.horaFim = horaFim;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + horaFim;
		result = prime * result + horaInicio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (diaDaSemana == null) {
			if (other.diaDaSemana != null)
				return false;
		} else if (!diaDaSemana.equals(other.diaDaSemana))
			return false;
		if (horaFim != other.horaFim)
			return false;
		if (horaInicio != other.horaInicio)
			return false;
		return true;
	}
	
	
 }

	
	


