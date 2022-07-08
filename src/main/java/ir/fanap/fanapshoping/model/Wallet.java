package ir.fanap.fanapshoping.model;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double profit;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Reseller reseller;

    private Boolean received = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", profit=" + profit +
                ", product=" + product +
                ", reseller=" + reseller +
                ", received=" + received +
                '}';
    }
}
