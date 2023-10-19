public class Paciente extends Pessoa {
	    private String relato;
	    private String medicacaoConsumidaRegularmente;

//	    Construtor
	    public Paciente(String nome, char sexo, String endereco, String cpf, String telefone, String identidade, String relato, String medicacaoConsumidaRegularmente) {
	        super(nome, sexo, endereco, cpf, telefone, identidade);
	        this.relato = relato;
	        this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
	    }

	    // Getters e Setters
	    
	    public String getRelato() {
	        return relato;
	    }

	    public void setRelato(String relato) {
	        this.relato = relato;
	    }

	    public String getMedicacaoConsumidaRegularmente() {
	        return medicacaoConsumidaRegularmente;
	    }

	    public void setMedicacaoConsumidaRegularmente(String medicacaoConsumidaRegularmente) {
	        this.medicacaoConsumidaRegularmente = medicacaoConsumidaRegularmente;
	    }

	    // Sobrescrever o método imprimir
	    
	    @Override
	    public void imprimir() {
	        super.imprimir();
	        System.out.println("Relato: " + relato);
	        System.out.println("Medicação Consumida Regularmente: " + medicacaoConsumidaRegularmente);
	    }
	}