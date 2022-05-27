package com.example.Swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description ="Detail about the Contact")
public class Contact {
    @ApiModelProperty(notes = "Unique id of the contact")
    private String Id;
    @ApiModelProperty(notes = "Name of the person")
    private String name;
    @ApiModelProperty(notes = "Phone Number")
    private String phone;
}
