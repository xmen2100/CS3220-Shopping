package cs3220.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs3220.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
