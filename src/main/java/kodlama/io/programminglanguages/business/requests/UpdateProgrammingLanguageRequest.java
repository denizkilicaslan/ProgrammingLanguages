package kodlama.io.programminglanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {
    private int id;

    private String name;
}
