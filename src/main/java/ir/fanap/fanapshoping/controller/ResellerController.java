package ir.fanap.fanapshoping.controller;

import ir.fanap.fanapshoping.dto.ResellerDTO;
import ir.fanap.fanapshoping.model.Reseller;
import ir.fanap.fanapshoping.service.ResellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reseller")
public class ResellerController {
    private final ResellerService resellerService;

    public ResellerController(ResellerService resellerService) {
        this.resellerService = resellerService;
    }


    @PostMapping
    public ResponseEntity<Reseller> createReseller(@RequestBody @Validated ResellerDTO resellerDTO) {
        Reseller reseller = resellerService.createReseller(resellerDTO);
        return new ResponseEntity<>(reseller, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reseller>> getAllReseller() {
        List<Reseller> resellerList = resellerService.getAllReseller();
        return new ResponseEntity<>(resellerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reseller> getReseller(@PathVariable Long id) {
        Reseller reseller = resellerService.getReseller(id);
        return new ResponseEntity<>(reseller, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseller(@PathVariable String id) {
        resellerService.deleteReseller(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<Reseller> updateReseller(@RequestBody ResellerDTO resellerDTO) {
        Reseller reseller = resellerService.createReseller(resellerDTO);
        return new ResponseEntity<>(reseller, HttpStatus.ACCEPTED);
    }
}
