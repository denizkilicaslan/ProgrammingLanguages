package kodlama.io.programminglanguages.business.concretes;

import kodlama.io.programminglanguages.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programminglanguages.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.programminglanguages.core.utilities.mappers.ModelMapperService;
import kodlama.io.programminglanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programminglanguages.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ModelMapperService modelMapperService;

//    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
//        this.programmingLanguageRepository = programmingLanguageRepository;
//    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

        if (createProgrammingLanguageRequest.getName() == null) {
            throw new Exception("Empty value cannot be made");
        }

        for (ProgrammingLanguage value : programmingLanguageRepository.findAll()) {
            if (createProgrammingLanguageRequest.getName() == value.getName()) {
                throw new Exception("Existing language cannot be added again");
            }


//            programmingLanguageRepository.add(programmingLanguage);
            ProgrammingLanguage language = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
            this.programmingLanguageRepository.save(language);
            System.out.println("Added");

        }
    }

    @Override
    public void delete(int id) throws Exception {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage language = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(language);
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findAll();

        List<GetAllProgrammingLanguagesResponse> responseList = programmingLanguage.stream()
                .map(language -> this.modelMapperService.forResponse().map(programmingLanguage, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
        return responseList;

    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage language=programmingLanguageRepository.getById(id);
        GetByIdProgrammingLanguageResponse response = this.modelMapperService.forResponse().map(language,GetByIdProgrammingLanguageResponse.class);
        return response;
    }
}
