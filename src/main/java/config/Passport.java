package config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor


public class Passport {
    private Long id;
    private Long series;
    private Long number;
    private String departmentCode;
}
