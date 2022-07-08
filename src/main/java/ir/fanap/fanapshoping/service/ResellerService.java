package ir.fanap.fanapshoping.service;

import ir.fanap.fanapshoping.dto.ResellerDTO;
import ir.fanap.fanapshoping.model.Reseller;
import ir.fanap.fanapshoping.repository.ResellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ResellerService {

    private final ResellerRepository resellerRepository;


    public ResellerService(ResellerRepository resellerRepository) {
        this.resellerRepository = resellerRepository;
    }

    @Transactional
    public Reseller createReseller(ResellerDTO resellerDTO) {
        Reseller reseller = new Reseller();
        if (resellerDTO.getId() != null)
            reseller = getReseller(resellerDTO.getId());

        reseller.setName(resellerDTO.getName());
        reseller.setUserName(resellerDTO.getUserName());
        return resellerRepository.save(reseller);
    }

    @Transactional
    public List<Reseller> getAllReseller() {
        return resellerRepository.findAll();
    }

    @Transactional
    public Reseller getReseller(Long id) {
        Optional<Reseller> reseller = resellerRepository.findById(id);
        return reseller.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reseller Not Find !"));
    }

    @Transactional
    public void deleteReseller(String id) {
        resellerRepository.deleteById(Long.parseLong(id));
    }
}
