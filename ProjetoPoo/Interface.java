
import java.io.IOException;
import java.util.List;

public interface Interface {
	
	public void cadastraProfessor(String nome, String matricula) throws ProfessorJaExisteException;
	public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException;
	public List<Professor> pesquisaProfessorPeloNome(String nome) throws ProfessorInexistenteException;
	public void adicionaDisciplina(String nome, String codigo) throws DisciplinaJaExisteException;
	public void removeDisciplina(String codigo) throws DisciplinaInexistenteException;
    public Disciplina pesquisaDisciplina(String codigo) throws DisciplinaInexistenteException;
	public void adicionaSala(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException, SalaJaExisteException;
	public void removeSala(String codigoDisciplina, int numSala) throws DisciplinaInexistenteException;
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



}
  