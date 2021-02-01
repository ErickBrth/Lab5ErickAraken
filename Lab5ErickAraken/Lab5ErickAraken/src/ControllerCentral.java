/**
 * Controller central administra todos os mpetodos do sistema Saga, através de
 * FornecedorController e Cliente Controller.
 * 
 * @author erick Araken - 119210561
 *
 */
public class ControllerCentral {
	private ClienteController clienteController;
	private FornecedorController fornecedorController;
	private String criterio;

	/**
	 * Construtor de ControllerCentral.
	 */
	public ControllerCentral() {
		this.clienteController = new ClienteController();
		this.fornecedorController = new FornecedorController();
		this.criterio = "";
	}

	/**
	 * Adiciona um cliente em um repositório de Clientes.
	 * 
	 * @param cpf         String Cpf do cliente.
	 * @param nome        String nome do cliente.
	 * @param email       String email.
	 * @param localizacao String localizacao do cliente.
	 * @return uma String com nome do cliente.
	 */

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return clienteController.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * Exibe um Cliente do repositor.
	 * 
	 * @param cpf String cpf do fornecedor
	 * @return
	 */

	public String exibeCliente(String cpf) {
		return clienteController.exibeCliente(cpf);

	}

	/**
	 * Exibe todos os clientes.
	 * 
	 * @return String com todos os clientes.
	 */
	public String exibeClientes() {
		return this.clienteController.exibeClientes();
	}

	/**
	 * Edita um cliente ja cadastrado.
	 * 
	 * @param cpf       String Cpf do cliente.
	 * @param atributo  String atributo que sera editado.
	 * @param novoValor String novoValor informa qual sera o atributo editado.
	 */

	public void editaCliente(String cpf, String atributo, String novoValor) {
		clienteController.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Remove um Cliente do repositório.
	 * 
	 * @param cpf String Cpf do cliente.
	 */

	public void removeCliente(String cpf) {
		this.clienteController.removeCliente(cpf);
	}

	/**
	 * Adiciona um fornecedor ao repositorio.
	 * 
	 * @param nome     String nome do cliente.
	 * @param email    String email do cliente
	 * @param telefone String telefone do cliente
	 * @return String com o nome do fornecedor.
	 */

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedorController.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * exibe um fornecedor através de seu nome.
	 * 
	 * @param nome String nome do fornecedor.
	 * @return String com a representação textual do fornecedor.
	 */

	public String exibeFornecedor(String nome) {
		return this.fornecedorController.exibeFornecedor(nome);
	}

	/**
	 * Exibe todos os fornecedores.
	 * 
	 * @return String com todos os fornecedores.
	 */

	public String exibeFornecedores() {
		return this.fornecedorController.exibeFornecedores();
	}

	/**
	 * Edita um Fornecedor.
	 * 
	 * @param cpf       String Cpf do cliente.
	 * @param atributo  String atributo que sera editado.
	 * @param novoValor String novoValor informa qual sera o atributo editado.
	 */

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedorController.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * Remove um fornecedor através de seu nome como identificação.
	 * 
	 * @param nome String com nome do fornecedor.
	 */

	public void removeFornecedor(String nome) {
		this.fornecedorController.removeFornecedor(nome);
	}

	/**
	 * adiciona um produto para o fornecedor.
	 * 
	 * @param fornecedor String com fornecedor do produto.
	 * @param nome       String com o nome do produto.
	 * @param descricao  String com a descricao do produto.
	 * @param preco      double com o preco do produto.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.fornecedorController.adicionaProduto(fornecedor, nome, descricao, preco);
	}

	/**
	 * Exibe um produto por meio do seu nome, descricao e fornecedor.
	 * 
	 * @param nome       String nome do produto.
	 * @param descricao  String descricao do produto.
	 * @param fornecedor String fornecedor do produto.
	 * @return String com a representação textual do produto.
	 */

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedorController.exibeProduto(nome, descricao, fornecedor);
	}

	/**
	 * Exibe todos os produtos do fornecedor.
	 * 
	 * @return String da representação textual de todos os produtos.
	 */
	public String exibeProdutos() {
		return this.fornecedorController.exibeProdutos();
	}

