package ir.fanap.fanapshoping.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Commission implements Serializable {


    @EmbeddedId
    private CommissionId id = new CommissionId();

    @ManyToOne
    @MapsId("resellerId")
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    private Double profit = 0.0;


    public Commission() {
    }


    public CommissionId getId() {
        return id;
    }

    public void setId(CommissionId id) {
        this.id = id;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Commission{" +
                "id=" + id +
                ", reseller=" + reseller +
                ", product=" + product +
                ", profit=" + profit +
                '}';
    }
}
