
// package com.jsp.neo_banker.entity;

// import com.jsp.neo_banker.dto.UserDto;
// import jakarta.persistence.*;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     private String name;
//     private String email;
//     private String mobile;
//     private String password;

//     public User() {}

//     public User(UserDto dto) {
//         this.name = dto.getName();
//         this.email = dto.getEmail();
//         this.mobile = dto.getMobile();
//         this.password = dto.getPassword();
//     }

//     // Getters and Setters (or use Lombok @Data)
// }



package com.jsp.neo_banker.entity;

import com.jsp.neo_banker.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private Long mobile;
    @Column(nullable = false)
    private String password;

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.mobile = userDto.getMobile();
    }
}


