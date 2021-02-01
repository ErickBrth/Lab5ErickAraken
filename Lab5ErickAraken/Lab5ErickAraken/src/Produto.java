import java.text.DecimalFormat;
/**
 * atribui as fun��es e caracter�sticas de produto.
 *  @author erick Araken - 119210561
 *
 */
public class Produto {
	private double preco;
	private String nome;
	private String descri��o;
	/**
	 * construtor de Produto.
	 * @param nome Stirng nome do produto.
	 * @param descricao String preco do produto.
	 * @param preco double preco do produto.
	 */
	public Produto(String nome, String descricao, double preco) {
		this.preco = preco;
		
		this.nome = nome;
		this.descri��o = descricao;
	}
	/**
	 * muda o preco do produto.
	 * @param preco String pre�o.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * retorna o pre�o do produto.
	 * @return double preco. 
	 */
	public double getPreco() {
		return this.preco;
	}
	/**
	 * representa��o textual de produto.
	 */
	public String toString() {
		return this.nome + " - " + this.descri��o + " - R$"
				+ new DecimalFormat("#.00").format(this.preco).replace(".", ",");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descri��o == null) ? 0 : descri��o.hashCode());
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
		Produto other = (Produto) obj;
		if (descri��o == null) {
			if (other.descri��o != null)
				return false;
		} else if (!descri��o.equals(other.descri��o))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
