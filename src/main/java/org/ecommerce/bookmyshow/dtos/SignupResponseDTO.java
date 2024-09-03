package org.ecommerce.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.ecommerce.bookmyshow.models.User;

@Getter
@Setter
public class SignupResponseDTO {
    private User user;
    private ResponseStatus responseStatus;

}
