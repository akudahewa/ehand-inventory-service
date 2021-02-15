package lk.ehand.inventoryservice.repository;

import lk.ehand.inventoryservice.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Page<Item> findByShopId(Long shopId, Pageable pageable);
    Optional<Item> findByIdAndShopId(Long id, Long shopId);
}
