package ir.fanap.fanapshoping.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("reseller")
public class Reseller extends User  implements Serializable {



    @Override
    public String toString() {

        return "Reseller [ getId()=" + getId() + ", getUsername()=" + getUserName() + ", getName()=" + getName() + "]";
    }


}