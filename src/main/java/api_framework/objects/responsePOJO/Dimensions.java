package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Dimensions {

    @JsonProperty("width")
    private double width;

    @JsonProperty("height")
    private double height;

    @JsonProperty("depth")
    private double depth;
}
