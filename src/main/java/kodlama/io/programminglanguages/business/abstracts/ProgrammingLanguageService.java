package kodlama.io.programminglanguages.business.abstracts;

import kodlama.io.programminglanguages.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void add(ProgrammingLanguage programmingLanguage) throws Exception;

    void update(int id, ProgrammingLanguage programmingLanguage) throws Exception;

    void delete(int id) throws Exception;

    ProgrammingLanguage getById(int id);

    List<ProgrammingLanguage> getAll();

}

