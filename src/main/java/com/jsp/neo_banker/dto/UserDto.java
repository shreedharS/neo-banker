

// package com.jsp.neo_banker.dto;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;

// public class UserDto {

//     //@NotBlank(message = "* Name is required")
//     private String name;

//     @NotNull(message = "* Email is required")
//     @Email(message = "* Invalid email format")
//     private String email;

//     @NotBlank(message = "* Mobile is required")
//     @Pattern(regexp = "^[6-9]\\d{9}$", message = "* Mobile number must be 10 digits and start with 6-9")
//     private String mobile;

//     @NotBlank(message = "* Password is required")
//     @Size(min = 6, message = "* Password must be at least 6 characters")
//     private String password;

//     @NotBlank(message = "* Confirm Password is required")
//     private String confirmPassword;

//     // Getters and Setters
//     // ...existing code...


//     // Getters and Setters
//     // (Can be generated or use Lombok @Data)
    
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getMobile() { return mobile; }
//     public void setMobile(String mobile) { this.mobile = mobile; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getConfirmPassword() { return confirmPassword; }
//     public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
// }



package com.jsp.neo_banker.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    @Size(min = 3, max = 20, message = "* Name should be 3~20 charecters")
    private String name;
    @Email(message = "* Enter Proper Email format")
    @NotEmpty(message = "* It is required Field")
    private String email;
    @DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
    @DecimalMax(value = "9999999999", message = "* Enter Proper Mobile Number")
    @NotNull(message = "* It is required Field")
    private Long mobile;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter atleast 8 charecter consisting of one number , one uppercase, one lowercase and one special charecter")
    private String password;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Enter atleast 8 charecter consisting of one number , one uppercase, one lowercase and one special charecter")
    private String confirmPassword;
    @AssertTrue(message = "* Check the terms before continuing")
    private boolean terms;
}
