package akihyro.try3tierwebsystem;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private Integer itemId;

    private String itemName;

    private List<String> descriptions;

}
