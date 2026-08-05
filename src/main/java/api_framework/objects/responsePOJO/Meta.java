package api_framework.objects.responsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Meta {

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("qrCode")
    private String qrCode;
}
