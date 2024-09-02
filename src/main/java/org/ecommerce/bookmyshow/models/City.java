package org.ecommerce.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;


    // optional
    // private List<Theatre> theatreList;
}
