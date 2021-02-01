/**
 * detem a compra com um Fornecedor integrado.
 * 
 * @author erick Araken - 119210561
 *
 */
public class FornecedorCompra {
	private String data;
	private String fornecedor;
	private String descr_prod;
	/**
	 * Construtor de FornecedorCompra.
	 * @param data String data.
	 * @param fornecedor String fornecedor.
	 * @param descr_prod String descr_prod.
	 */
	public FornecedorCompra(String data, String fornecedor, String descr_prod) {
		this.data = data;
		this.fornecedor = fornecedor;
		this.descr_prod = descr_prod;
	}
	/**
	 * retorna a data.
	 * @return String data.
	 */
	public String getData() {
		return data;
	}
	/**
	 * muda a data.
	 * @param data String data.
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * retorna um fornecedor.
	 * @return String fornecedor.
	 */
	public String getFornecedor() {
		return fornecedor;
	}
	/**
	 * muda um fornecedor.
	 * @param fornecedor String Fornecedor.
	 */
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	/**
	 * retorna a descricao do produto.
	 * @return String com a descricao do produto.
	 */
	public String getDescr_prod() {
		return descr_prod;
	}
	/**
	 * muda a descircão do produto.
	 * @param descr_prod String descr_prod.
	 */
	public void setDescr_prod(String descr_prod) {
		this.descr_prod = descr_prod;
	}
	
}
