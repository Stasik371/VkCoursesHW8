package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import generated.tables.Products;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty("id")
    private int id;
    @JsonProperty("nameOfOrganization")
    private String nameOfOrganization;
    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private int amount;

    @JsonCreator
    public Product(@JsonProperty(value = "id", required = true) int id,
                   @JsonProperty(value = "name", required = true) String name,
                   @JsonProperty(value = "nameOfOrganization", required = true) String nameOfOrganization,
                   @JsonProperty(value = "amount", required = true) Integer amount) {
        this.id = id;
        this.name = name;
        this.nameOfOrganization = nameOfOrganization;
        this.amount = amount;
    }

}
