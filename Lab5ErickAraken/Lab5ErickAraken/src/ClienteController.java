
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * Classe que controlla todos os clientes e seus repositórios.
 * 
 * @author erick Araken - 119210561
 *
 */
public class ClienteController {

	private HashMap<String, Cliente> clienteRepositorio;

	/**
	 * Construtor de ClienteController
	 */
	public ClienteController() {
		this.clienteRepositorio = new HashMap<>();
	}

	/**
	 * Adiciona Um cliente ao repositorio de Clientes.
	 * 
	 * @param cpf         String Cpf do Cliente.
	 * @param nome        String Nome do Cliente.
	 * @param email       String email do Cliente.
	 * @param localizacao String localizaçao do Cliente.
	 * @return String com nome do cliente adicionado.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {

		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}

		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}

		if (localizacao == null || localizacao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}

		if (this.clienteRepositorio.containsKey(cpf) == true) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}

		this.clienteRepositorio.put(cpf, new Cliente(cpf, nome, email, localizacao));

		return this.clienteRepositorio.get(cpf).getCpf();
	}

	/**
	 * Exibe todos os clientes Cadastrados.
	 * 
	 * @return String com todos os clientes cadastrados.
	 */
	public String exibeClientes() {

		ArrayList<String> clientes = new ArrayList<>();
		for (Cliente cliente : this.clienteRepositorio.values()) {
			clientes.add(cliente.toString());
		}

		Collections.sort(clientes);

		String exibeClientes = "";
		for (int i = 0; i < clientes.size(); i++) {
			if (i == 0) {
				exibeClientes += clientes.get(i);
			} else {
				exibeClientes += " | " + clientes.get(i);
			}
		}

		return exibeClientes;
	}

	/**
	 * Exibe um cliente através de seu cpf.
	 * 
	 * @param cpf String cpf do cliente.
	 * @return String com representação textual de um cliente.
	 */
	public String exibeCliente(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (this.clienteRepositorio.containsKey(cpf) == false) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

		return this.clienteRepositorio.get(cpf).toString().trim();
	}

	/**
	 * Edita um cliente por meio de su cpf, atributo e um novoValor.
	 * 
	 * @param cpf       String com cpf do cliente.
	 * @param atributo  String com atributo a ser modificado.
	 * @param novoValor String com um novoValor a ser inserido.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {

		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (this.clienteRepositorio.containsKey(cpf) == false) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}

		if (novoValor == null || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}

		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}

		if (atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}

		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}

		if (atributo.equals("nome")) {
			this.clienteRepositorio.get(cpf).setNome(novoValor);
		} else if (atributo.equals("email")) {
			this.clienteRepositorio.get(cpf).setEmail(novoValor);
		} else if (atributo.equals("localizacao")) {
			this.clienteRepositorio.get(cpf).setLocalizacao(novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}

	}

	/**
	 * remove um cliente por meio de seu cpf.
	 * 
	 * @param cpf String com Cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}

		if (this.clienteRepositorio.containsKey(cpf) == false) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		this.clienteRepositorio.remove(cpf);
	}

	/**
	 * Verifica se um cliente existe.
	 * 
	 * @param cpf String cpf Cliente.
	 * @return boolean true se existe e false se não existe.
	 */
	public boolean verificaCliente(String cpf) {
		return this.clienteRepositorio.containsKey(cpf);

	}

