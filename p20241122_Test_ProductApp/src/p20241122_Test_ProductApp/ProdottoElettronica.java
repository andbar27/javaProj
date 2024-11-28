package p20241122_Test_ProductApp;

public class ProdottoElettronica extends Prodotto{
	
	protected ProdottoElettronica(String name, Double price, String categoria) {
		super(name, price, categoria);
	}

	protected ProdottoElettronica() {
		super();
	}



	@Override
	Double calculateDiscount() {
		Double discountPrice = this.getPrice();
		if(discountPrice > 500)
			return discountPrice - discountPrice*0.1;
		return discountPrice;
	}
	
}
