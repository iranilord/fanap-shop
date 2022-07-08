package ir.fanap.fanapshoping.service;

import ir.fanap.fanapshoping.model.Product;
import ir.fanap.fanapshoping.model.Reseller;
import ir.fanap.fanapshoping.model.Wallet;
import ir.fanap.fanapshoping.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void addProfit(Double commission, Reseller reseller, Product product) {
        Wallet wallet = new Wallet();
        wallet.setReseller(reseller);
        wallet.setProduct(product);
        wallet.setProfit(commission);
        walletRepository.save(wallet);
    }


}
