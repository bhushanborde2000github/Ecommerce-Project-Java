
public class Seller extends User{
   private Product [] productsListed;
	@Override
	public Boolean verifyUser() {
		// TODO Auto-generated method stub
		return null;
	}
	public Product[] getProductsListed() {
		return productsListed;
	}
	public void setProductsListed(Product[] productsListed) {
		this.productsListed = productsListed;
	}
	
	

}
