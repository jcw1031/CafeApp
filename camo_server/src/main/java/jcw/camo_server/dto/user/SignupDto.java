package jcw.camo_server.dto.user;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String email;
    private String password;
    private String name;
    private String phone;
}