import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * A classe fornecedor atribui as caracteristica de fornecedor ao sistema saga.
 * 
 * @author erick Araken - 119210561
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {
	private String nome;
	private String email;
	private String telefone;
	private HashMap<String, Produto> produtos;

	/**
	 * contrutor de Fornecedor.
	 * 
	 * @param nome     String com o nome do fornecedor.
	 * @param email    String email do fornecedor.
	 * @param telefone String telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/**
	 * muda o email.
	 * 
	 * @param email String email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * muda o telefone.
	 * 
	 * @param telefone String telefone.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * verifica se o produto ja foi cadastrado.
	 * 
	 * @param produto String produto.
	 * @return boolean true se ja está cadastrado e false se não.
	 */
	public boolean verificaProduto(String produto) {
		return this.produtos.containsKey(produto);
	}

	/**
	 * muda os produtos.
	 * 
	 * @param produtos String com Arraylist de Produtos.
	 */
	public void setProdutos(HashMap<String, Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * modifica os preços dos produtos.
	 * 
	 * @param nome      String nome do produto.
	 * @param descricao String descrição do produto.
	 * @param preco     String preço do produto.
	 */
	public void setPrecoProduto(String nome, String descricao, double preco) {
		this.produtos.get(nome + descricao).setPreco(preco);
	}

	/**
	 * exibe os fornecedores.
	 * 
	 * @return String com representação textual de fornecedores.
	 */
	public String exibeFornecedores() {
		return this.toString();
	}

	/**
	 * exibe os fornecedores.
	 * 
	 * @return String com representação textual de fornecedores.
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * retorna o nome do fornecedor.
	 * 
	 * @return String nome.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * retorna o preço do produto.
	 * 
	 * @param idProduto String com o identificação do produto.
	 * @return double preço do produto.
	 */
	public double getPrecoProduto(String idProduto) {
		return this.produtos.get(idProduto).getPreco();
	}

	/**
	 * adiciona um produto no HashMap de produtos.
	 * 
	 * @param nome      String nome do produto.
	 * @param descricao String descrição do produto.
	 * @param preco     String com o preço do produto.
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {

		this.produtos.put(nome + descricao, new Produto(nome, descricao, preco));

	}

	/**
	 * exibe um produto de um fornecedor, pelo seu nome e descrição.
	 * 
	 * @param nome       String nome.
	 * @param descricao  String descrição.
	 * @param fornecedor String fornecedor.
	 * @return String com o produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.produtos.get(nome + descricao).toString();
	}

	/**
	 * exibe todos os produtos de um fornecedor.
	 * 
	 * @return String com a representação dos produtos do fornecedor.
	 */
	public String exibeProdutosFornecedores() {
		ArrayList<String> exibeProdutos = new ArrayList<>();

		for (Produto produto : this.produtos.values()) {
			exibeProdutos.add(produto.toString());
		}

		Collections.sort(exibeProdutos);

		String listaProdutos = "";

		for (int i = 0; i < exibeProdutos.size(); i++) {
			if (i == 0) {
				listaProdutos += this.nome + " - " + exibeProdutos.get(i);
			} else {
				listaProdutos += " | " + this.nome + " - " + exibeProdutos.get(i);
			}
		}

		return listaProdutos;
	}

	/**
	 * retorna a quantidade de produtos.
	 * 
	 * @return int qtd de produtos.
	 */
	public int getQtdProdutos() {
		return this.produtos.size();
	}

	/**
	 * verifica se o produto ja está cadastrado.
	 * 
	 * @param nome      String nome.
	 * @param descricao String descrição.
	 * @return boolean true se ja foi cadastrado e false cao contrário.
	 */
	public boolean verificarProduto(String nome, String descricao) {
		String produto = nome + descricao;

		return this.produtos.containsKey(produto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * remove um produto através de seu nome e descrição.
	 * 
	 * @param nome      String nome.
	 * @param descricao String descrição.
	 */
	public void removeProduto(String nome, String descricao) {
		this.produtos.remove(nome + descricao);
	}

	/**
	 * comparador de fornecedores pelo nome.
	 */
	@Override
	public int compareTo(Fornecedor f) {
		return this.getNome().compareTo(f.getNome());
	}

}
