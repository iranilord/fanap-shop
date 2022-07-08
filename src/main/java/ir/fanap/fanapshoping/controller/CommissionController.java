package ir.fanap.fanapshoping.controller;

import ir.fanap.fanapshoping.dto.CommissionDTO;
import ir.fanap.fanapshoping.model.Commission;
import ir.fanap.fanapshoping.service.CommissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commission")
public class CommissionController {

    private final CommissionService commissionService;


    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }


    @PostMapping
    public ResponseEntity<Commission> createCommission(@RequestBody @Validated CommissionDTO commissionDTO) {
        Commission commission = commissionService.createCommission(commissionDTO);
        return new ResponseEntity<>(commission, HttpStatus.CREATED);
    }

    @GetMapping("/getBy")
    public ResponseEntity<Commission> getCommission(@RequestParam Long resellerID ,@RequestParam Long productID ) {
        Commission commission = commissionService.getCommission(resellerID,productID);
        return new ResponseEntity<>(commission, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Commission>> getAllCommission() {
        List<Commission> allCommission = commissionService.getAllCommission();
        return new ResponseEntity<>(allCommission, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable String id) {
        commissionService.deleteCommission(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping()
    public ResponseEntity<Commission> updateCommission(@RequestBody CommissionDTO commissionDTO) {
        Commission commission = commissionService.createCommission(commissionDTO);
        return new ResponseEntity<>(commission, HttpStatus.ACCEPTED);
    }

}
