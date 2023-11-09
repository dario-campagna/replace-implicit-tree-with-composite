package sdm.shop;

import sdm.shop.order.Order;
import sdm.shop.order.Orders;
import sdm.shop.product.Product;
import sdm.shop.product.ProductSize;

public class OrdersWriter {
    private final Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder xml = new StringBuilder();
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            for (int j = 0; j < order.getProductCount(); j++) {
                Product product = order.getProduct(j);
                xml.append("<product");
                xml.append(" id='");
                xml.append(product.getID());
                xml.append("'");
                xml.append(" color='");
                xml.append(product.getColor());
                xml.append("'");
                if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                    xml.append(" size='");
                    xml.append(product.getSize());
                    xml.append("'");
                }
                xml.append(">");
                xml.append("<price");
                xml.append(" currency='");
                xml.append(product.getCurrency());
                xml.append("'>");
                xml.append(product.getPrice());
                xml.append("</price>");
                xml.append(product.getName());
                xml.append("</product>");
            }
            xml.append("</order>");
        }
        xml.append("</orders>");
        return xml.toString();
    }

}
