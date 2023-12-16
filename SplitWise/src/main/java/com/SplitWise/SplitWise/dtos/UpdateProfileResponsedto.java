package com.SplitWise.SplitWise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileResponsedto {

    private String email;
    private String phoneNo;
    private ResponseStatus responseStatus;

}
