import easyaccept.EasyAccept;

/**
 * Facade é a classe que comunica o back-end para o front-end. tem todos os
 * métodos dos controladores e não guarda lógica nos métodos.
 * 
 * @author erick Araken - 119210561
 *
 */
public class Facade {
	private ControllerCentral saga;

	/**
	 * Construtor da classe Facade.
	 */
	public Facade() {
		this.saga = new ControllerCentral();
	}

	public static void main(String[] args) {

		args = new String[] { "Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt" };
		EasyAccept.main(args);
		/*
		 * Facade f = new Facade(); //.out.println(f.adicionaFornecedor("Seu Olavo",
		 * "quiosque@gmail.com", "83 98736-5050")); f.adicionaProduto("Seu Olavo",
		 * "Tapioca com frango", "Tapioca com queijo, manteiga e frango", 5.00);
		 * f.adicionaFornecedor("Marcos", "quiosque@gmail.com", "83 98736-5050");
		 * f.adicionaProduto("Seu Olavo", "Acai", "Acai de 300mL", 5.00);
		 * //System.out.println(f.exibeProdutosFornecedor("Seu Olavo"));
		 * f.adicionaCompra("19418510068", "Marcos", "08/11/2018", "Coxao com batata",
		 * "Coxao de frango com batata frita");
		 */
	}

	/**
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return saga.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */

	public String exibeCliente(String cpf) {
		return saga.exibeCliente(cpf);
	}

	/**
	 * 
	 * @return
	 */

	public String exibeClientes() {
		return this.saga.exibeClientes();
	}

	/**
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */

	public void editaCliente(String cpf, String atributo, String novoValor) {
		saga.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * 
	 * @param cpf
	 */

	public void removeCliente(String cpf) {
		this.saga.removeCliente(cpf);
	}

	/**
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return
	 */

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.saga.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		return saga.exibeFornecedor(nome);
	}

	/**
	 * 
	 * @return
	 */

	public String exibeFornecedores() {
		return this.saga.exibeFornecedores();

	}

	/**
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.saga.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * 
	 * @param nome
	 */

	public void removeFornecedor(String nome) {
		this.saga.removeFornecedor(nome);
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param preco
	 */

	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.saga.adicionaProduto(fornecedor, nome, descricao, preco);
	}

	/**
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 * @return
	 */

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.saga.exibeProduto(nome, descricao, fornecedor);
	}

	/**
	 * 
	 * @return
	 */

	public String exibeProdutos() {
		return this.saga.exibeProdutos();
	}

	/**
	 * 
	 * @param fornecedor
	 * @return
	 */

	public String exibeProdutosFornecedor(String fornecedor) {
		return this.saga.exibeProdutosFornecedor(fornecedor);

	}

	/**
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 * @param novoPreco
	 */

	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.saga.editaProduto(nome, descricao, fornecedor, novoPreco);
	}

	/**
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 */

	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.saga.removeProduto(nome, descricao, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @param data
	 * @param nome
	 * @param descricao
	 */

	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		this.saga.adicionaCompra(cpf, fornecedor, data, nome, descricao);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */

	public String getDebito(String cpf, String fornecedor) {
		return this.saga.getDebito(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */

	public String exibeContas(String cpf, String fornecedor) {
		return this.saga.exibeContas(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */

	public String exibeContasClientes(String cpf) {
		return this.saga.exibeContasClientes(cpf);
	}

	/**
	 * 
	 * @param criterio
	 */

	public void ordenaPor(String criterio) {
		this.saga.ordenaPor(criterio);
	}

	/**
	 * 
	 * @return
	 */

	public String listarCompras() {
		return this.saga.listarCompras();
	}

}
