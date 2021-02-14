package lk.ehand.inventoryservice.controller;

import lk.ehand.inventoryservice.domain.Item;
import lk.ehand.inventoryservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@Slf4j
public class ItemController {

    private ItemRepository itemRepository;

    public  ItemController(ItemRepository itemRepository){
        this.itemRepository =itemRepository;
    }

    @PostMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item createItem(@RequestBody Item item){
        log.info("POST-> Item create");
        return itemRepository.save(item);
    }

    @GetMapping(value = "/item",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll(@RequestParam(required = true) int shopId){
        log.info("GET->Item retrieve,shopId:{}",shopId);
        return itemRepository.findAll();
    }
}
