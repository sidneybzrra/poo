
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Gerenciamento implements Interface { // Depois Implementar a interface 
	    
	    
	    private List<Disciplina> disciplinas;
	    private List<Professor> professores;
	    private List<Horario> horarios;
	    
	    //método de remover o horario <<<=== fazer ainda.
	    
	    // Iniciando o construtor com as instancias das listas
	    public Gerenciamento(){
	    
	        this.disciplinas = new LinkedList<Disciplina>(); //inicializa a lista de Disciplinas
	        this.professores = new LinkedList<Professor>(); //inicializa a lista de Professores
	        this.horarios = new LinkedList<Horario>(); // inicializa a lista de horários
	    }
	    
	    // Começando no métodos de adicionar, pesquisar e remover
	    public void cadastraProfessor(String nome, String matricula) throws ProfessorJaExisteException { //Cadastra professores   
	        
	    for(Professor p: this.professores) {
 
	            if(p.getMatricula().equals(matricula)){

	                throw new ProfessorJaExisteException("Ja Existe!");             

	            } 
	        
	        }

	        this.professores.add(new Professor(nome,matricula));

	    }
	    
	    
	    public List<Professor> pesquisaProfessorPeloNome(String nome)throws ProfessorInexistenteException{ //Pesquisa Professor pelo nome cadastrado
	        List<Professor> pro = new LinkedList<Professor>();      
	       
	        for (Professor pr: this.professores){
	            if(pr.getNome().indexOf(nome)>= 0){ // indexOF serve para saber qual Ã­ndice determinado pedaÃ§o da string corresponde. Ele retorna um valor do tipo int.
	                pro.add(pr);
	         
	            }     
	           } 
	            
	        return pro;
	        
	    }   
	    
	    public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException{ //pesquisa professores por sua matricula cadastradas
	       
	        for (Professor p: this.professores){ // varre a lista de professores

	            if (p.getMatricula().equals(matricula)){ //verifica se ja existe esse professor pela matricula
	            	return p;
	            }
	        
	        }
	        
	            throw new ProfessorInexistenteException("Matricula Inexistente!");
	        
	    }
	    
	    
	    public void removeProfessor(String matricula) throws ProfessorInexistenteException{ 
	    
	    	boolean remove = false;
	        for (Professor p: this.professores){
	            if(matricula.equals(p.getMatricula())){// verifica pela matricula e remove o professor
	                
	                this.professores.remove(p);
	                remove = true;
	            }
	        }
	        if(!remove){
	        throw new ProfessorInexistenteException("Professor Inexistente!");  
	        }
	    }   


	    public void adicionaDisciplina(String nomeDisciplina, String codigoDisciplina) 
	    		throws DisciplinaJaExisteException{ //adiciona uma disciplina na lista
	         
	        for(Disciplina d: this.disciplinas){
	        
	             if(d.getCodigo().equals(codigoDisciplina)){
	        
	                 throw new DisciplinaJaExisteException("Disciplina já existente!");
	             
	            }
	         
	        }

	         this.disciplinas.add(new Disciplina(nomeDisciplina, codigoDisciplina));
	     
	    }
	    
	    public void removeDisciplina(String codigo) throws DisciplinaInexistenteException{ //remove uma disciplina na lista de cadastrados
	         
	        boolean teste = false;
	        
	        for(Disciplina d: this.disciplinas){ //lista as disciplinas
	            
	            if(d.getCodigo().equals(codigo)){ //comparaÃ§ao do codigo da disciplina, se igual remove da lista
	                
	                disciplinas.remove(d); 
	                teste = false;
	                break;
	             
	            }else{

	                 teste = true;
	            
	            }
	         }
	         
	        if (teste == true){
	        
	             throw new DisciplinaInexistenteException("Nãoo existe disciplina com esse codigo!");

	        }else{
	        
	            System.out.println("Disciplina removida com sucesso!");
	        
	        }
	    }
	     
	    public Disciplina pesquisaDisciplina(String codigoDisciplina) throws DisciplinaInexistenteException{ //pesquisa disciplinas
	         
	    
	         for(Disciplina d: this.disciplinas){
	             if(d.getCodigo().equals(codigoDisciplina)){
	    
	     
	                 return d;
	    
	             }
	         } 
	         throw new DisciplinaInexistenteException("Não existe disciplina com esse codigo");
	         
	     }
		
	    public void adicionaSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException, SalaJaExisteException{ //adiciona a Sala
	    
	         boolean existeDisciplina = false;
	         boolean existeSala = true;
	         for(Disciplina d: this.disciplinas){
	             if(d.getCodigo().equals(codigoDisciplina)){
	            	 existeDisciplina = true;
	            	 if(!d.getSalas().equals(numSala)){
	                 d.adicionaSala(numSala);
	                 existeSala = false;
	    
	            	 }
	             } 
	           }
	         
	        if(!existeDisciplina){
	        
	             throw new DisciplinaInexistenteException("Disciplina com esse código não existe!");
	        
	        }else if(existeSala){
	        	throw new SalaJaExisteException("A sala já existe");
	        
	        }
	     }


	    public void removeSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException{ // remove sala
	        
	        boolean teste = false;
	        for(Disciplina d: this.disciplinas){
	            if(d.getCodigo().equals(codigoDisciplina)){
	                d.removeSala(numSala);
	                teste = true;
	                break;
	                
	            }
	        }
	        
	        if(!teste){
	        
	             throw new DisciplinaInexistenteException("Disciplina com esse código não existe!");
	        }
	     
	    }
	    
	    public Sala pesquisaSala(String codigoDisciplina, int numSala)throws DisciplinaInexistenteException, SalaInexistenteException{
	    	//Pesquisa sala
			List<Sala> s = this.pesquisaDisciplina( codigoDisciplina).getSalas();
			for( Sala sa: s){
				if(sa.getNumero()== numSala){
					return sa;
				}
			}
			throw new  DisciplinaInexistenteException(" A disciplina não existe");
			
		}
	    
	  
		   public void adicionaHorarioSala(String  codigoDisciplina, int numSala, String diaDaSemana, int horaInicio, int horaFim) throws DisciplinaInexistenteException, SalaInexistenteException { 
			   //Adiciona horário a sala
			   List<Sala> s = this.pesquisaDisciplina( codigoDisciplina).getSalas();
			   for(Sala sa: s){
				   if(sa.getNumero()== numSala){
					  sa.adicionarHorario(new Horario(diaDaSemana, horaInicio, horaFim));
				   }
			   }
		   }
	     /*  
		   public void removeHorarioSala(String codigoDisciplina, int numSala,String diaDaSemana, int horaInicio, int horaFim)throws DisciplinaInexistenteException, SalaInexistenteException{// Método de remover horários
			  //Removo horário sala
			   List<Sala> s = this.pesquisaDisciplina(codigoDisciplina).getSalas();
			  for(Sala sa: s){
				  if(sa.getNumero()==numSala){
					  sa.removeHorario(diaDaSemana, horaInicio, horaFim);
				  }  
			  }
		 }*/
		   
		   
		   
		   public void alocaProfessorASala(String codigoDisciplina, int numSala,String matricula) throws DisciplinaInexistenteException,SalaInexistenteException, ProfessorInexistenteException {
				  // aloca professor a sala
			   Professor prof = this.pesquisaProfessorPelaMatricula(matricula);
				  Sala sala = this.pesquisaSala(codigoDisciplina, numSala);
				 sala.setProfessor(prof);
				  prof.alocaSala(sala);
			
		    }
				
		   public void desalocaProfessorDaSala(String codigoDisciplina, int numSala,String matricula) throws DisciplinaInexistenteException,SalaInexistenteException, ProfessorInexistenteException {
				//desalocando professor da sala
				 Professor prof = this.pesquisaProfessorPelaMatricula(matricula);
				 Sala sala = this.pesquisaSala(codigoDisciplina, numSala);
				 sala.setProfessor(prof);
				 prof.desalocaSala(sala);
			}
		   
		   public List <Horario> pesquisaHorariosProfessor(String matricula)throws ProfessorInexistenteException {
				
				return this.pesquisaProfessorPelaMatricula(matricula).getHorarios();
			
			}

			public List <Sala> pesquisaSalasDoProfessor(String matriculaProf)throws ProfessorInexistenteException {
				////Pesquisa salas do professor
				return this.pesquisaProfessorPelaMatricula(matriculaProf).getSalaAlocado();
			
			}

			public List <Disciplina> pesquisaDisciplinasDoProfessor(String matricula)throws ProfessorInexistenteException {
				//Pesquisa dsiciplinas do professor
			
				return this.pesquisaProfessorPelaMatricula(matricula).getDisciplinasAlocado();
			}   
			
			public void imprimeProfessoresEDisciplinas() {
			    // imprime a lista de csiciplinas e de professores
		        String aux = new String();
		    
		        for(Professor p: this.professores){
		    
		            aux = p.toString();
		    
		        }
		    
		        System.out.println("Menssagem" + aux);
		        
		        String dis = new String();
		    
		        for(Disciplina d: this.disciplinas){
		    
		            dis += d.toString();
		        }
		    
		        System.out.println("Menssagem" + dis);
		    }

			public void gravaInteressesDeProfessoresPorDisciplinasEmArquivo(String nomeArquivo)  throws IOException {
					
					BufferedWriter gravador = null;
					
					try{
						gravador = new BufferedWriter(new FileWriter (nomeArquivo));
					
						for (Professor profe: this.professores){
					
							gravador.write(profe.getMatricula()+"\n");
							gravador.write(profe.getTextoPreferenciasDisciplinasComCodigo() +"\n");
						}
					
					}finally {
					
						if(gravador!=null){
					
							gravador.close();
						
						}
					}
			}
			
			public void carregaInteressesDeProfessoresPorDisciplinasDeArquivo(String nomeArquivo) throws PreferenciaInvalidaException,	ProfessorInexistenteException, DisciplinaInexistenteException, IOException {
		
				BufferedReader leitor = null;
				int valor = 1;
			
				try{
			
					leitor = new BufferedReader(new FileReader (nomeArquivo));
					String var = null;
					Professor professor = null;
					List<String> lista = null;
			
					do{
			
						var = leitor.readLine();
			
						if(var != null){
			
							if(valor == 1){
			
								professor = new Professor("", var);
								this.professores.add(professor);

							}else{
			
							String end = leitor.readLine();

								if(end != null){

									lista = this.leListaDeCodigosDeDisciplinasDeLinha(end);

									for(String valuo: lista){

										Disciplina dis = new Disciplina ("", valuo);
										professor.adicionaPreferenciaDisciplina(dis, valor - 1);
									}
								}

							} 
					
							if(valor == 5){
							
								valor = 1;
								
							}
							
							valor ++;
						}
						
					}while(var != null);
			
				}finally {
			
					if(leitor!=null){
			
						leitor.close();
					}
				}
				
			}
		    
		    private List <String> leListaDeCodigosDeDisciplinasDeLinha(String linha){
		   	    List <String> codigos = new LinkedList<String>();
				StringTokenizer tokenizer = new StringTokenizer(linha,":");
				String nivelPreferencia = tokenizer.nextToken();//parte antes dos :
				if (tokenizer.hasMoreTokens()){ // Se tiver algo depois dos :
					String listaCodigos = tokenizer.nextToken(); // parte depois dos :
					System.out.println("listaCodigos:"+listaCodigos);
					StringTokenizer tokenizerVirgula = new StringTokenizer(listaCodigos,",");
					while (tokenizerVirgula.hasMoreTokens()){
						String codigo = tokenizerVirgula.nextToken();
						codigos.add(codigo);
					}
				}
				return codigos;
			} 
		     public List <Professor> obterListaDeProfessores(){  //retorna lista dos professores
		    	    
		            return this.professores;
		    
		    }
		     
		    public List <Disciplina> obterListaDeDisciplinas(){ //retorna a lista de disciplinas
		    
		          return this.disciplinas;
		    }

		    public void carregarProfessoresDeArquivo(String nomeArquivo)throws ProfessorJaExisteException, IOException {  
		        BufferedReader leitor = null;
		        try {
		            leitor = new BufferedReader(new FileReader(nomeArquivo));//BufferedReader a classe que tem metodos para leitura
		            String nomeProf = null;
		            do {
		                nomeProf = leitor.readLine(); // ler a proxima linha do arquivo, nome do professor e guarda na variavel relacionada
		                if (nomeProf != null){
		                    String matriculaProf = leitor.readLine(); //ler a proxima linha do arquivo, matricila do professor
		                    this.cadastraProfessor(nomeProf, matriculaProf);
		                               }
		            } while(nomeProf != null); //vai ser null quando chegar no fim do arquivo
		        } finally {
		            if (leitor!=null){
		                leitor.close();//fecha leitor
		            }
		        }
		    }
		    
		    public void carregarDisciplinasDeArquivo(String nomeArquivo)throws DisciplinaJaExisteException, IOException {
		        BufferedReader leitor = null;
		        try {
		            leitor = new BufferedReader(new FileReader(nomeArquivo));//BufferedReader  a classe que tem metodos para leitura
		            String nomeDisc = null;
		            do {
		                nomeDisc = leitor.readLine(); // ler a proxima linha do arquivo, nome da Disciplina e guarda na variavel relacionada
		                if (nomeDisc!= null){
		                    String codigoDisc = leitor.readLine(); //Ler a proxima linha do arquivo, codigo da disciplina
		                    this.adicionaDisciplina(nomeDisc, codigoDisc);
		                               }
		            } while(nomeDisc != null); //vai ser null quando chegar no fim do arquivo
		        } finally {
		            if (leitor!=null){
		                leitor.close();
		            }
		        }
		    }
		    
		   public void gravarDisciplinasEmArquivo(String nomeArquivo) throws IOException { //gravar em arquivos
		        BufferedWriter gravador = null;
		        try {
		            gravador = new BufferedWriter(new FileWriter(nomeArquivo));// sera gravado em cada linha do arquivo
		            for (Disciplina disciplina: this.disciplinas){//varre alista de disciplinas
		                gravador.write(disciplina.getNome()+"\n");// nome da disciplina
		                gravador.write(disciplina.getCodigo()+"\n");// codigo da disciplina
		            }
		        } finally {
		            if (gravador!=null){
		                gravador.close();
		            }
		        }       
		    }

		   public void gravarProfessoresEmArquivo(String nomeArquivo)throws IOException {
		        BufferedWriter gravador = null;
		        try {
		            gravador = new BufferedWriter(new FileWriter(nomeArquivo));// sera gravado em cada linha do arquivo
		            for (Professor professor: this.professores){ //varre a lista de professoes
		                gravador.write(professor.getNome()+"\n");  //nome do professor
		                gravador.write(professor.getMatricula()+"\n");// matricula do professor
		            }
		        } finally {
		            if (gravador!=null){
		                gravador.close();
		            }
		        }       
		   }

		 
		    public void gravarSalasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException {
		        
		        BufferedWriter gravador = null;
		        
		        try{
		        
		        gravador = new BufferedWriter(new FileWriter(nomeArquivo));// sera gravado em cada linha do arquivo
		    
		        for (Disciplina disciplina: this.disciplinas){//varre as disciplinas
		    
		            gravador.write(disciplina.getCodigo()+"\n"); //Chama o metodo da classe disciplina precisamente o getCodico e grava no arquivo 
		            gravador.write(disciplina.getSalas().size()+"\n");//Chama o metodo da classe disciplina grava a sala
		            
		            for (int k=0; k< disciplina.getSalas().size(); k++){ // lança de repetição para gravar disciplinas nas salas

		                Sala s = disciplina.getSalas().get(k);
		                gravador.write(s.getNumero()+"\n");  
		            }
		        }
		        
		        }finally{
		        
		            if(gravador!=null){
		        
		                gravador.close();
		        
		            }
		        
		        }
		        
		    }

			 public void cadastraNivelDeInteresseDeProfessorPorDisciplina(String matriculaProf,String codDisciplina, int nivelPreferencia)throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException {
             Professor prof = this.pesquisaProfessorPelaMatricula(matriculaProf);
             Disciplina dis = this.pesquisaDisciplina(codDisciplina);

			 }

			 public List <Disciplina> consultaDisciplinasPorPreferenciaPorProfessor(String matriculaProfessor, int nivelPreferencia) throws ProfessorInexistenteException, PreferenciaInvalidaException{
         
             Professor prof = this.pesquisaProfessorPelaMatricula(matriculaProfessor);
             return prof.getDisciplinasPreferidasComNivel(nivelPreferencia);//retorna a lista de disciplinas com nivel de preferÃªncia
     
    }
		
			 public void carregarSalasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException, DisciplinaInexistenteException, SalaJaExisteException {

			        BufferedReader leitor = null ;
			        
			        String sala = null;
			        
			            leitor = new BufferedReader(new FileReader(nomeArquivo));

			            do{
			                
			                String codigoDisciplina = leitor.readLine();
			                Disciplina disci = new Disciplina ("", codigoDisciplina);
			                //String numeroDeSala = leitor.readLine();
			                int num = 0;
			                num = Integer.parseInt(leitor.readLine());
			                
			                for (int k=0; k < num; k++){
			                
			                    sala = leitor.readLine();
			                    int num1 = Integer.parseInt(sala);
			                    disci.adicionaSala(num);
			                    disciplinas.add(disci);
			                }
			                
			            }while(sala != null);
			    }
			    

	
		   
		   
		   
	    
	    
}




