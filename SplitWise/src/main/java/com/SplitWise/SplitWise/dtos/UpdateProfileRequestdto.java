package com.SplitWise.SplitWise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequestdto {
    private long userId;
    private String email;
    private String phoneNo;

}
