package com.SplitWise.SplitWise.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNo;
    private String password;
}
