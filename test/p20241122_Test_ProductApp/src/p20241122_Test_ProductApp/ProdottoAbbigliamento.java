package p20241122_Test_ProductApp;

public class ProdottoAbbigliamento extends Prodotto{
	
	protected ProdottoAbbigliamento(String name, Double price, String categoria) {
		super(name, price, categoria);
	}

	protected ProdottoAbbigliamento() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	Double calculateDiscount() {
		Double discountPrice = this.getPrice();
		if(this.getCategoria().toLowerCase() == "abbigliamento invernale")
			return discountPrice - discountPrice*0.15;
		return discountPrice;
	}

}
