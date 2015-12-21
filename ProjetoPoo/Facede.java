package POO;

import java.io.IOException;
import java.util.List;


	public class Facede  {
		
		protected Gerenciamento sistema;
		
		
			public void InicializarSubsistemas (){
				sistema = new Gerenciamento();
				
			}

			
		 // Metodos do professor
			public void cadastraProfessor(String nome, String matricula) throws ProfessorJaExisteException{
				sistema.cadastraProfessor(nome,matricula);
					
			}
			
			public List<Professor> pesquisaProfessroPeloNome(String nome) throws ProfessorInexistenteException{
				return sistema.pesquisaProfessorPeloNome(nome);
				
			}
			
			public Professor pesquisaProfessroPelaMatricula(String matricula) throws ProfessorInexistenteException{
				return sistema.pesquisaProfessorPelaMatricula(matricula);
			}
			
			public void removeProfessor(String matricula) throws ProfessorInexistenteException{
				sistema.removeProfessor(matricula);
			}
			
			public void imprimeProfessoresEDisciplinas() {
				sistema.imprimeProfessoresEDisciplinas();
			}
			
			 public List <Professor> obterListaDeProfessores(){ 
				 return sistema.obterListaDeProfessores();
			 }

			//Metodos da disciplina
			public void adicionaDisciplina(String nomeDisciplina, String codigoDisciplina) throws DisciplinaJaExisteException{
				sistema.adicionaDisciplina(nomeDisciplina, codigoDisciplina);
			}
			
			public Disciplina pesquisaDisciplina(String codigoDisciplina) throws DisciplinaInexistenteException{
				return sistema.pesquisaDisciplina(codigoDisciplina);
			}
			
			public void removeDisciplina(String codigo) throws DisciplinaInexistenteException{
				sistema.removeDisciplina(codigo);
			}
			 public List <Disciplina> obterListaDeDisciplinas(){ 
				 return sistema.obterListaDeDisciplinas();
			 }
			 
			
			//Metodos da sala
			public void adicionaSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException, SalaJaExisteException{
				sistema.adicionaSala(codigoDisciplina, numSala);
			}
			public Sala pesquisaSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException, SalaInexistenteException{
				return sistema.pesquisaSala(codigoDisciplina, numSala);
			}
			
			public void removeSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException{
				sistema.removeSala(codigoDisciplina, numSala);
				
			}
			
			public void alocaProfessorASala(String codigoDisciplina, int numSala, String matricula) throws DisciplinaInexistenteException, SalaInexistenteException, ProfessorInexistenteException{
				sistema.alocaProfessorASala(codigoDisciplina, numSala, matricula);
			}
			
			public  void desalocaProfessorDaSala(String codigoDisciplina, int numSala,String matricula) throws DisciplinaInexistenteException,SalaInexistenteException, ProfessorInexistenteException {
				sistema.desalocaProfessorDaSala(codigoDisciplina, numSala, matricula);
			}
			
			public List <Sala> pesquisaSalasDoProfessor(String matriculaProf)throws ProfessorInexistenteException {
				return sistema.pesquisaSalasDoProfessor(matriculaProf);
			}
			
			public List <Disciplina> pesquisaDisciplinasDoProfessor(String matricula)throws ProfessorInexistenteException {
				return sistema.pesquisaDisciplinasDoProfessor(matricula);
			}
			
			//Metodos do horario
			public void adicionaHorarioSala(String codigoDisciplina, int numSala, String diaDaSemana, int horaInicio, int horaFim) throws DisciplinaInexistenteException, SalaInexistenteException{
				sistema.adicionaHorarioSala(codigoDisciplina, numSala, diaDaSemana, horaInicio, horaFim);
			}
			
			public List<Horario> pesquisaHorariosProfessor(String matricula) throws ProfessorInexistenteException{
				return sistema.pesquisaHorariosProfessor(matricula);
			}
			
			
			public void carregarProfessoresDeArquivos(String nomeArquivo) throws ProfessorJaExisteException, IOException{
				sistema.carregarProfessoresDeArquivo(nomeArquivo);
			}
		
			public void gravarDisciplinasEmArquivos(String nomeArquivo) throws IOException{
				sistema.gravarDisciplinasEmArquivo(nomeArquivo);
			}
			
			public void gravarProfessoresEmArquivos(String nomeArquivo) throws IOException{
				sistema.gravarProfessoresEmArquivo(nomeArquivo);
			}
			
			public void gravarSalasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException{
				sistema.gravarSalasDeDisciplinasEmArquivo(nomeArquivo);
			}
			
			public void carregarSalasDeDisciplinasEmArquivos(String nomeArquivo) throws IOException, DisciplinaInexistenteException, SalaJaExisteException{
				sistema.carregarSalasDeDisciplinasEmArquivo(nomeArquivo);
			}
	}