package cs3220.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs3220.model.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
