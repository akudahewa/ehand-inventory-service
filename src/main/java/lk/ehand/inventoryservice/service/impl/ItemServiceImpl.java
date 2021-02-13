package lk.ehand.inventoryservice.service.impl;

import lk.ehand.inventoryservice.repository.ItemRepository;
import lk.ehand.inventoryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Override
    public String get() {
//        itemRepository.getOne(new Long(2));
        return null;
    }
}