	/**
	 * Adiciona uma compra.
	 * 
	 * @param cpf        String cpf do Cliente.
	 * @param fornecedor String nome Fornecedor.
	 * @param data       String data de compra.
	 * @param nome_prod  String nome do produto.
	 * @param descr_prod String descrição do produto.
	 * @param preco      double preco do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String descr_prod,
			double preco) {

		this.clienteRepositorio.get(cpf).adicionaCompra(cpf, fornecedor, data, nome_prod, descr_prod, preco);
	}

	public String getDebito(String cpf, String fornecedor) {
		return this.clienteRepositorio.get(cpf).getDebito(fornecedor);

	}

	public boolean verificaDebito(String cpf, String fornecedor) {
		return this.clienteRepositorio.get(cpf).verificaDebito(fornecedor);
	}

	public boolean verificaConta(String cpf, String fornecedor) {
		return this.clienteRepositorio.get(cpf).verificaConta(fornecedor);
	}

	public boolean verificaConta(String cpf) {
		return this.clienteRepositorio.get(cpf).verificaConta();
	}

	public String exibeContas(String cpf, String fornecedor) {
		return this.clienteRepositorio.get(cpf).exibeContas(fornecedor);

	}

	public String exibeContasClientes(String cpf) {
		return this.clienteRepositorio.get(cpf).exibeContasClientes();

	}

	/**
	 * Ordena as compras pela sua data.
	 * 
	 * @return String com as compras ordenadas por Data.
	 */
	public String ordenaPorData() {
		ArrayList<FinalizaCompra> compras = new ArrayList<FinalizaCompra>();
		String retorno = "";
		for (Cliente cliente : clienteRepositorio.values()) {
			for (FinalizaCompra compra : cliente.listarCompras()) {
				compras.add(compra);
			}
		}

		compras.sort((c1, c2) -> {
			Date dataFormatada = null;
			Date dataFormatada2 = null;
			try {
				String data = c1.getData();
				String data2 = c2.getData();
				SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
				dataFormatada = formatoData.parse(data);
				dataFormatada2 = formatoData.parse(data2);

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (dataFormatada.compareTo(dataFormatada2) == 0) {
				String a = c1.getCliente() + c1.getFornecedor() + c1.getDescr_prod();
				String b = c2.getCliente() + c2.getFornecedor() + c2.getDescr_prod();
				return a.compareTo(b);
			}

			return dataFormatada.compareTo(dataFormatada2);
		});

		for (int i = 0; i < compras.size(); i++) {
			if (i + 1 == compras.size()) {
				retorno += compras.get(i).getData() + ", " + compras.get(i).getCliente() + ", "
						+ compras.get(i).getFornecedor() + ", " + compras.get(i).getDescr_prod();
			} else {
				retorno += compras.get(i).getData() + ", " + compras.get(i).getCliente() + ", "
						+ compras.get(i).getFornecedor() + ", " + compras.get(i).getDescr_prod() + " | ";
			}
		}

		return retorno;
	}

	/**
	 * Ordena as compras pelo seu fornecedor.
	 * 
	 * @return String com as compras ordenadas por Fornecedor.
	 *
	 */
	public String ordenaPorFornecedor() {
		ArrayList<FinalizaCompra> compras = new ArrayList<FinalizaCompra>();
		String retorno = "";
		for (Cliente cliente : clienteRepositorio.values()) {
			for (FinalizaCompra compra : cliente.listarCompras()) {
				compras.add(compra);
			}
		}

		compras.sort((c1, c2) -> {

			if (c1.getFornecedor().compareTo(c2.getFornecedor()) == 0) {
				String a = c1.getCliente() + c1.getDescr_prod() + c1.getData();
				String b = c2.getCliente() + c2.getDescr_prod() + c2.getData();
				return a.compareTo(b);
			}
			return c1.getFornecedor().compareTo(c2.getFornecedor());
		});

		for (int i = 0; i < compras.size(); i++) {
			if (i + 1 == compras.size()) {
				retorno += compras.get(i).getFornecedor() + ", " + compras.get(i).getCliente() + ", "
						+ compras.get(i).getDescr_prod() + ", " + compras.get(i).getData();
			} else {
				retorno += compras.get(i).getFornecedor() + ", " + compras.get(i).getCliente() + ", "
						+ compras.get(i).getDescr_prod() + ", " + compras.get(i).getData() + " | ";
			}
		}

		return retorno;
	}

	/**
	 * Ordena as compras pelo Cliente.
	 * 
	 * @return String com as compras ordenadas por Data.
	 */
	public String ordenaPorCliente() {
		ArrayList<FinalizaCompra> compras = new ArrayList<FinalizaCompra>();
		String retorno = "";
		for (Cliente cliente : clienteRepositorio.values()) {
			for (FinalizaCompra compra : cliente.listarCompras()) {
				compras.add(compra);
			}
		}

		compras.sort((c1, c2) -> {

			if (c1.getCliente().compareTo(c2.getCliente()) == 0) {
				String a = c1.getFornecedor() + c1.getDescr_prod() + c1.getData();
				String b = c2.getFornecedor() + c2.getDescr_prod() + c2.getData();
				return a.compareTo(b);
			}
			return c1.getCliente().compareTo(c2.getCliente());
		});

		for (int i = 0; i < compras.size(); i++) {
			if (i + 1 == compras.size()) {
				retorno += compras.get(i).getCliente() + ", " + compras.get(i).getFornecedor() + ", "
						+ compras.get(i).getDescr_prod() + ", " + compras.get(i).getData();
			} else {
				retorno += compras.get(i).getCliente() + ", " + compras.get(i).getFornecedor() + ", "
						+ compras.get(i).getDescr_prod() + ", " + compras.get(i).getData() + " | ";
			}
		}

		return retorno;
	}

}
