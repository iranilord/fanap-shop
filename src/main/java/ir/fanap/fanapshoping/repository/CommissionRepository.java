package ir.fanap.fanapshoping.repository;

import ir.fanap.fanapshoping.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {


    Optional<Commission> findByResellerIdAndProductId(Long resellerId, Long productId);

}
