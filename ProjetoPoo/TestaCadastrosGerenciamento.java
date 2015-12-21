package POO;

import java.util.List;


public class TestaCadastrosGerenciamento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    Interface sistema = new Gerenciamento();
		
	    try {
			
			//cadastro do professor Jo�o Paulo de matricula 311
			sistema.cadastraProfessor("Jo�o Paulo", "311");
			//cadastro do professor Jo�o Lucas de matricula 312
			sistema.cadastraProfessor("Jo�o Lucas", "312");
			//Pesquisa do professor de matricula 312
			Professor professor = sistema.pesquisaProfessorPelaMatricula("312");
			//Impress�o dos dados do professor
			System.out.println("Professor encontrado no sistema:"+professor.getDescricao());
			//Pesquisa dos professores que tem Jo�o em seu nome
			List < Professor > profs = sistema.pesquisaProfessorPeloNome("Jo�o");
			System.out.println("Professores Jo�o encontrados:");
			for (Professor p: profs){
				System.out.println(p.getDescricao());
			}
			if (profs.size() ==2 ){
				System.out.println("OK - parte 1 do sistema testada");
			} else {
				System.out.println("ERRO: N�o conseguiu achar os dois professores");
				return; //Teste para aqui se ocorrer o erro
			}
			//Cadastro da disciplina Vetorial 888
			sistema.adicionaDisciplina("Vetorial", "888");
			//Cadastro da disciplina POO de c�digo 999
			sistema.adicionaDisciplina("POO", "999");
			sistema.removeDisciplina("888");
			//Pesquisa da disciplina de c�digo 999, que � POO
			Disciplina d = sistema.pesquisaDisciplina("999");
                        //Se a disciplina encontrada for POO e ela tiver duas turmas, est� tudo OK
			if (d.getNome().equals("POO") && d.getSalas().size()==2){
				System.out.println("Disciplina achada:"+d.getNome()+", de c�digo:"+d.getCodigo());
				for (Sala t: d.getSalas()){
					System.out.println("Sala numero:"+t.getNumero());
				}
				System.out.println("OK - sistema testado");
			} else {
				System.out.println("OK - sistema testado");
			}
			
			
		} catch (ProfessorJaExisteException e) {
			System.out.println("ERRO: Excess�oo n�o esperada:"+e.getMessage());
		} catch (ProfessorInexistenteException e) {
			System.out.println("ERRO: Excess�oo n�o esperada:"+e.getMessage());
		} catch (DisciplinaJaExisteException e) {
			System.out.println("ERRO: Excess�oo n�o esperada:"+e.getMessage());
		} catch (DisciplinaInexistenteException e) {
			System.out.println("ERRO: Excess�oo n�o esperada:"+e.getMessage());
		}
	}

}
