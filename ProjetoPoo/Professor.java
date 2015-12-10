package POO;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Professor {
	
	
	private List<Sala> salasAlocado;
	private String nome;
	private String matricula;
	
	public Professor(String nome, String matricula){
		this.nome=nome;
		this.matricula = matricula;
		this.salasAlocado = new LinkedList<Sala>();
		
	}
	public Professor(){
		
	}
	public String getDescricao(){
		
	   return "Nome: "+this.getNome()+" Matricula: "+this.getMatricula();
		
	} 

		
	public void alocaSala(Sala sala){
		this.salasAlocado.add(sala);
	}
		
		public void desalocaSala(Sala sala){
			this.salasAlocado.remove(sala);
				
		}
		
		public List<Sala> getSalaAlocado(){
			return this.salasAlocado;
		}
		
		public List<Disciplina> getDisciplinasAlocado(){
			List<Disciplina> disciplinasAlo = new LinkedList<Disciplina>();
			for(Sala t: this.salasAlocado){
				if(disciplinasAlo.contains(t.getDisciplina())){
					
				}
				else{
					disciplinasAlo.add(t.getDisciplina());
				}
			}
			return disciplinasAlo;
		}
		
		public List<Horario> getHorarios(){
		    List<Horario> horario = new ArrayList<Horario>();
		    for(Sala s: salasAlocado){
		        if (s.equals(s) == true){
		            horario.addAll(s.getHorarios());
		              
		       }
		   }
		   return horario;
		   
	    }
		

		public String getMatricula() {
			
			return this.matricula;
		}

		public String getNome() {
			// TODO Auto-generated method stub
			return this.nome;
		}
		
		

		public String getListaNomesDisciplinas(List < Disciplina > lista){
			
			String listaNomes="";
		
			for (int k=0; k< lista.size(); k++){
		
				Disciplina d  = lista.get(k);
				listaNomes+= d.getNome();
		
				if (k!= lista.size()-1){
		
					listaNomes+=",";
		
				}
			}
		
			return listaNomes;
		}
		
	}

