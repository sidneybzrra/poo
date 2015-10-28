package Projeto;

public class Horario {
	
	public String diaDaSemana;
	public int horaInicio;
	public int horaFim;
	
	
	public Horario (String diaDaSemana, int horaInicio, int horaFim){
		
		this.diaDaSemana = diaDaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
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

}
