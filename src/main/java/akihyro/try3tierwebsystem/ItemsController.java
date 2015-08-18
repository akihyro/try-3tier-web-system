package akihyro.try3tierwebsystem;

import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @PostConstruct
    public void initItems() {
         postItem(Item.builder().itemName("鉄柱 5m").descriptions(asList("頑丈", "黒色", "細い", "短い")).build());
        postItem(Item.builder().itemName("鉄柱 15m").descriptions(asList("脆い", "黒色", "太い", "長い")).build());
        postItem(Item.builder().itemName("鉄柱 25m").descriptions(asList("超頑丈", "白色", "激太", "激長")).build());
    }

    @RequestMapping
    public Collection<Item> getItems() {
        return itemService.findAll();
    }

    @RequestMapping(value = "{itemId}")
    public Item getItem(@PathVariable Integer itemId) {
        return itemService.findOne(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item postItem(@RequestBody Item item) {
        itemService.update(item);
        return item;
    }

    @RequestMapping(value = "{itemId}", method = RequestMethod.PUT)
    public Item putItem(@PathVariable Integer itemId, @RequestBody Item item) {
        itemService.create(item);
        return item;
    }

    @RequestMapping(value = "{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer itemId) {
        itemService.delete(itemId);
    }

}

