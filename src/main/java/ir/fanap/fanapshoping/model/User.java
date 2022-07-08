package ir.fanap.fanapshoping.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected @NotNull @Column(unique = true ,updatable = false) String userName;
    protected @NotNull String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
