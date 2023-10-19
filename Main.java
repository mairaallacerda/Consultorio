import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consultorio consultorio = new Consultorio("Meu Consultório", "Rua Afrânio Peixoto", 2211);

        int escolha;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Cadastrar Paciente");
            System.out.println("3 - Cadastrar Consulta");
            System.out.println("4 - Imprimir Dados do Médico");
            System.out.println("5 - Imprimir Consultas");
            System.out.println("6 - Imprimir Dados do Paciente");
            System.out.println("7 - Imprimir Dados de Consulta Específica");
            System.out.println("9 - Remover Médico");
            System.out.println("10 - Remover Paciente");
            System.out.println("11 - Remover Consulta");
            System.out.println("12 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (escolha) {
                case 1:
                    System.out.print("Nome do Médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Sexo do Médico: ");
                    char sexoMedico = scanner.next().charAt(0);
                    scanner.nextLine(); 
                    System.out.print("Endereço do Médico: ");
                    String enderecoMedico = scanner.nextLine();
                    System.out.print("CPF do Médico: ");
                    String cpfMedico = scanner.nextLine();
                    System.out.print("Telefone do Médico: ");
                    String telefoneMedico = scanner.nextLine();
                    System.out.print("Identidade do Médico: ");
                    String identidadeMedico = scanner.nextLine();
                    System.out.print("CRM do Médico: ");
                    int crmMedico = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Especialidade do Médico: ");
                    String especialidadeMedico = scanner.nextLine();

                    Medico medico = new Medico(nomeMedico, sexoMedico, enderecoMedico, cpfMedico, telefoneMedico, identidadeMedico, crmMedico, especialidadeMedico);
                    consultorio.cadastrarMedico(medico);
                    System.out.println("Médico cadastrado com sucesso.");
                    break;

                case 2:
                    System.out.print("Nome do Paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("Sexo do Paciente: ");
                    char sexoPaciente = scanner.next().charAt(0);
                    scanner.nextLine();
                    System.out.print("Endereço do Paciente: ");
                    String enderecoPaciente = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    System.out.print("Telefone do Paciente: ");
                    String telefonePaciente = scanner.nextLine();
                    System.out.print("Identidade do Paciente: ");
                    String identidadePaciente = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Relato do Paciente: ");
                    String relatoPaciente = scanner.nextLine();
                    System.out.print("Medicação Consumida Regularmente pelo Paciente: ");
                    String medicacaoPaciente = scanner.nextLine();

                    Paciente paciente = new Paciente(nomePaciente, sexoPaciente, enderecoPaciente, cpfPaciente, telefonePaciente, identidadePaciente, relatoPaciente, medicacaoPaciente);
                    consultorio.cadastrarPaciente(paciente);
                    System.out.println("Paciente cadastrado com sucesso.");
                    break;

                case 3:
                    System.out.print("Data da Consulta: ");
                    String dataConsulta = scanner.nextLine();
                    System.out.print("Hora da Consulta: ");
                    String horaConsulta = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String cpfConsulta = scanner.nextLine();
                    System.out.print("CRM do Médico: ");
                    int crmConsulta = scanner.nextInt();
                    scanner.nextLine();

                    Consulta consulta = new Consulta(dataConsulta, horaConsulta, cpfConsulta, crmConsulta);
                    consultorio.cadastrarConsulta(consulta);
                    System.out.println("Consulta cadastrada com sucesso.");
                    break;

                case 4:
                    System.out.print("Digite o CRM do Médico: ");
                    int crmMedicoImprimir = scanner.nextInt();
                    scanner.nextLine();
                    Medico medicoParaImprimir = consultorio.encontrarMedicoPorCRM(crmMedicoImprimir);
                    if (medicoParaImprimir != null) {
                        medicoParaImprimir.imprimir();
                    } else {
                        System.out.println("Médico com CRM " + crmMedicoImprimir + " não encontrado.");
                    }
                    break;

                case 5:
                    consultorio.imprimirListaConsultas();
                    break;

                case 6:
                    System.out.print("Digite o CPF do Paciente: ");
                    String cpfPacienteImprimir = scanner.nextLine();
                    Paciente pacienteParaImprimir = consultorio.encontrarPacientePorCPF(cpfPacienteImprimir);
                    if (pacienteParaImprimir != null) {
                        pacienteParaImprimir.imprimir();
                    } else {
                        System.out.println("Paciente com CPF " + cpfPacienteImprimir + " não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o CPF do Paciente da Consulta: ");
                    String cpfConsultaEspecifica = scanner.nextLine();
                    System.out.print("Digite o CRM do Médico da Consulta: ");
                    int crmConsultaEspecifica = scanner.nextInt();
                    scanner.nextLine();
                    Consulta consultaEspecifica = consultorio.encontrarConsulta(cpfConsultaEspecifica, crmConsultaEspecifica);
                    if (consultaEspecifica != null) {
                        System.out.println("Dados da Consulta:");
                        System.out.println("Data: " + consultaEspecifica.getData());
                        System.out.println("Hora: " + consultaEspecifica.getHora());
                        System.out.println("CPF do Paciente: " + consultaEspecifica.getCpfPaciente());
                        System.out.println("CRM do Médico: " + consultaEspecifica.getCrmMedico());
                    } else {
                        System.out.println("Consulta não encontrada para o CPF do paciente " + cpfConsultaEspecifica + " e CRM do médico " + crmConsultaEspecifica + ".");
                    }
                    break;

                case 9:
                    System.out.print("Digite o CRM do Médico a ser removido: ");
                    int crmMedicoRemover = scanner.nextInt();
                    scanner.nextLine();
                    boolean removidoMedico = consultorio.removerMedico(crmMedicoRemover);
                    if (removidoMedico) {
                        System.out.println("Médico removido com sucesso.");
                    } else {
                        System.out.println("Médico com CRM " + crmMedicoRemover + " não encontrado.");
                    }
                    break;

                case 10:
                    System.out.print("Digite o CPF do Paciente a ser removido: ");
                    String cpfPacienteRemover = scanner.nextLine();
                    boolean removidoPaciente = consultorio.removerPaciente(cpfPacienteRemover);
                    if (removidoPaciente) {
                        System.out.println("Paciente removido com sucesso.");
                    } else {
                        System.out.println("Paciente com CPF " + cpfPacienteRemover + " não encontrado.");
                    }
                    break;

                case 11:
                    System.out.print("Digite o CPF do Paciente da Consulta a ser removida: ");
                    String cpfConsultaRemover = scanner.nextLine();
                    System.out.print("Digite o CRM do Médico da Consulta a ser removida: ");
                    int crmConsultaRemover = scanner.nextInt();
                    scanner.nextLine();
                    boolean removidaConsulta = consultorio.removerConsulta(cpfConsultaRemover, crmConsultaRemover);
                    if (removidaConsulta) {
                        System.out.println("Consulta removida com sucesso.");
                    } else {
                        System.out.println("Consulta não encontrada para o CPF do paciente " + cpfConsultaRemover + " e CRM do médico " + crmConsultaRemover + ".");
                    }
                    break;

                case 12:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 12);

        scanner.close();
    }

// //função para procurar um médico dentro da lista de médicos do consultório pelo seu número de CRM
//     private static Medico encontrarMedicoPorCRM(Consultorio consultorio, int crm) {
//         for (Medico medico : consultorio.getMedicos()) {
//             if (medico.getCrm() == crm) {
//                 return medico;
//             }
//         }
//         return null;
//     }

//     private static Paciente encontrarPacientePorCPF(Consultorio consultorio, String cpf) {
//         for (Paciente paciente : consultorio.getPacientes()) {
//             if (paciente.getCpf().equals(cpf)) {
//                 return paciente;
//             }
//         }
//         return null;
//     }

//     private static Consulta encontrarConsulta(Consultorio consultorio, String cpfPaciente, int crmMedico) {
//         for (Consulta consulta : consultorio.getConsultas()) {
//             if (consulta.getCpfPaciente().equals(cpfPaciente) && consulta.getCrmMedico() == crmMedico) {
//                 return consulta;
//             }
//         }
//         return null;
//     }
}