import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControllerTest {
	
	private ClienteController clienteController;


	@BeforeEach
	public void ClienteController() {
		clienteController = new ClienteController();
	}
	
	
	@Test
	void testAdicionaCliente() {
		assertEquals("11135922497", clienteController.adicionaCliente("11135922497", "Erick", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testCpfNull() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente(null, "Erick", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("", "Erick", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testCpfIncorreto() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "Erick", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testClienteExistente() {
		
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("11135922497", "Erick", "erickaraken@gmail.com", "LCC-2");
		assertEquals("Erro no cadastro do cliente: cliente ja existe.", cliente.adicionaCliente("11135922497","Erick", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testLocalizacaoNull() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "Erick", "erickaraken@gmail.com", null));
	}
	
	@Test
	void testLocalizacaoVazio() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "Erick", "erickaraken@gmail.com", ""));
	}
	
	
	@Test
	void testemailNull() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "Erick", null, "LCC-2"));
	}
	
	@Test
	void testemailVazio() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "Erick", "", "LCC-2"));
	}
	
	@Test
	void testNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", "", "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testNomeNull() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.adicionaCliente("123334", null, "erickaraken@gmail.com", "LCC-2"));
	}
	
	@Test
	void testExibeCliente() {
		
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertEquals("Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br", cliente.exibeCliente("00023827490"));
	}
	
	@Test
	void testCpfExibeClienteNull() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.exibeCliente(null));
	}
	
	@Test
	void testCpfExibeClienteVazio() {
		assertThrows(IllegalArgumentException.class, () -> clienteController.exibeCliente(""));
	}
	
	@Test
	void testExibeClienteExiste() {
		
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertNotEquals("Erro na exibicao do cliente: cliente nao existe.", cliente.exibeCliente("00023827494"));
	}
	 	
	@Test
	void testExibeClientes() {
		
		ClienteController cliente = new ClienteController();
		
		ClienteController cliente2 = new ClienteController();
		cliente2.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		cliente.adicionaCliente("11135922497", "Erick", "erickaraken@gmail.com", "LCC-2");
		cliente2.exibeClientes();
		assertNotEquals("Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br | 11135922497 - Erick - erickaraken@gmail.com - LCC-2", cliente2.exibeClientes());
	}
	
	@Test
	void testEditaClienteAtributo() {
		
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		cliente.editaCliente("00023827490", "nome", "victor");
		cliente.editaCliente("00023827490", "email", "victor@gg.com");
		cliente.editaCliente("00023827490", "localizacao", "lp2");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "n", "victor"));
		
		
		
	}
	
	@Test
	void testCpfEditaClienteNull() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "cpf", "011002"));
	}
	
	@Test
	void testAtributoEditaClienteVazio() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "", "011002"));
	}
	
	@Test
	void testAtributoEditaClienteNull() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", null, "011002"));
	}
	
	@Test
	void testAtributoEditaClienteInexistente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "adc", "011002"));
	}
	
	@Test
	void testNovoValorEditaClienteVazio() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "sad", ""));
	}
	
	@Test
	void testNovoValorEditaClienteNull() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827490", "sad", null));
	}
	
	@Test
	void testEditaClienteExistente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("00023827491", "nome", "vix"));
	}
	
	@Test
	void testcpfEditaClienteNull() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente(null, "nome", "vic"));
	}
	
	@Test
	void testcpfEditaClientevazio() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.editaCliente("", "nome", "vic"));
	}
	
	@Test
	void testRemoveCliente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.removeCliente("00023827490"));
	}
	
	@Test
	void testRemoveClienteInexistente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.removeCliente("00023827492"));
	}
	
	@Test
	void testVerificaCliente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.verificaCliente("00023827492"));
	}
	
	@Test
	void testRemoveClienteCpfVazio() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.removeCliente(""));
	}
	@Test
	void testRemoveClienteCpfNull() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.removeCliente(null));
	}
	
	@Test
	void testAdiconaCompra() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertThrows(IllegalArgumentException.class, () -> cliente.adicionaCompra("00023827490", "dona Zefa", "11/11/2020", "coxinha", "coxinha de flango", 2.50));
	}
	
	@Test
	void testGetDebito() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.50);
		assertEquals("2,50", cliente.getDebito("00023827490", "dona Alba"));
		
	}
	
	@Test
	void testVerificaDebito() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertNotEquals(true, cliente.verificaDebito("00023827490", "dona Alba"));
		
	}
	
	@Test
	void testVerificaConta() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertEquals(true, cliente.verificaConta("00023827490"));
		
	}
	
	@Test
	void testVerificaContaFornecedor() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertEquals(false, cliente.verificaConta("00023827490", "dona Alba"));
		
	}
	
	
	@Test
	void testExibeContas() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		fornecedor.adicionaProduto("dona Alba", "coxinha", "coxinha de frango", 2.5);
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertEquals("Cliente: Victor Emanuel | dona Alba | coxinha de frango - 11-11-2011 |", cliente.exibeContas("00023827490", "dona Alba"));
		
	}
	
	@Test
	void testExibeContasClientes() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		fornecedor.adicionaProduto("dona Alba", "coxinha", "coxinha de frango", 2.5);
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertNotEquals("Cliente: Victor Emanuel | dona Alba | coxinha de frango - 11-11-2011 |", cliente.exibeContasClientes("00023827490"));
		
	}
	
	@Test
	void testOrdenaPorData() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		fornecedor.adicionaProduto("dona Alba", "coxinha", "coxinha de frango", 2.5);
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertEquals("11/11/2011, Victor Emanuel, dona Alba, coxinha de frango", cliente.ordenaPorData());
		
	}
	
	@Test
	void testOrdenaPorFornecedor() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		fornecedor.adicionaProduto("dona Alba", "coxinha", "coxinha de frango", 2.5);
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		assertEquals("dona Alba, Victor Emanuel, coxinha de frango, 11/11/2011", cliente.ordenaPorFornecedor());
		
	}
	
	@Test
	void testOrdenaPorCliente() {
		ClienteController cliente = new ClienteController();
		cliente.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		FornecedorController fornecedor = new FornecedorController();
		fornecedor.adicionaFornecedor("dona Alba", "cantina@bol.com", "999");
		fornecedor.adicionaProduto("dona Alba", "coxinha", "coxinha de frango", 2.5);
		Conta conta = new Conta("dona Alba", "Victor Emanuel");
		conta.adicionaCompra("11/11/2011", "coxinha", "coxinha de frango", 2.5);
		conta.adicionaCompra("11/11/2020", "sanduiche", "sanduiche de frango", 4.5);
		
		assertEquals("Victor Emanuel, dona Alba, coxinha de frango, 11/11/2011 | Victor Emanuel, dona Alba, sanduiche de frango, 11/11/2020 |", cliente.ordenaPorCliente());
		
	}
	
	
	
		
	
	
	
	
}
