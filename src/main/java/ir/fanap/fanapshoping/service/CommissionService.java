package ir.fanap.fanapshoping.service;

import ir.fanap.fanapshoping.dto.CommissionDTO;
import ir.fanap.fanapshoping.model.Commission;
import ir.fanap.fanapshoping.model.Product;
import ir.fanap.fanapshoping.model.Reseller;
import ir.fanap.fanapshoping.repository.CommissionRepository;
import ir.fanap.fanapshoping.repository.ProductRepository;
import ir.fanap.fanapshoping.repository.ResellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;
    private final ResellerRepository resellerRepository;
    private final ProductRepository productRepository;


    public CommissionService(CommissionRepository commissionRepository, ResellerRepository resellerRepository, ProductRepository productRepository) {
        this.commissionRepository = commissionRepository;
        this.resellerRepository = resellerRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Commission createCommission(CommissionDTO commissionDTO) {
        Commission com = new Commission();
        if (commissionDTO.getId() != null)
            com = getCommission(commissionDTO.getResellerId(), commissionDTO.getProductId());

        Commission commission = convertCommissionDTOCommission(commissionDTO, com);

        return commissionRepository.save(commission);
    }

    @Transactional
    public Commission getCommission(Long resellerID, Long productID) {
        Optional<Commission> byId = commissionRepository.findByResellerIdAndProductId(resellerID, productID);
        Commission commission = byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Commission ID!"));
        return commission;
    }

    @Transactional
    public List<Commission> getAllCommission() {
        List<Commission> all = commissionRepository.findAll();
        return all;
    }

    @Transactional
    public void deleteCommission(String id) {
        commissionRepository.deleteById(Long.parseLong(id));
    }


    private Commission convertCommissionDTOCommission(CommissionDTO commissionDTO, Commission commission) {
        uniqueInsert(commissionDTO);
        Reseller reseller = getReseller(commissionDTO.getResellerId());
        Product product = getProduct(commissionDTO.getProductId());

        commission.setProfit(commissionDTO.getProfit());
        commission.setReseller(reseller);
        commission.setProduct(product);

        return commission;
    }


    private Reseller getReseller(Long id) {
        Optional<Reseller> reseller = resellerRepository.findById(id);
        Reseller res = reseller.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Reseller ID!"));
        return res;
    }

    private Product getProduct(Long id) {
        Optional<Product> productRepositoryById = productRepository.findById(id);
        Product product = productRepositoryById.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product ID!"));
        return product;
    }

    private void uniqueInsert(CommissionDTO commissionDTO) {
        Optional<Commission> byResellerIdAndProductId = commissionRepository.findByResellerIdAndProductId(commissionDTO.getResellerId(), commissionDTO.getProductId());
        if (byResellerIdAndProductId.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This reseller and product is already imported");
    }

}
