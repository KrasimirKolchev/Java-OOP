package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();
        cart.add(new OrderItem("asd", 6));
        cart.add(new OrderItem("asd", 5));
        cart.add(new OrderItem("asd", 4));

        Order order = new OnlineOrder(cart, "ajhfha");

        System.out.println(order.getTotalAmount());
    }
}
