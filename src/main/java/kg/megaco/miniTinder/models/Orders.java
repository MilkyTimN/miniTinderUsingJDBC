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

    @Override
    public String toString() {
        return
                "Order id: " + id + "\n" +
                "   Sender: " + senderId + "\n" +
                "   RecipientId: " + recipientId + "\n" +
                "   Message: " + message + "\n" +
                "   Match: " + match + "\n" +
                "----------";
    }
}
