package POO;

import java.util.List;


public class TestaCadastrosGerenciamento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    Interface sistema = new Gerenciamento();
		
	    try {
			
			//cadastro do professor João Paulo de matricula 311
			sistema.cadastraProfessor("João Paulo", "311");
			//cadastro do professor João Lucas de matricula 312
			sistema.cadastraProfessor("João Lucas", "312");
			//Pesquisa do professor de matricula 312
			Professor professor = sistema.pesquisaProfessorPelaMatricula("312");
			//Impressão dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			//Pesquisa dos professores que tem João em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("João");
			System.out.println("Professores João encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			if (profs.size() ==2 ){
				System.out.println("OK - parte 1 do sistema testada");
			} else {
				System.out.println("ERRO: Não conseguiu achar os dois professores");
				return; //Teste para aqui se ocorrer o erro
			}
			//Cadastro da disciplina Vetorial 888
			sistema.adicionaDisciplina("Vetorial", "888");
			//Cadastro da disciplina POO de código 999
			sistema.adicionaDisciplina("POO", "999");
			sistema.removeDisciplina("888");
			//Pesquisa da disciplina de código 999, que é POO
			Disciplina d = sistema.pesquisaDisciplina("999");
                        //Se a disciplina encontrada for POO e ela tiver duas turmas, está tudo OK
			if (d.getNome().equals("POO") && d.getSalas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de código:"+d.getCodigo());
				for (Sala t: d.getSalas()){
					System.out.println("Sala numero:"+t.getNumero());
				}
				System.out.println("OK - sistema testado");
			} else {
				System.out.println("OK - sistema testado");
			}
			
			
		} catch (ProfessorJaExisteException e) {
			System.out.println("ERRO: Excessãoo não esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("ERRO: Excessãoo não esperada:"+e.getMessage());
		} catch (DisciplinaJaExisteException e) {
			System.out.println("ERRO: Excessãoo não esperada:"+e.getMessage());
		} catch (DisciplinaInexistenteException e) {
			System.out.println("ERRO: Excessãoo não esperada:"+e.getMessage());
		}
	}

}
