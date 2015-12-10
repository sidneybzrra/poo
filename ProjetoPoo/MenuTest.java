package POO;

import javax.swing.JOptionPane;

import java.io.IOException;


public class MenuTest {
	public static void main(String args[]) throws ProfessorJaExisteException, ProfessorInexistenteException, DisciplinaJaExisteException, DisciplinaInexistenteException,SalaJaExisteException, HorarioJaExisteException, HorarioInexistenteException, IOException{  {
		Gerenciamento gerenciamento = new Gerenciamento();
		boolean sair = false;
		while (!sair){
		    String opcaoStr = JOptionPane.showInputDialog("Digite uma opçãoo: \n1) CadastraProfessor; \n2) RemoveProfessor;" 
		    		+ "\n3) PesquisaProfessorPeloNome; \n4) PesquisaProfessorPelaMatricula; \n5) AdicionaDisciplina: \n6) RemoveDisciplina: \n7) AdicionaSala:  \n8) RemoveSala:"
		    		+ "\n9) PesquisaDisciplina:  \n10) PesquisaSala: \n11) AdicionaHorarioSala:  \n12) RemoveHorarioSala: \n13) AlocaProfessorASala \n14) DesalocaProfessorDaSala \n15) PesquisaHorarioProfessor \n16) PesquisaSalasDoProfessor"
		    		+ "\n17) PesquisaDisciplinaDoProfessor \n18) ImprimeProfessoresEDisciplinas: \n19) ObterListaDeProfessores: \n20)ObterListaDeDisciplinas: \n21)CarregarProfessoresDeArquivo: \n22)CarregarDisciplinasDeArquivo; \n23)GravarProfessoresEmArquivo: \n24)GravarDisciplinasEmArquivo:"
		    		+ "\n25) GravarSalasDeDisciplinasEmArquivo: \n26)CarregarSalasDeDisciplinasEmArquivo: \n27) Sair"); 
		    int opcao = Integer.parseInt(opcaoStr);
			switch(opcao){
		    	case 1: //CadastraProfessor;
		    		String nomeProf  = (JOptionPane.showInputDialog("Digite o nome do professor: "));
		    		String matriculaProf = (JOptionPane.showInputDialog("Digite a matricula do professor: "));
		    		try{
		    			gerenciamento.cadastraProfessor(nomeProf, matriculaProf);
		    			JOptionPane.showMessageDialog(null,"Professor cadastrado com sucesso! \n"+ "Nome: "+nomeProf +"\n Matricula:" +matriculaProf);
		    		} catch(ProfessorJaExisteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não cadastrado, Erro: " +e.getMessage());
		    		}
		    		
		    		break;
		    	case 2: //RemoveProfessor;
		    		String matriculaProfessor= (JOptionPane.showInputDialog("Digite a matricula do professor: "));
		    		try{
		    			gerenciamento.removeProfessor(matriculaProfessor);
		    			JOptionPane.showMessageDialog(null,"Professor removido com sucesso!");
		    		}catch(ProfessorInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não removido, Erro: "+e.getMessage());
		    		}
		    		break;
		    		
		    	case 3: //PesquisaProfessorPeloNome;
		    		String nomeProfessor = (JOptionPane.showInputDialog("Digite o nome do professor a ser pesquisado: "));
		    		System.out.println(nomeProfessor);
		    		if(gerenciamento.pesquisaProfessorPeloNome(nomeProfessor).size()>0){
		    			JOptionPane.showMessageDialog(null,"Professor encontrado com sucesso! \n" +nomeProfessor);
		    		}else{
		    			JOptionPane.showMessageDialog(null,"Professor não encontrado, não existe professor com esse nome: " +nomeProfessor);
		    		}
		    		break;
		    	case 4: // PesquisaProfessorPelaMatricula;
		    		String matProfessor= (JOptionPane.showInputDialog("Digite a matricula do professor a ser pesquisado: "));
		    		try{
		    			Professor p = gerenciamento.pesquisaProfessorPelaMatricula(matProfessor);
		    			JOptionPane.showMessageDialog(null,"Professor encontrado com sucesso!" +p.getDescricao());
		    		} catch(ProfessorInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não encontrado, Erro: "+e.getMessage());
		    		}
		    		break;
		    	
		    	case 5: //AdicionaDisciplina; 
		    		String nomeDisciplina = (JOptionPane.showInputDialog("Digite o nome da disciplina: "));
		    		String codigoDiscipl = (JOptionPane.showInputDialog("Digite o codigo da disciplina: "));
		    		
		    		try{
		    			gerenciamento.adicionaDisciplina(nomeDisciplina, codigoDiscipl);
		    			JOptionPane.showMessageDialog(null,"Disciplina adicionada com sucesso!\n Disciplina: "
		    			+nomeDisciplina+ " \n Código :  "+codigoDiscipl );
		    			
		    			} catch(DisciplinaJaExisteException e){
		    			JOptionPane.showMessageDialog(null,"Disciplina não adicionada, Erro:" +e.getMessage());
		    			}
		    		break;
		    		
		    	case 6: //RemoveDisciplina;
		    		String codDisciplina = (JOptionPane.showInputDialog("Digite o codidigo da disciplina: "));
		    		try{
		    			gerenciamento.removeDisciplina(codDisciplina);
		    			JOptionPane.showMessageDialog(null,"Disciplina removido com sucesso!");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Disciplina não removido, Erro:"+e.getMessage());		
		    		}
		    		break;
		    	case 7: //AdicionaSala; 
		    		String codigoDisc = (JOptionPane.showInputDialog("Digite o codigo da disciplina para adicionar na Sala: "));
		    		int numSala = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sala: "));
		    		try{
		    			gerenciamento.adicionaSala(codigoDisc, numSala);
		    			JOptionPane.showMessageDialog(null,"Sala adicionada com sucesso!");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Sala não adicionada, Erro:"+e.getMessage());
		    		}catch(SalaJaExisteException e){
		    			JOptionPane.showMessageDialog(null,"Sala não adicionada, Erro:"+e.getMessage());
		    		}
		    		break;
		    	case 8: // RemoveSala;
		    		String codDisc = (JOptionPane.showInputDialog("Digite o codigo da disciplina para remover a Sala: ")); 
		    		int numeroSala = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da Sala a ser removida: "));
		    		try{
		    			gerenciamento.removeSala(codDisc, numeroSala);
		    			JOptionPane.showMessageDialog(null,"Sala removida com sucesso!");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Sala não removida, Erro:"+e.getMessage());
		    		}
		    		break;
		    	case 9: //PesquisaDisciplina;
		    		String codigoDis = (JOptionPane.showInputDialog("Digite o codigo da disciplina a ser pesquisada: "));
		    		try{
		    			Disciplina d = gerenciamento.pesquisaDisciplina(codigoDis);
		    			JOptionPane.showMessageDialog(null,"Disciplina encontrada com sucesso! \n" +d.toString());
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Disciplina não encontrada, Erro:"+e.getMessage());
		    		}
		    		break;
		    		
		    	case 10: //PesquisaSala
		    		String codigoDisciplina1 = JOptionPane.showInputDialog("Digite o código da disciplina para pesquisar a sala: ");
		    		int numeSala = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sala para ser pesquisado: "));
		    		try{
		    		gerenciamento.pesquisaSala(codigoDisciplina1, numeSala);
		    		JOptionPane.showMessageDialog(null,"Sala encontrada com sucesso! ");
    				}catch(DisciplinaInexistenteException e){
    					JOptionPane.showMessageDialog(null, "Sala não encontrada, ERRO: "+e.getMessage());
    				}catch(SalaInexistenteException e){
    					JOptionPane.showMessageDialog(null,"Sala não encontrada, Erro:"+e.getMessage());
    					
    				}
    				break;
		    		
		    		
		    	case 11: // AdicionaHorarioSala:
		    		String codigoDisc1 = (JOptionPane.showInputDialog("Digite o codigo da disciplina para adicionar o horário a Sala: "));
		    		int numSala1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sala para adicionar o horário a sala: "));
		    		String diaDaSemana = JOptionPane.showInputDialog("Digite o dia da semana a ser adicionada: ");
		    		int horaInicio = Integer.parseInt (JOptionPane.showInputDialog("Digite o horário de inicio: "));
		    		int horaFim = Integer.parseInt (JOptionPane.showInputDialog("Digite o horário final: "));
		    		System.out.print("weeo");
		    		try{
		    			gerenciamento.adicionaHorarioSala(codigoDisc1, numSala1 ,diaDaSemana, horaInicio, horaFim);
		    			JOptionPane.showMessageDialog(null," Horário da sala adicionada com sucesso! \n" + "Códico da disciplina: " +codigoDisc1+ "\n Número da sala: " +numSala1+ "\n Dia da Semana: " +diaDaSemana+ "\n Hora inicial: " +horaInicio+ "\n Hora final: " +horaFim);
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Horário da sala não adicionado, Erro:"+e.getMessage());
		    		}catch( SalaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Horário da sala não adicionado, Erro:"+e.getMessage());
		    		}
		    		break;
		 
		    		
		    	
    				
		    	case 12: //RemoveHorarioSala
		    		String codigoDisci = (JOptionPane.showInputDialog("Digite o codigo da disciplina para adicionar o horário a Sala: "));
		    		int numerSala = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sala para adicionar o horário a sala: "));
		    		String nomeDiaDaSemana1= JOptionPane.showInputDialog("Digite o dia da semana a ser adicionada: ");
		    		int horaInicio2 = Integer.parseInt (JOptionPane.showInputDialog("Digite o horário de inicio: "));
		    		int horaFim2 = Integer.parseInt (JOptionPane.showInputDialog("Digite o horário final: "));
		    		try{
		    			gerenciamento.removeHorarioSala(codigoDisci, numerSala, nomeDiaDaSemana1, horaInicio2, horaFim2);
		    			JOptionPane.showMessageDialog(null,"Horario da sala foi removido! ");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Horário da sala não removido, Erro:"+e.getMessage());
		    		}catch( SalaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Horário da sala não removido, Erro:"+e.getMessage());
		    		}
		    		break;
		    		
		    	case 13: //AlocaProfessorASala;
		    		String codigoDiscipl1 = (JOptionPane.showInputDialog("Digite o código da disciplina para alocar o professor da sala: ")); 
		    		int numeroSala1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sala para ser elocada: "));
		    		String matricula1 = (JOptionPane.showInputDialog("Digite a matricula do professor para ele ser alocado em uma sala: "));
		    		try{
		    			gerenciamento.alocaProfessorASala(codigoDiscipl1, numeroSala1, matricula1);
		    			JOptionPane.showMessageDialog(null,"Professor alocado com sucesso!");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não alocado, Erro:"+e.getMessage());
		    		}catch(SalaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não alocado, Erro:"+e.getMessage());
		    		}
		    		break;
		    	case 14: // DesalocaProfessorDaSala;
		    		String codigoDisciplina11 = (JOptionPane.showInputDialog("Digite o código da disciplina para desalocar o professor da sala: ")); 
		    		int numSala11 = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sala para ser desalocada: "));
		    		String matricula2 = (JOptionPane.showInputDialog("Digite a matricula do professor para ele ser desalocado em da sala: "));
		    		try{
		    			gerenciamento.desalocaProfessorDaSala(codigoDisciplina11, numSala11, matricula2);
		    			JOptionPane.showMessageDialog(null,"Porfessor desalocado da sala com sucesso!");
		    		}catch(DisciplinaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não desalocado, Erro:"+e.getMessage());
		    		}catch(SalaInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Professor não desalocado, Erro:"+e.getMessage());
		    		}
		    		break;
    					
		    	case 15: //PesquisaHorariosProfessor;
		    		String matriProfessor = (JOptionPane.showInputDialog("Digite a matricula do professor para pesquisar seus horários: "));
		    		try{
		    			gerenciamento.pesquisaHorariosProfessor(matriProfessor);
		    			JOptionPane.showMessageDialog(null,"Horarios do professor encontrado com sucesso");
		    		}catch(ProfessorInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Horarios do professor não encontrado, Erro:"+e.getMessage());
		    		}
		    		break;
		    	case 16: // PesquisaSalasDoProfessor;
		    		String matricProf = (JOptionPane.showInputDialog("Digite a matricula do professor para pesquisar suas salas: "));
		    		try{
		    			gerenciamento.pesquisaSalasDoProfessor(matricProf);
		    			JOptionPane.showMessageDialog(null,"Salas do professor encontrado com sucesso!");
		    		}catch(ProfessorInexistenteException e){
		    			JOptionPane.showMessageDialog(null," Salas do professor não encontrado, Erro:"+e.getMessage());
		    		}
		    		break;
		    	case 17: //PesquisaDisciplinasDoProfessor;
		    		String matricuProf = (JOptionPane.showInputDialog("Digite a matricula do professor para pesquisar suas disciplinas: "));
		    		try{
		    			gerenciamento.pesquisaDisciplinasDoProfessor(matricuProf);
		    			JOptionPane.showMessageDialog(null,"Disciplinas do professor encontrado com sucesso!");
		    		}catch(ProfessorInexistenteException e){
		    			JOptionPane.showMessageDialog(null,"Disciplinas do professor não encontrado, Erro:"+e.getMessage());
		    		}
		    		break;
    					
		    	case 18: //ImprimeProfessoresEDisciplinas;
		    			gerenciamento.imprimeProfessoresEDisciplinas();
		    			break;
		    	
			    case 19: // ObterListaDeProfessores;
			    		JOptionPane.showMessageDialog(null,gerenciamento.obterListaDeProfessores());
						break;
						
			    case 20: //ObterListaDeDisciplinas;
			    		JOptionPane.showMessageDialog(null,gerenciamento.obterListaDeDisciplinas());
						break;
			    case 21: //CarregarProfessoresDeArquivo;
			    		String nomeArquivo = JOptionPane.showInputDialog("Digite o Nome do arquivo para carregar o professor: ");
			    		try{
			    			gerenciamento.carregarProfessoresDeArquivo(nomeArquivo);
			    			JOptionPane.showMessageDialog(null,"Professores Carregados com sucesso!");
			    		}catch(ProfessorJaExisteException e){
			    			JOptionPane.showMessageDialog(null,"Professores não carregados, Erro:"+e.getMessage());
			    		}
						break;
			    case 22: //CarregarDisciplinasDeArquivo;
			    		String nomeArq = JOptionPane.showInputDialog("Digite o Nome do arquivo para carregar a disciplina: ");
			    		try{
			    			gerenciamento.carregarDisciplinasDeArquivo(nomeArq);
			    			JOptionPane.showMessageDialog(null,"Disciplinas carregadas com sucesso!");
			    		}catch(DisciplinaJaExisteException e){
			    			JOptionPane.showMessageDialog(null,"Disciplinas não carregadas, Erro:"+e.getMessage());
			    		}
			    		break;
			    case 23: //GravarProfessoresEmArquivo;
			    		String arquivoProf= JOptionPane.showInputDialog("Digite o Nome do arquivo pra gravar professor: ");
			    		try{
			    			gerenciamento.gravarProfessoresEmArquivo(arquivoProf);
			    			JOptionPane.showMessageDialog(null,"Professores gravados com sucesso!");
			    		}catch(IOException e){
			    			JOptionPane.showMessageDialog(null,"Professores não gravados, Erro:"+e.getMessage());
			    		}
						break;
			    case 24: //GravarDisciplinasEmArquivo;
			    		String arquivoDisc= JOptionPane.showInputDialog("Digite o Nome do arquivo pra gravar disciplina: ");
			    		try{
			    			gerenciamento.gravarDisciplinasEmArquivo(arquivoDisc);
			    			JOptionPane.showMessageDialog(null,"Disciplinas gravadas com sucesso!");
			    		}catch(IOException e){
			    			JOptionPane.showMessageDialog(null,"Disciplinas não gravadas, Erro:"+e.getMessage());
			    		}
						break;
			    case 25: // GravarSalasDeDisciplinasEmArquivo;
			    		String arquivoSalasDisc= JOptionPane.showInputDialog("Digite o Nome do arquivo pra gravar salas de disciplinas: ");
			    		try{
			    			gerenciamento.gravarSalasDeDisciplinasEmArquivo(arquivoSalasDisc);;
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas gravadas com sucesso!");
			    		}catch(IOException e){
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas não gravadas, Erro:"+e.getMessage());
			    		}
						break;
			    	
			    case 26: //CarregarSalasDeDisciplinasEmArquivo;
			    		String arquivoSalasDisciplinas= JOptionPane.showInputDialog("Digite o Nome do arquivo pra carregar salas de disciplinas: ");
			    		try{
			    			gerenciamento.carregarSalasDeDisciplinasEmArquivo(arquivoSalasDisciplinas);
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas carregadas com sucesso!");
			    		}catch(IOException e){
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas não carregadas, Erro:"+e.getMessage());
			    		}catch(DisciplinaInexistenteException e){
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas não carregada,Erro:"+e.getMessage());
			    		}catch(SalaJaExisteException e){
			    			JOptionPane.showMessageDialog(null,"Salas de disciplinas não carregada,Erro:"+e.getMessage());
			    		}
						break;
    				
		    		
		    	case 27: //Sair;
		    		 sair = true;
					    JOptionPane.showMessageDialog(null, "Programa Gerenciamento de Salas terminado. Até mais");

					    break;
					default:
				            JOptionPane.showMessageDialog(null, "Opção digitada invalida: \n"+opcao);

		    
		    		
		    }
	    }
	}
 }
}

