package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetProductResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private String category;

    @JsonProperty("price")
    private double price;

    @JsonProperty("discountPercentage")
    private double discountPercentage;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("dimensions")
    private Dimensions dimensions;

    @JsonProperty("warrantyInformation")
    private String warrantyInformation;

    @JsonProperty("shippingInformation")
    private String shippingInformation;

    @JsonProperty("availabilityStatus")
    private String availabilityStatus;

    @JsonProperty("reviews")
    private List<Review> reviews;

    @JsonProperty("returnPolicy")
    private String returnPolicy;

    @JsonProperty("minimumOrderQuantity")
    private int minimumOrderQuantity;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("images")
    private List<String> images;

    @JsonProperty("thumbnail")
    private String thumbnail;
}