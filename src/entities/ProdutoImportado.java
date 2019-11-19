package entities;

public class ProdutoImportado extends Produto{
	
	private double taxaAdicional;

	public ProdutoImportado(String nome, double preco, double taxaAdicional) {
		super(nome, preco);
		this.taxaAdicional = taxaAdicional;
	}
	
	public double PrecoTotal() {
		return getPreco() + taxaAdicional;
	}
	
	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", PrecoTotal())
				+ " (Produto importado: $ " 
				+ String.format("%.2f", taxaAdicional)
				+ ")";
	}
	
	

}
