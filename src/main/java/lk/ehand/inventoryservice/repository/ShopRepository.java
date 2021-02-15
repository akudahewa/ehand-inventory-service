package lk.ehand.inventoryservice.repository;

import lk.ehand.inventoryservice.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {

}
