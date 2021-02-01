import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Controla e gerencia os fornecedores e suas estruturas de dados.
 * 
 *	
 *
 */
public class FornecedorController {
	private HashMap<String, Fornecedor> fornecedorRepositorio;

	/**
	 * Construtor de FornecedorController.
	 */
	public FornecedorController() {
		this.fornecedorRepositorio = new HashMap<>();

	}

	/**
	 * adciona um fornecedor em um repositório.
	 * 
	 * @param nome     String nome fornecedor.
	 * @param email    String email do fornecedor.
	 * @param telefone String telefone.
	 * @return String com o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}

		if (telefone == null || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}

		if (this.fornecedorRepositorio.containsKey(nome.trim()) == true) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		this.fornecedorRepositorio.put(nome, new Fornecedor(nome, email, telefone));
		return this.fornecedorRepositorio.get(nome).getNome();

	}

	/**
	 * Adiciona um produto para um fornecedor.
	 * 
	 * @param fornecedor String fornecedor.
	 * @param nome       String nome.
	 * @param descricao  String descricao.
	 * @param preco      double preco.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}

		if (this.fornecedorRepositorio.get(fornecedor).verificarProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}

		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		this.fornecedorRepositorio.get(fornecedor).adicionaProduto(nome, descricao, preco);
	}

	/**
	 * Retorna o preço de um produto.
	 * 
	 * @param nomeFornecedor String com o nme do fornecedor.
	 * @param idProduto      String id do produto.
	 * @return double com o preço do produto.
	 */
	public double getPrecoProduto(String nomeFornecedor, String idProduto) {
		return this.fornecedorRepositorio.get(nomeFornecedor).getPrecoProduto(idProduto);
	}

	/**
	 * Verifica se o fornecedor existe.
	 * 
	 * @param fornecedor String com o fornecedor.
	 * @return boolean true se fornecedor existir e false caso contrário.
	 */
	public boolean verificarFornecedor(String fornecedor) {
		return this.fornecedorRepositorio.containsKey(fornecedor);
	}

	/**
	 * Exibe um produto.
	 * 
	 * @param nome       String nome do produto.
	 * @param descricao  String descrição do produto.
	 * @param fornecedor String nome do fornecedor.
	 * @return String com a representação textual do produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (this.fornecedorRepositorio.get(fornecedor).verificarProduto(nome, descricao) == false) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

		return this.fornecedorRepositorio.get(fornecedor).exibeProduto(nome, descricao, fornecedor);
	}

	/**
	 * edita um produto.
	 * 
	 * @param nome       Stirng nome do produto.
	 * @param descricao  String descricao do produto.
	 * @param fornecedor String fornecedor do produto.
	 * @param novoPreco  String com novo preço.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}

		if (!this.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}

		if (!this.fornecedorRepositorio.get(fornecedor).verificarProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}

		this.fornecedorRepositorio.get(fornecedor).setPrecoProduto(nome, descricao, novoPreco);
	}

	/**
	 * remove um produto identificado pelo seu nome e descrição.
	 * 
	 * @param nome       String nome do produto.
	 * @param descricao  String descricao do produto.
	 * @param fornecedor String fornecedor do produto.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.verificarFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (!this.verificaProduto(nome, descricao, fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}

		this.fornecedorRepositorio.get(fornecedor).removeProduto(nome, descricao);
	}

	/**
	 * Verifica se um produto ja foi cadastrado através de seu nome e descrição.
	 * 
	 * @param nome       String nome do produto.
	 * @param descricao  String descrição do produto.
	 * @param fornecedor String fornecedor do produto.
	 * @return boolean true se ja foi cadastrado e false caso contrário.
	 */
	public boolean verificaProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedorRepositorio.get(fornecedor).verificarProduto(nome, descricao);
	}

	/**
	 * exibe todos os produtos dos fornecedores.
	 * 
	 * @return String com a representação textual de produtos.
	 */
	public String exibeProdutos() {
		ArrayList<Fornecedor> exibeProdutosFornecedor = new ArrayList<Fornecedor>();
		ArrayList<String> exibeFornecedoreSemProdutos = new ArrayList<String>();

		for (Fornecedor fornecedor : this.fornecedorRepositorio.values()) {
			exibeProdutosFornecedor.add(fornecedor);
		}

		Collections.sort(exibeProdutosFornecedor);

		for (int i = 0; i < exibeProdutosFornecedor.size(); i++) {
			if (exibeProdutosFornecedor.get(i).getQtdProdutos() == 0) {
				exibeFornecedoreSemProdutos.add(exibeProdutosFornecedor.get(i).getNome() + " -");
			} else {
				exibeFornecedoreSemProdutos.add(exibeProdutosFornecedor.get(i).exibeProdutosFornecedores());
			}

		}

		Collections.sort(exibeFornecedoreSemProdutos);

		String listaProdutos = "";

		for (int i = 0; i < exibeFornecedoreSemProdutos.size(); i++) {
			if (i == 0) {
				listaProdutos += exibeFornecedoreSemProdutos.get(i);
			} else {
				listaProdutos += " | " + exibeFornecedoreSemProdutos.get(i);
			}
		}

		return listaProdutos;
	}

	/**
	 * Exibe todos os produtos de um fornecedor.
	 * 
	 * @param fornecedor String fornecedor.
	 * @return String com os produtos de um fornecedor.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {

		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (this.verificarFornecedor(fornecedor) == false) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return this.fornecedorRepositorio.get(fornecedor).exibeProdutosFornecedores();
	}

	public String exibeFornecedor(String nome) {

		if (!this.fornecedorRepositorio.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}

		return this.fornecedorRepositorio.get(nome).toString();

	}

	/**
	 * Exibe todos os fornecedores.
	 * 
	 * @return String com a representação textual de fornecedore.
	 */
	public String exibeFornecedores() {

		ArrayList<String> fornecedores = new ArrayList<>();
		for (Fornecedor fornecedor : this.fornecedorRepositorio.values()) {
			fornecedores.add(fornecedor.toString());
		}

		Collections.sort(fornecedores);

		String exibeFornecedores = "";
		for (int i = 0; i < fornecedores.size(); i++) {
			if (i == 0) {
				exibeFornecedores += fornecedores.get(i);
			} else {
				exibeFornecedores += " | " + fornecedores.get(i);
			}
		}

		return exibeFornecedores;

	}

	/**
	 * Edita um atributo de um fornecedor, exceto o nome.
	 * 
	 * @param nome      String nome do fornecedor.
	 * @param atributo  String atributo a ser editado.
	 * @param novoValor String novo valor do atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (this.fornecedorRepositorio.containsKey(nome) == false) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}

		if (novoValor == null || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}

		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}

		if (atributo.trim().equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}

		else if (atributo.trim().equals("email")) {
			this.fornecedorRepositorio.get(nome).setEmail(novoValor);
		}

		else if (atributo.trim().equals("telefone")) {
			this.fornecedorRepositorio.get(nome).setTelefone(novoValor);
		}

		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	/**
	 * remove um fornecedor através de seu identificador de nome.
	 * 
	 * @param nome String com o nome do fornecedor.
	 */
	public void removeFornecedor(String nome) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		}

		if (this.fornecedorRepositorio.containsKey(nome) == false) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}

		this.fornecedorRepositorio.remove(nome);

	}

}
