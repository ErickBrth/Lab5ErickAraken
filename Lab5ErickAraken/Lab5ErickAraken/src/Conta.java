import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A classe conta representa uma conta que o cliente tem com um fornecedor.
 * 
 * @author erick Araken - 119210561
 *
 */
public class Conta {
	private String nomeCliente;
	private String fornecedor;
	private ArrayList<Compra> compras;
	/**
	 * Construtor de Conta.
	 * @param fornecedor String com o nome do fornecedor.
	 * @param nomeCliente String com o nome do cliente.
	 */
	public Conta(String fornecedor, String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<Compra>();
	}
	/**
	 * Calcula os debitos dos clientes com o fornecedor.
	 * @return String com o débito do cliente formatado.
	 */
	public String getDebito() {
		double somaDebito = 0;
		for(Compra debito : this.compras) {
			somaDebito += debito.getPreco();
		}
		
		return new DecimalFormat("#.00").format(somaDebito).replace(",", ".");
	}
	/**
	 * lista todas as compras.
	 * @return ArrayList com todas as compras feitas.
	 */
	public ArrayList<FornecedorCompra> listarCompras() {
		ArrayList<FornecedorCompra> compras = new ArrayList<FornecedorCompra>();
		
		for(Compra compra : this.compras) {
			compras.add(new FornecedorCompra(compra.getData(), this.fornecedor, compra.getDescr_prod()));
		}
		
		return compras; 
	}
	/**
	 * Exibe todas as contas dos clientes.
	 * @return String com todas as contas dos clientes.
	 */
	public String exibeContasClientes() {	
		
		String retorno = " | " + this.fornecedor + " | ";	
		for(int i = 0; i < compras.size(); i++) {
			if(i == 0) {
				retorno += compras.get(i).toString();
			}else {
				retorno += " | " + compras.get(i).toString();
			}
		}
		
		return 	retorno;
	}
	/**
	 * exibe as contas de um cliente.
	 * @param nome Stirng com o nome do cliente.
	 * @return String com todas as contas de um cliente.
	 */
	public String exibeContas(String nome) {
		String exibeCompras = "";
		for(Compra compra : this.compras) {
			exibeCompras += compra.toString() + " | ";
		}
			
		if(exibeCompras.length() > 0){
			exibeCompras = exibeCompras.substring(0, exibeCompras.length() -2);
		}
		
		
		return 	"Cliente: " + nome + " | " + this.fornecedor + " | " + exibeCompras.trim() ;
	}
	/**
	 * adiciona uma compra.
	 * @param data String com a data da compra.
	 * @param nome_prod String com o nome do produto.
	 * @param descricao String com a descricção do prodito.
	 * @param preco double com o preço da compra. 
	 */
	public void adicionaCompra(String data, String nome_prod, String descricao, double preco) {
		Compra compra = new Compra(data, nome_prod, descricao, preco);
		this.compras.add(compra);
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
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
		Conta other = (Conta) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		return true;
	}

	
	
}
