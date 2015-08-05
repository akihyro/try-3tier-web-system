package akihyro.try3tierwebsystem;

import java.util.List;

import lombok.Data;

@Data
public class Item {

    private Integer itemId;

    private String itemName;

    private List<String> descriptions;

}
