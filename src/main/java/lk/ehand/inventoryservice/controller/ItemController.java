package lk.ehand.inventoryservice.controller;

import lk.ehand.inventoryservice.domain.Item;
import lk.ehand.inventoryservice.repository.ItemRepository;
import lk.ehand.inventoryservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class ItemController {

//    @Autowired
//    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;
//    @Autowired
//    public  ItemController(ItemRepository itemRepository){
//        this.itemRepository =itemRepository;
//    }

    public String createItem(@RequestBody Item item){
//       log.info("POST-> Item create");
       return itemService.get();
    }
}
