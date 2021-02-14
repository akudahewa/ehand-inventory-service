package lk.ehand.inventoryservice.config;

import lk.ehand.inventoryservice.repository.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "classpath:application-${spring.profiles.active}.yml" })
public class WebConfig {
//    @Bean
//    public ItemRepository getItemRepository(){
//        return new Item
//    }
}
