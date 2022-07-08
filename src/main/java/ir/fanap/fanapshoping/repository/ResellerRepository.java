package ir.fanap.fanapshoping.repository;

import ir.fanap.fanapshoping.model.Reseller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller, Long> {
}
