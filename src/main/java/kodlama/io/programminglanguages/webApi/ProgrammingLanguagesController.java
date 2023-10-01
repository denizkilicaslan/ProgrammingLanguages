package kodlama.io.programminglanguages.webApi;


import kodlama.io.programminglanguages.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programmingLanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {


    private ProgrammingLanguageService programmingLanguageService;

//    @Autowired
//    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
//        this.programmingLanguageService = programmingLanguageService;
//    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageService.getAll();
    }


    @PostMapping(path = "/add")
    public void addProgrammingLanguage(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @GetMapping(path = "/getById/{id}")
    public GetByIdProgrammingLanguageResponse getById(@RequestParam int id) {
        return programmingLanguageService.getById(id);
    }


    @PostMapping(path = "/update")
    public void update( @RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }
}
