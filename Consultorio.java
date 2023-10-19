import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Consultorio {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Consulta> consultas;
    private int contPaciente;
    private int telefone;
    private String endereco;
    private String nome;

    public Consultorio(String nome, String endereco, int telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }
    
    // Cadastrar um paciente
    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
    
    //uso de Iterator p/ percorrer e acessar elementos da lista
    //uso do hasNext vai verificar se ainda existem elementos a serem percorridos na lista enquanto itera sobre ela
    //Ele retorna um valor booleano
    
    // Remover um paciente pelo CPF
    public boolean removerPaciente(String cpf) {
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getCpf().equals(cpf)) {
                iterator.remove();
                return true;
            }
        }
        System.out.println("Paciente com CPF " + cpf + " não encontrado.");
        return false;
    }

    // Cadastrar um médico
    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
    }

    // Remover um médico pelo CRM
    public boolean removerMedico(int crm) {
        Iterator<Medico> iterator = medicos.iterator();
        while (iterator.hasNext()) {
            Medico medico = iterator.next();
            if (medico.getCrm() == crm) {
                iterator.remove();
                return true; 
            }
        }
        System.out.println("Médico com CRM " + crm + " não encontrado.");
        return false;
    }

    // Cadastrar uma consulta
    public void cadastrarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    // Remover uma consulta com base no CPF do paciente e no CRM do médico
    public boolean removerConsulta(String cpfPaciente, int crmMedico) {
        Iterator<Consulta> iterator = consultas.iterator();
        while (iterator.hasNext()) {
            Consulta consulta = iterator.next();
            if (consulta.getCpfPaciente().equals(cpfPaciente) && consulta.getCrmMedico() == crmMedico) {
                iterator.remove();
                return true; 
            }
        }
        System.out.println("Consulta não encontrada para o CPF do paciente " + cpfPaciente + " e CRM do médico " + crmMedico + ".");
        return false;
    }

    // Método para imprimir a lista de pacientes
    public void imprimirListaPacientes() {
        for (Paciente paciente : pacientes) {
            paciente.imprimir();
        }
    }

    // Método para imprimir a lista de médicos
    public void imprimirListaMedicos() {
        for (Medico medico : medicos) {
            medico.imprimir();
        }
    }

    // Método para imprimir a lista de consultas
    public void imprimirListaConsultas() {
        for (Consulta consulta : consultas) {
            System.out.println("------IMPRIMINDO------");
            System.out.println("Data: " + consulta.getData());
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("CPF do Paciente: " + consulta.getCpfPaciente());
            System.out.println("CRM do Médico: " + consulta.getCrmMedico());
            System.out.println("----------------------");
        }
    }
    
    
    //função para procurar um médico dentro da lista de médicos do consultório pelo seu número de CRM
    public Medico encontrarMedicoPorCRM(int crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm() == crm) {
                return medico;
            }
        }
        
        return null;
     
    }  
     public Paciente encontrarPacientePorCPF( String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
               return paciente;
            }
        }
        return null;
       
    }

    public Consulta encontrarConsulta(String cpfPaciente, int crmMedico) {
        for (Consulta consulta : consultas) {
            if (consulta.getCpfPaciente().equals(cpfPaciente) && consulta.getCrmMedico() == crmMedico) {
                return consulta;
            }
        }
        return null;
    }
}
