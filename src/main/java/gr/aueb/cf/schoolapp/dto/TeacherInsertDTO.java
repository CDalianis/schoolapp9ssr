package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherInsertDTO(

        @NotNull(message = "Name cant be blank")
        @Size(min = 2,message = "Name should contain at least 2 letters")
        String firstname,

        @NotNull(message = "Lastname cant be blank")
        @Size(min = 2, message = "Lastname should be at least 2 letters")
        String lastname,

        @Pattern(regexp = "\\d{9,}", message = "AFM should be at least 9 digits")
        String vat,

        @NotNull(message = "Region cannot be blank")
        Long regionId


){
    public static TeacherInsertDTO empty() {
        return new TeacherInsertDTO("", "", "", 0L);
    }
}
