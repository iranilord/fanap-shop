package ir.fanap.fanapshoping.controller;

import ir.fanap.fanapshoping.dto.BuyDTO;
import ir.fanap.fanapshoping.service.BuyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buy")
public class BuyController {
    private final BuyService buyService;


    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }


    @GetMapping
    public ResponseEntity<BuyDTO> buyProductWithReseller(@RequestParam Long productId ,  @RequestParam Long resellerId){
        BuyDTO buyDTO = buyService.buyProductWithReseller(productId,resellerId);
        return new ResponseEntity<>(buyDTO,HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<BuyDTO> buyProduct(@PathVariable Long productId){
        BuyDTO buyDTO = buyService.buyProduct(productId);
        return new ResponseEntity<>(buyDTO,HttpStatus.OK);
    }
}
