package kz.dar.academy.postcoreapi.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private String postId;
    @NotNull
    private String clientId;
    @NotNull
    private String postRecipientId;
    @NotNull
    private String postItem;
    private String status;
}
