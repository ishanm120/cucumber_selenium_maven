package api_framework.objects.requestsPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;

}
