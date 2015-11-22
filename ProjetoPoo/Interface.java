
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

}
