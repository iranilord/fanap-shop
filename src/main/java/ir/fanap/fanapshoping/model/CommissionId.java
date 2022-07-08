package ir.fanap.fanapshoping.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommissionId implements Serializable {


    @Column(name = "product_id")
    private Long productId;


    @Column(name = "reseller_id")
    private Long resellerId;


    public CommissionId(Long productId, Long resellerId) {
        this.productId = productId;
        this.resellerId = resellerId;
    }

    public CommissionId() {

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getResellerId() {
        return resellerId;
    }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommissionId that = (CommissionId) o;
        return productId.equals(that.productId) && resellerId.equals(that.resellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, resellerId);
    }
}
