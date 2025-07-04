public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 200, 11, 0.5);        
        Product biscuits = new Biscuits("Biscuits", 100, 14, 0.7);  
        Product card = new ScratchCard("Scratch Card", 50, 300);

        Customer customer = new Customer(2000);

        customer.addToCart(cheese, 3);      
        customer.addToCart(biscuits, 2);  
        customer.addToCart(card, 3); 

        try {
            customer.checkout();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}