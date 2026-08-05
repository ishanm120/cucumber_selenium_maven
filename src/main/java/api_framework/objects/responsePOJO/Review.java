package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Review {

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("date")
    private String date;

    @JsonProperty("reviewerName")
    private String reviewerName;

    @JsonProperty("reviewerEmail")
    private String reviewerEmail;
}
