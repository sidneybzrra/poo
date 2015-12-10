package POO;

import java.util.*;
import java.io.*;

public class Disciplina {
	
	private String nome;
	private String codigo;
	private List<Sala> salas;
	private int PeriodoDisc;
	private  int TotalAlunosDiciplina;
	
	public Disciplina(String nome, String codigo){
		
		this.nome= nome;
		this.codigo = codigo;
		this.salas = new LinkedList<Sala>();
				
	}
	
	
	public int getPeriodoDisc() {
		return PeriodoDisc;
	}


	public void setPeriodoDisc(int periodoDisc) {
		PeriodoDisc = periodoDisc;
	}


	public int getTotalAlunosDiciplina() {
		return TotalAlunosDiciplina;
	}


	public void setTotalAlunosDiciplina(int totalAlunosDiciplina) {
		TotalAlunosDiciplina = totalAlunosDiciplina;
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<Sala> getSalas() {
		return this.salas;
	}
	
	public void adicionaSala(int numero) throws SalaJaExisteException {
		for (Sala s: this.salas){
			if (s.getNumero() == numero){
				throw new SalaJaExisteException("Já existe a turma de número:"+numero);
			}
		}
		//Caso não lance a exceção, ele adiciona a nova turma assim:
		Sala s = new Sala(this, numero);
		this.salas.add(s);
	}
	
	
	public void removeSala(int numero){
		for (Sala s: this.salas){
			if (s.getNumero() == numero){
				this.salas.remove(s);
				break;
			}
		}
	}

	public String toString(){
		
		String teste = new String();
		teste += this.nome+"\n";
		teste += this.codigo;
	
		for(Sala t: this.salas){
	
			teste += t.toString();
			
		}
		return teste;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
   

}

