package p20241122_Test_ProductApp;

public abstract class Prodotto implements Comparable<Prodotto>{
		protected String name;
		protected Double price;
		protected String categoria;
		
		abstract Double calculateDiscount();

		protected Prodotto(String name, Double price, String categoria) {
			super();
			this.name = name;
			this.price = price;
			this.categoria = categoria;
		}

		protected Prodotto() {
			super();
		}
		
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		
		
		
		@Override
		public int compareTo(Prodotto o) {
			return this.getPrice().compareTo(o.getPrice());
		}

		@Override
		public String toString() {
			return "Prodotto [name=" + name + ", price=" + price + ", categoria=" + categoria + "]";
		}

}
