package ir.fanap.fanapshoping.dto;

import ir.fanap.fanapshoping.model.Product;

public class BuyDTO {
    private Product product;
    private String message;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BuyDTO{" +
                "product=" + product +
                ", message='" + message + '\'' +
                '}';
    }
}
