package akihyro.try3tierwebsystem;


import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer>{
}
