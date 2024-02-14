package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class GetProductResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private String price;

    @JsonProperty("discountPercentage")
    private String discountPercentage;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("stock")
    private String stock;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("category")
    private String category;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("images")
    private ArrayList<String> images;


}
