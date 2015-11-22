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
	
	

}

