import java.util.Scanner;

/*
* Ask which type of user are you? Customer, Seller, Administrator
*User- Customer, Seller, Administrator
*Customer- View Products, View Cart, Contact Us. 
*View Products- Add the products to the Cart, View Cart- Checkout.
*Seller- View your product, Add a product, Contact Us.
*View your product- delete this product. Add a product- Submit detail of the product.
*Administrator-...
*Product
*Category
*Cart
*Order
 */

public class Store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Ecommerce Store!");
		System.out.println("Which user are you? 1. Customer  2. Seller 3. Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		String typeOfUser;
		if (choice == 1) {
			typeOfUser = "Customer";
			Customer current = new Customer();
			System.out.println("What is your userId?");
			sc.nextLine();
			current.setUserId(sc.nextLine());
			System.out.println("What is your password?");
			sc.nextLine();
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("User verified!");
				
				while(true) {
					
				
				
				System.out.println("Do you want to- 1. View product  2. View Cart  3. Contact Us  4. Exit");
				choice = sc.nextInt();
				if (choice == 1) {
					Catalogue catalogue = new Catalogue();
					Product[] allProducts = catalogue.getListofAllProducts();
					for (int i = 0; i < allProducts.length; i++) {
						System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName() + " "
								+ allProducts[i].getCost());

					}
					
					System.out.println("Do you want to add any product to the cart? Y/N");
					sc.nextLine();
					String addToCart=sc.nextLine();
					if(addToCart.equals("Y"))
					{
					System.out.println("Input the Products Id of the Product which you want to add to Cart.");
					String productId=sc.nextLine();
					Product [] cartProducts= new Product[1];
					for (int i=0; i<allProducts.length; i++) {
						if(allProducts[i].getProductId().equals(productId))
							cartProducts[0]=allProducts[i];
					}
					
					Cart cart=new Cart();
					cart.setCartId("1");
					cart.setListOfProducts(cartProducts);
//					System.out.println(cartProducts[0].getProductName());
					current.setCart(cart);
					System.out.println("The Product is successfully added to the cart");
					}
				}
				else if(choice==2) {
					Product [] cartProducts= current.getCart().getListOfProducts();
					System.out.println(current.getCart().getCartId());
					for (int i=0; i<cartProducts.length; i++) {
						System.out.println(i);
						System.out.println(cartProducts[i].getProductId() + " " + cartProducts[i].getProductName() + " "
								+ cartProducts[i].getCost());
						
					}
					
					System.out.println("Do you want to checkout? Y/N");
					sc.nextLine();
					String checkout=sc.nextLine();
					if(checkout.equals("Y"))
						if(current.getCart().checkOut())
//							Create an order object and assign this user to the order with an order id
							System.out.println("Your Order is placed successfully");
				}
				
				else if (choice==3) {
					System.out.println("To contact us, Please email on store@ecommerce.com");
				}
				
				else if(choice==4)
					break;
				
				else
					System.out.println("Invalid choice, please try again.");
			}
			}

		} 
		
		else if (choice == 2)
			typeOfUser = "Seller";
		else if (choice == 3)
			typeOfUser = "Admin";
		else
			System.out.println("Invalid input. Try again");

	}

}
