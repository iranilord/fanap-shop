package ir.fanap.fanapshoping.dto;

import javax.validation.constraints.NotBlank;

public class ResellerDTO {

    private Long id;
    @NotBlank
    private String userName;
    @NotBlank
    private String name;


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
        return "ResellerDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
