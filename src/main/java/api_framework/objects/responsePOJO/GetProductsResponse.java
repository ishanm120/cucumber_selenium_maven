package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetProductsResponse {

    @JsonProperty("products")
    private List<GetProductResponse> getProductResponses;

    @JsonProperty("total")
    private String total;

    @JsonProperty("skip")
    private String skip;

    @JsonProperty("limit")
    private String limit;
}
