package akihyro.try3tierwebsystem;

import static java.util.Arrays.asList;
import java.util.Collection;

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
        postItem(Item.builder().itemName("鉄柱 5m").itemValue(Integer.valueOf("5")).descriptions("頑丈").build());
        postItem(Item.builder().itemName("鉄柱 15m").itemValue(Integer.valueOf("15")).descriptions("脆い").build());
        postItem(Item.builder().itemName("鉄柱 25000m").itemValue(Integer.valueOf("25000")).descriptions("超頑丈").build());
        postItem(Item.builder().itemName("鉄柱 5000000m").itemValue(Integer.valueOf("5000000")).descriptions("頑丈").build());
        postItem(Item.builder().itemName("鉄柱 150m").itemValue(Integer.valueOf("150")).descriptions("脆い").build());
        postItem(Item.builder().itemName("鉄柱 2500m").itemValue(Integer.valueOf("2500")).descriptions("超頑丈").build());
        postItem(Item.builder().itemName("鉄柱 50000m").itemValue(Integer.valueOf("50000")).descriptions("頑丈").build());
        postItem(Item.builder().itemName("鉄柱 150000m").itemValue(Integer.valueOf("150000")).descriptions("脆い").build());
        postItem(Item.builder().itemName("鉄柱 2500m").itemValue(Integer.valueOf("2500")).descriptions("超頑丈").build());
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
