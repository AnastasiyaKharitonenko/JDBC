package config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class University {

    private Long id;
    private String name;
    private String lastname;
    private Long passportID, departmentID;
}
