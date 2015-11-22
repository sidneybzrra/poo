import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Professor {
	
	private List<Disciplina> listaDisciplinasP1;
	private List<Disciplina> listaDisciplinasP2;
	private List<Disciplina> listaDisciplinasP3;
	private List<Disciplina> listaDisciplinasNP;
	public static final int PREF_P1 = 1;
	public static final int PREF_P2 = 2;
	public static final int PREF_P3 = 3;
	public static final int PREF_NP = 4;
	private List<Sala> salasAlocado;
	private String nome;
	private String matricula;
	
	public Professor(String nome, String matricula){
		this.nome=nome;
		this.matricula = matricula;
		this.salasAlocado = new LinkedList<Sala>();
		this.listaDisciplinasP1 = new LinkedList<Disciplina>();
		this.listaDisciplinasP2 = new LinkedList<Disciplina>();
		this.listaDisciplinasP3 = new LinkedList<Disciplina>();
		this.listaDisciplinasNP = new LinkedList<Disciplina>();	
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
		
		public String toString(){
			
			String txt = getDescricao()+"\n";
		
			txt+="Disciplinas P1:"+getListaNomesDisciplinas(this.listaDisciplinasP1);		
			txt+="\nDisciplinas P2:"+getListaNomesDisciplinas(this.listaDisciplinasP2);
			txt+="\nDisciplinas P3:"+getListaNomesDisciplinas(this.listaDisciplinasP3);
			txt+="\nDisciplinas NP:"+getListaNomesDisciplinas(this.listaDisciplinasNP);
		
			return txt;
		
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
		
		public String  getListaCodigosDisciplinas(List < Disciplina > lista){
			
			String listaCodigo="";
		
			for (int k=0; k< lista.size(); k++){
		
				Disciplina d  = lista.get(k);
				listaCodigo+= d.getCodigo();
		
				if (k!= lista.size()-1){
		
					listaCodigo+=",";
		
				}
			}
			return listaCodigo;
			
		}

		public String getTextoPreferenciasDisciplinasComCodigo() {
			String teste = "p1:";
			
			teste += getListaCodigosDisciplinas(listaDisciplinasP1) +"\n";
			teste += "p2";
			teste += getListaCodigosDisciplinas(listaDisciplinasP2) +"\n";
			teste += "p3";
			teste += getListaCodigosDisciplinas(listaDisciplinasP3) +"\n";
			teste += "p4";
			teste += getListaCodigosDisciplinas(listaDisciplinasNP) +"\n";
			
			return teste;	
		}
		
		public List<Disciplina> getDisciplinasPreferidasComNivel(int nivelPreferencia) throws PreferenciaInvalidaException{
			
			if (nivelPreferencia == PREF_P1){
		
				return this.listaDisciplinasP1;
		
			}else if(nivelPreferencia == PREF_P2){
			
				return this.listaDisciplinasP2;
			
			}else if(nivelPreferencia == PREF_P3){
			
				return this.listaDisciplinasP3;
			
			}else if(nivelPreferencia == PREF_NP){
			
				return this.listaDisciplinasNP;
			
			}else{
			
				throw new PreferenciaInvalidaException("Número de Preferencia: "+nivelPreferencia+", não há um número valido para preferencia.");
				
			}
		}
		
		public void adicionaPreferenciaDisciplina(Disciplina d, int nivelPreferencia) throws PreferenciaInvalidaException{
			
			if (nivelPreferencia == PREF_P1){
			
				this.listaDisciplinasP1.add(d);
			
			}else if(nivelPreferencia == PREF_P2){
			
				this.listaDisciplinasP2.add(d);

			}else if(nivelPreferencia == PREF_P3){
			
				this.listaDisciplinasP3.add(d);
			
			}else if(nivelPreferencia == PREF_NP){
			
				this.listaDisciplinasNP.add(d);
			
			}else{
				
				throw new PreferenciaInvalidaException("Número de Preferencia: "+nivelPreferencia+", não há um número valido para preferencia.");
				
			}
		}
	}

