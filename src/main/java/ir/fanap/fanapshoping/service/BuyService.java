package ir.fanap.fanapshoping.service;

import ir.fanap.fanapshoping.dto.BuyDTO;
import ir.fanap.fanapshoping.model.Commission;
import ir.fanap.fanapshoping.model.Product;
import ir.fanap.fanapshoping.model.Reseller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyService {
    private final ProductService productService;
    private final ResellerService resellerService;
    private final CommissionService commissionService;
    private final WalletService walletService;

    public BuyService(ProductService productService, ResellerService resellerService, CommissionService commissionService, WalletService walletService) {
        this.productService = productService;
        this.resellerService = resellerService;
        this.commissionService = commissionService;
        this.walletService = walletService;
    }
    @Transactional
    public BuyDTO buyProduct(Long productId) {
        Product product = findProduct(productId);
        BuyDTO buyDTO = new BuyDTO();
        buyDTO.setProduct(product);
        buyDTO.setMessage("Your purchase was successful !");
        return buyDTO;
    }
    @Transactional
    public BuyDTO buyProductWithReseller(Long productId, Long resellerId) {
        Reseller reseller = findReseller(resellerId);
        Product product = findProduct(productId);
        Double commission = findCommission(productId, resellerId);

        walletService.addProfit(commission, reseller, product);


        BuyDTO buyDTO = new BuyDTO();
        buyDTO.setProduct(product);
        buyDTO.setMessage("Your purchase was successful !");
        return buyDTO;
    }


    private Reseller findReseller(Long id) {
        Reseller reseller = resellerService.getReseller(id);
        return reseller;
    }

    private Product findProduct(Long id) {
        Product product = productService.getProduct(String.valueOf(id));
        return product;
    }

    private Double findCommission(Long productId, Long resellerId) {
        Commission commission = commissionService.getCommission(resellerId, productId);
        Double profit = commission.getProfit();
        Integer price = commission.getProduct().getPrice();
        return price * (profit / 100);
    }


}
