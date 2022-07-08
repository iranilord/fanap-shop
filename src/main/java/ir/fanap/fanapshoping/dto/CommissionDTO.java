package ir.fanap.fanapshoping.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CommissionDTO {
    private Long id;
    @Min(1)
    @NotNull
    private Long productId;
    @Min(1)
    @NotNull
    private Long resellerId;
    @Min(1)
    @NotNull
    private Double profit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }



    @Override
    public String toString() {
        return "CommissionDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", resellerId=" + resellerId +
                ", profit=" + profit +
                '}';
    }
}