	/**
	 * Exibe todos os produtos de um fornecedor.
	 * 
	 * @param fornecedor String com um fornecedor.
	 * @return String com todos os produtos de um fornecedor
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fornecedorController.exibeProdutosFornecedor(fornecedor);
	}

	/**
	 * Edita um produto a partir do nome, descricao, fornecedor e novoPreco.
	 * 
	 * @param nome       String Nome do produto.
	 * @param descricao  String descricao do produto.
	 * @param fornecedor String Fornedor do produto.
	 * @param novoPreco  double com o Novo preço do produto.
	 */

	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.fornecedorController.editaProduto(nome, descricao, fornecedor, novoPreco);
	}

	/**
	 * remove um produto através de seu nome, descricao e fornecedor.
	 * 
	 * @param nome       String nome do Produto.
	 * @param descricao  String descrição do Produto.
	 * @param fornecedor String com o fornecedor do Produto.
	 */

	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fornecedorController.removeProduto(nome, descricao, fornecedor);
	}

	/**
	 * Adiciona uma Compra.
	 * 
	 * @param cpf        String Com cpf do cliente.
	 * @param fornecedor String com Fornecedor.
	 * @param data       String Data da compra.
	 * @param nome       String com nome da compra.
	 * @param descricao  String com descrição do produto.
	 */

	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}

		if (data == null || data.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}

		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.fornecedorController.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}

		if (!this.fornecedorController.verificaProduto(nome, descricao, fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}

		if (!this.clienteController.verificaCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}

		double preco = this.fornecedorController.getPrecoProduto(fornecedor, nome + descricao);

		this.clienteController.adicionaCompra(cpf, fornecedor, data, nome, descricao, preco);
	}

	/**
	 * Pega o débito do cliente com um fornecedor.
	 * 
	 * @param cpf        String com cpf do cliente.
	 * @param fornecedor String com fornecedor.
	 * @return double com Débito do cliente.
	 */
	public String getDebito(String cpf, String fornecedor) {

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}

		if (!this.clienteController.verificaCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.fornecedorController.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}

		if (!this.clienteController.verificaDebito(cpf, fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}

		return this.clienteController.getDebito(cpf, fornecedor);
	}

	/**
	 * Exibe as contas do cliente com fornecedor.
	 * 
	 * @param cpf        String com cpf do cliente.
	 * @param fornecedor String fornecedor
	 * @return String representação textual das contas do cliente.
	 */

	public String exibeContas(String cpf, String fornecedor) {

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.fornecedorController.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}

		if (!this.clienteController.verificaCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}

		if (!this.clienteController.verificaConta(cpf, fornecedor)) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}

		return this.clienteController.exibeContas(cpf, fornecedor);
	}

	/**
	 * Exibe todas as Contas do Cliente.
	 * 
	 * @param cpf String Cpf do Cliente
	 * @return String Com todas as contas do cliente
	 */

	public String exibeContasClientes(String cpf) {

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}

		if (!this.clienteController.verificaCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}

		if (this.clienteController.verificaConta(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}

		return this.clienteController.exibeContasClientes(cpf);
	}

	/**
	 * Ordena a listagem de compras do cliente.
	 * 
	 * @param criterio String com o criterio de ordenação.
	 */
	public void ordenaPor(String criterio) {

		if (criterio == null || criterio.trim().equals("")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		}

		if (!criterio.equals("Cliente") && !criterio.equals("Data") && !criterio.equals("Fornecedor")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}

		this.criterio = criterio;
	}

	/**
	 * lista todas as Compras.
	 * 
	 * @return String com todas as compras.
	 */

	public String listarCompras() {

		if (this.criterio.equals("Data")) {
			return this.clienteController.ordenaPorData();
		}

		if (this.criterio.equals("Fornecedor")) {
			return this.clienteController.ordenaPorFornecedor();
		}

		if (this.criterio.equals("Cliente")) {
			return this.clienteController.ordenaPorCliente();
		} else {
			throw new IllegalArgumentException(
					"Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}

	}

}
