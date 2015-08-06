package akihyro.try3tierwebsystem;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/items")
public class ItemsController {

    public static List<Item> items = new ArrayList<>();

    @PostConstruct
    public void initItems() {
        postItem(Item.builder().itemName("鉄柱 5m").descriptions(asList("頑丈", "黒色", "細い", "短い")).build());
        postItem(Item.builder().itemName("鉄柱 15m").descriptions(asList("脆い", "黒色", "太い", "長い")).build());
        postItem(Item.builder().itemName("鉄柱 25m").descriptions(asList("超頑丈", "白色", "激太", "激長")).build());
    }

    @RequestMapping
    public List<Item> getItems() {
        return items;
    }

    @RequestMapping(value = "{itemId}")
    public Item getItem(@PathVariable Integer itemId) {
        return items.get(itemId - 1);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item postItem(@RequestBody Item item) {
        item.setItemId(items.size() + 1);
        items.add(item);
        return item;
    }

    @RequestMapping(value = "{itemId}", method = RequestMethod.PUT)
    public Item putItem(@PathVariable Integer itemId, @RequestBody Item item) {
        item.setItemId(itemId);
        items.set(itemId - 1, item);
        return item;
    }

}
