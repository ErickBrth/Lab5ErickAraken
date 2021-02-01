
/**
 * FinalizaCompra realiza a compra do produto.
 * @author erick Araken - 119210561
 *
 */
public class FinalizaCompra {
	
	private String data;
	private String fornecedor;
	private String descr_prod;
	private String cliente;
	
	/**
	 * Construtor de FinalizaCompra.
	 * @param data String data da compra.
	 * @param fornecedor String fornecedor.
	 * @param descr_prod String com a descricao do produto.
	 * @param cliente String Cliente.
	 */
	public FinalizaCompra(String data, String fornecedor, String descr_prod, String cliente) {
		this.data = data;
		this.fornecedor = fornecedor;
		this.descr_prod = descr_prod;
		this.cliente = cliente;
	}
	
	/**
	 * retorna a data.
	 * 
	 * @return String data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * muda a data.
	 * 
	 * @param data String data.
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * retorna um fornecedor.
	 * 
	 * @return String fornecedor.
	 */
	public String getFornecedor() {
		return fornecedor;
	}

	/**
	 * muda um fornecedor.
	 * 
	 * @param fornecedor String Fornecedor.
	 */
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * retorna a descricao do produto.
	 * 
	 * @return String com a descricao do produto.
	 */
	public String getDescr_prod() {
		return descr_prod;
	}

	/**
	 * muda a descircão do produto.
	 * 
	 * @param descr_prod String descr_prod.
	 */
	public void setDescr_prod(String descr_prod) {
		this.descr_prod = descr_prod;
	}
	
	/**
	 * retorna o cliente.
	 * @return String cliente.
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * muda o cliente.
	 * @param cliente String Cliente.
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
