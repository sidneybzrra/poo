package POO;

import java.util.List;

public class Laboratorio{
	
	private int numero;
	private Professor professor;
	private List<Horario> horarios;
	private Disciplina disciplina;
	private int qtdAlunosPorSala;
	private int salaPertenceAoBloco;
	
	public Professor getProfessor(){
		return this.professor;
	}
	public void setProfessor(Professor professor){
		this.professor = professor;
	}
	public List<Horario> getHorarios(){
		return this.horarios;
	}
	public void setHorarios(List<Horario> horarios){
		this.horarios = horarios;
	}
	public int getNumero(){
		return this.numero;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public Disciplina getDisciplina(){
		return this.disciplina;
	}
	public void setDisciplina (Disciplina disciplina){
		this.disciplina = disciplina;
	}
	public void adicionarHorario(Horario h){
		this.horarios.add(h);
	}
	public int getQtdAlunosPorSala(){
		return qtdAlunosPorSala;
	}
	public void setQtdAlunosPorSala( int qtdAlunosPorSala){
		this.qtdAlunosPorSala = qtdAlunosPorSala;
	}
	public int getSalaPertenceAoBloco(){
		return salaPertenceAoBloco;
	}
	public void setSalaPertenceAoBloco(int salaPertenceAoBloco){
		this.salaPertenceAoBloco = salaPertenceAoBloco;
	}


}
