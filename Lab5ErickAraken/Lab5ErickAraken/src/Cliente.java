import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe cliente carrega os atributos e fun�oes de um cliente.
 * 
 * @author erick Araken - 119210561
 *
 */
public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	private HashMap<String, Conta> contas;

	/**
	 * Construtor de Cliente.
	 * 
	 * @param cpf       String com cpf do Cliente.
	 * @param nome      String com nome do Cliente.
	 * @param email     String com o email do Cliente.
	 * @param localicao String com a localiza��o do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localicao) {
		this.cpf = cpf;
		this.email = email;
		this.localizacao = localicao;
		this.nome = nome;
		this.contas = new HashMap<>();
	}

	/**
	 * lista todas as compras.
	 * 
	 * @return String com uma representa��o textual de compra.
	 */
	public ArrayList<FinalizaCompra> listarCompras() {
		ArrayList<FinalizaCompra> compras = new ArrayList<FinalizaCompra>();

		for (Conta compra : this.contas.values()) {
			for (FornecedorCompra compra2 : compra.listarCompras()) {
				compras.add(new FinalizaCompra(compra2.getData(), compra2.getFornecedor(), compra2.getDescr_prod(),
						this.nome));
			}
		}
		return compras;
	}

	/**
	 * Muda o nome.
	 * 
	 * @param nome String nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Seta o email.
	 * 
	 * @param email Stirng email do cliente.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * seta a localiza��o.
	 * 
	 * @param localizacao String localiza��o do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * pega os clientes.
	 * 
	 * @return String com o toString dos clientes e a barra pra separar.
	 */
	public String getClientes() {
		return this.toString() + " | ";
	}

	/**
	 * representa��o textual de cliente.
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;

	}

	/**
	 * pega o cpf do cliente.
	 * 
	 * @return String com o cpf do cliente.
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * Adiciona uma Compra em Cliente.
	 * 
	 * @param cpf        String com o cpf do cliente.
	 * @param fornecedor String com o fornecedor.
	 * @param data       String com a data do cliente.
	 * @param nome_prod  String com o nome do produto.
	 * @param descr_prod String com a descricao do produto.
	 * @param preco      double com o pre�o do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String descr_prod,
			double preco) {

		if (!this.contas.containsKey(fornecedor)) {
			this.contas.put(fornecedor, new Conta(fornecedor, cpf));
			this.contas.get(fornecedor).adicionaCompra(data, nome_prod, descr_prod, preco);
		} else {
			this.contas.get(fornecedor).adicionaCompra(data, nome_prod, descr_prod, preco);
		}
	}

	/**
	 * Pega o d�bito do cliente com o forncedor.
	 * 
	 * @param fornecedor String com o fornecedor.
	 * @return double com debito do cliente.
	 */
	public String getDebito(String fornecedor) {
		return this.contas.get(fornecedor).getDebito();
	}

	/**
	 * exibe as contas de um fornecedor.
	 * 
	 * @param fornecedor String com fornecedor.
	 * @return representa��o textual das contas.
	 */
	public String exibeContas(String fornecedor) {
		return this.contas.get(fornecedor).exibeContas(this.nome);
	}

	/**
	 * verifica se o cliente tem d�bito com o fornecedor.
	 * 
	 * @param fornecedor String com um fornecedor.
	 * @return boolean true se tem d�bito e false caso contr�rio.
	 */
	public boolean verificaDebito(String fornecedor) {
		return this.contas.containsKey(fornecedor);
	}

	/**
	 * Verifica se o cliente j� tem conta com um fornecedor.
	 * 
	 * @param fornecedor String com um fornecedor.
	 * @return boolean true se tem conta e false caso contr�rio.
	 */
	public boolean verificaConta(String fornecedor) {
		return this.contas.containsKey(fornecedor);
	}

	/***
	 * Verifica se a conta est� vazia.
	 * 
	 * @return boolean true se estiver vazia e false caso contr�rio.
	 */
	public boolean verificaConta() {
		return this.contas.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Exibe todas as contas dos clientes.
	 * 
	 * @return String com a representa��o textual de todas as contas dos clientes.
	 */
	public String exibeContasClientes() {

		ArrayList<String> compras = new ArrayList<>();
		String contasCliente = "Cliente: " + this.nome;

		for (Conta conta : this.contas.values()) {
			compras.add(conta.exibeContasClientes());
		}

		compras.sort((s1, s2) -> {
			String a = s1.split(" | ")[2];
			String b = s2.split(" | ")[2];
			return a.compareTo(b);

		});
		for (String contas : compras) {
			contasCliente += contas;
		}

		return contasCliente;
	}

}
