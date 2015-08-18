package akihyro.try3tierwebsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findItemAsc();
    }
    public Item findOne(Integer id) {
        return itemRepository.findOne(id);
    }
    public Item create(Item item) {
        return itemRepository.save(item);
    }
    public Item update(Item item) {
        return itemRepository.save(item);
    }
    public void delete(Integer id) {
        itemRepository.delete(id);
    }

}
