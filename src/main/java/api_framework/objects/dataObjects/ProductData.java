package api_framework.objects.dataObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductData {
    private String title;
    private String description;
    private String price;
    private String discountPercentage;
    private String rating;
    private String stock;
    private String brand;
    private String category;
    private String thumbnail;
    private ArrayList<String> images;
}
