
/**
 * A classe compra se encarrega de administra as compras feitas pelos clientes.
 * 
 * @author erick Araken - 119210561
 *
 */
public class Compra {
	private String data;
	private String nome_prod;
	private String descr_prod;
	private double preco;
	/**
	 * Construtor de Compra.
	 * @param data String com a data da compra.
	 * @param nome_prod String com o nome do produto.
	 * @param descr_prod String com a descrição do produto.
	 * @param preco String com o preço do produto.
	 */
	public Compra(String data, String nome_prod, String descr_prod, double preco) {
		this.descr_prod = descr_prod;
		this.nome_prod = nome_prod;
		this.data = data;
		this.preco = preco; 
	}
	/**
	 * pega a data da compra.
	 * @return String data da compra.
	 */
	public String getData() {
		return this.data;
	}
	/***
	 * pega o preço da compra.
	 * @return String preço da compra.
	 */
	public double getPreco() {
		return this.preco;
	}
	/**
	 * Lista todas as compras.
	 * @return String com todas as compra.
	 */
	public String listarCompras() {
		return this.descr_prod + ", " + this.data  ;
	}
	/**
	 * String com a representação textual de compra.
	 */
	public String toString() {
		return this.nome_prod + " - " + this.data.replace("/", "-");
	}
	/**
	 * retorna a descrição do produto.
	 * @return String com a descrição do produto.
	 */
	public String getDescr_prod() {
		return this.descr_prod;
	}
}
