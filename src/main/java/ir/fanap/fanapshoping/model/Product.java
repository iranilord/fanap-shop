package ir.fanap.fanapshoping.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "interview_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    @Override
    public String toString() {

        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

