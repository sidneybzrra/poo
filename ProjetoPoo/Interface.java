
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
}
