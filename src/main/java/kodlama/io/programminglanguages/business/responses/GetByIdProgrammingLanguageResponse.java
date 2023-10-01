package kodlama.io.programminglanguages.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingLanguageResponse {
    private int id;
    private String name;
}
