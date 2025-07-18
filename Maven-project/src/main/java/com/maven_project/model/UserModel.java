package com.maven_project.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserModel {
    private int code;
    private String userName;
    private LocalDate birthday;
}
