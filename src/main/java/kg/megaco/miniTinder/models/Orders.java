package kg.megaco.miniTinder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Orders {
    private Long id;
    private Users senderId;
    private Users recipientId;
    private String message;
    private Boolean match;

    public Orders(Users senderId, Users recipientId, String message, Boolean match) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
        this.match = match;
    }
}
