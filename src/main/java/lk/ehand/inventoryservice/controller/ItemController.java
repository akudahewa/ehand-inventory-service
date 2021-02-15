package lk.ehand.inventoryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Slf4j
public class ItemController {

    private ItemRepository itemRepository;
    private ShopRepository shopRepository;

    public  ItemController(ItemRepository itemRepository,ShopRepository shopRepository){
        this.itemRepository = itemRepository;
        this.shopRepository = shopRepository;
    }

    @PostMapping(value = "/shops/{shopId}/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item createItem(@PathVariable(value = "shopId") Long shopId,@RequestBody Item item) {
        log.info("POST-> Item create:{}",shopId);
        return shopRepository.findById(shopId).map(shop->{
            item.setShop(shop);
            return itemRepository.save(item);
        }).orElseThrow(()->new ResourceNotFoundException(" shopId not found"));
//         Optional<Shop> shop= shopRepository.findById(shopId);
//        System.out.println("////////////////////////// "+shop.get());
//             item.setShop(shop.get());
////         });
//         return itemRepository.save(item);


        //}).orElseThrow(()->new ResourceNotFoundException("Item","shopId","shopId not found"));
    }

    @GetMapping(value = "/shops/{shopId}/items",produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Item> getAll(@PathVariable(value = "shopId") Long shopId, Pageable page){
        log.info("GET->Item retrieve,shopId:{}|page :{}",shopId,page);
        return itemRepository.findByShopId(shopId,page);
    }

    @DeleteMapping("/shops/{shopId}/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable (value = "shopId") Long shopId,
                                           @PathVariable (value = "itemId") Long itemId) {
        return itemRepository.findByIdAndShopId(itemId, shopId).map(item -> {
            itemRepository.delete(item);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + itemId + " and shopId " + shopId));
    }
}
