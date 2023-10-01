package kodlama.io.programminglanguages.business.abstracts;

import kodlama.io.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.programminglanguages.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

    void delete(int id) throws Exception;

    GetByIdProgrammingLanguageResponse getById(int id);

    List<GetAllProgrammingLanguagesResponse> getAll();

}

