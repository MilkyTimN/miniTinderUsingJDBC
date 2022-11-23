package kg.megaco.miniTinder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Orders {
    private Long id;
    private Users senderId;
    private Users recipientId;
    private Boolean match;

    public Orders(Users senderId, Users recipientId, Boolean match) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.match = match;
    }
}
