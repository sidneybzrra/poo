
import java.io.IOException;
import java.util.List;

public interface Interface {
	
	public void cadastraProfessor(String nome, String matricula) throws ProfessorJaExisteException;
	public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException;
	public List<Professor> pesquisaProfessorPeloNome(String nome) throws ProfessorInexistenteException;
	public void removeProfessor(String matricula) throws ProfessorInexistenteException;
	public void adicionaDisciplina(String nome, String codigo) throws DisciplinaJaExisteException;
	public void removeDisciplina(String codigo) throws DisciplinaInexistenteException;
	public Disciplina pesquisaDisciplina(String codigo) throws DisciplinaInexistenteException;
	public void adicionaSala(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException, SalaJaExisteException;
	public Sala pesquisaSala(String codigoDisciplina, int numSala)throws DisciplinaInexistenteException, SalaInexistenteException;
	public void removeSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException;
<<<<<<< HEAD
	public List <Professor> obterListaDeProfessores(); 
	public List <Disciplina> obterListaDeDisciplinas();
	public void carregarProfessoresDeArquivo(String nomeArquivo) throws ProfessorJaExisteException, IOException;
	public void carregarDisciplinasDeArquivo(String nomeArquivo) throws DisciplinaJaExisteException, IOException;
	public void gravarProfessoresEmArquivo(String nomeArquivo) throws  IOException;
	public void gravarDisciplinasEmArquivo(String nomeArquivo) throws IOException;
	public void gravarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException;
	public void carregarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException, DisciplinaInexistenteException, TurmaJaExisteException;
	public void imprimeProfessoresEDisciplinas();
    public Sala pesquisaSala(String codDisciplina, int numTurma) throws DisciplinaInexistenteException, TurmaInexistenteException;
	public void cadastraHorarioSala(String codDisciplina, int numTurma, String dia, int horaInicio, int horaFim) throws DisciplinaInexistenteException, TurmaInexistenteException;
	public void alocaProfessorASala(String codDisciplina, int numTurma, String matriculaProf) throws DisciplinaInexistenteException, TurmaInexistenteException, ProfessorInexistenteException;
     //	esse metodo vc deve configurar o professor da turma (turma.setProfessor(...)) e deve também adicionar essa turma 
     //à lista de turmas às quais o professor está alocado (p.alocaTurma(...))
	public void desalocaProfessorDeSala(String codDisciplina, int numTurma, String matriculaProf) throws DisciplinaInexistenteException, TurmaInexistenteException, ProfessorInexistenteException;
     //Lembre de desfazer o que o método aloca faz, inclusive de chamar turma.setProfessor(null).
	public List < Horario > pesquisaHorariosProfessor(String matriculaProf) throws ProfessorInexistenteException;
	public List < Sala > pesquisaTurmasDoProfessor(String matriculaProf) throws ProfessorInexistenteException;
	public List < Disciplina > pesquisaDisciplinasDoProfessor(String matriculaProf) throws ProfessorInexistenteException;
}



=======
	public void adicionaHorarioSala(String  codigoDisciplina, int numSala, String diaDaSemana, int horaInicio, int horaFim) throws DisciplinaInexistenteException, SalaInexistenteException; 
	public void alocaProfessorASala(String codigoDisciplina, int numSala,String matricula) throws DisciplinaInexistenteException,SalaInexistenteException, ProfessorInexistenteException;
	public void desalocaProfessorDaSala(String codigoDisciplina, int numSala,String matricula) throws DisciplinaInexistenteException,SalaInexistenteException, ProfessorInexistenteException;
	public List <Horario> pesquisaHorariosProfessor(String matricula)throws ProfessorInexistenteException;						
	public List <Sala> pesquisaSalasDoProfessor(String matriculaProf)throws ProfessorInexistenteException;
	public List <Disciplina> pesquisaDisciplinasDoProfessor(String matricula)throws ProfessorInexistenteException;
	public void imprimeProfessoresEDisciplinas();
	public void gravaInteressesDeProfessoresPorDisciplinasEmArquivo(String nomeArquivo)  throws IOException;
	public void carregaInteressesDeProfessoresPorDisciplinasDeArquivo(String nomeArquivo) throws PreferenciaInvalidaException,	ProfessorInexistenteException, DisciplinaInexistenteException, IOException ;
	public List <Professor> obterListaDeProfessores();
	public List <Disciplina> obterListaDeDisciplinas();
	public void carregarProfessoresDeArquivo(String nomeArquivo)throws ProfessorJaExisteException, IOException;
	public void carregarDisciplinasDeArquivo(String nomeArquivo)throws DisciplinaJaExisteException, IOException;
	public void gravarDisciplinasEmArquivo(String nomeArquivo) throws IOException; 
	public void gravarProfessoresEmArquivo(String nomeArquivo)throws IOException ;
	public void gravarSalasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException;
	public void cadastraNivelDeInteresseDeProfessorPorDisciplina(String matriculaProf,String codDisciplina, int nivelPreferencia)throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException;
	public List <Disciplina> consultaDisciplinasPorPreferenciaPorProfessor(String matriculaProfessor, int nivelPreferencia) throws ProfessorInexistenteException, PreferenciaInvalidaException;
	public void carregarSalasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException, DisciplinaInexistenteException, SalaJaExisteException;
>>>>>>> fdaf504d8c48c27c33d2635f63ace7c5d6c3626a
}
  
