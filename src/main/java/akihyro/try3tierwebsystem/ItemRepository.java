package akihyro.try3tierwebsystem;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ItemRepository extends JpaRepository<Item, Integer>{
    @Query("SELECT u FROM Item u order by u.itemValue asc")
    public List<Item> findItemAsc();
}

