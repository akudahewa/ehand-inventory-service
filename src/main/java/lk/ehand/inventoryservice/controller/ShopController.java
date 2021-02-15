package lk.ehand.inventoryservice.controller;

import lk.ehand.inventoryservice.domain.Item;
import lk.ehand.inventoryservice.domain.Shop;
import lk.ehand.inventoryservice.exception.ResourceNotFoundException;
import lk.ehand.inventoryservice.repository.ItemRepository;
import lk.ehand.inventoryservice.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Slf4j
public class ShopController {

    private ShopRepository shopRepository;

    public  ShopController(ShopRepository shopRepository){
        this.shopRepository =shopRepository;
    }

    @PostMapping(value = "/shops", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop createShop(@RequestBody Shop shop){
        log.info("POST-> Shop create");
        return shopRepository.save(shop);
    }

    @GetMapping("/shops")
    public Page<Shop> getAllShops(Pageable pageable) {
        log.info("GET-> get all shops ");
        return shopRepository.findAll(pageable);
    }

    @DeleteMapping("/shops/{shopId}")
    public ResponseEntity<?> deletePost(@PathVariable Long shopId) {
        return shopRepository.findById(shopId).map(shop -> {
            shopRepository.delete(shop);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ShopId " + shopId + " not found"));
    }
}
