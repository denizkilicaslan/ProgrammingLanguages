package kodlama.io.programminglanguages.dataAccess.abstracts;

import kodlama.io.programminglanguages.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    void add(ProgrammingLanguage programmingLanguage);

    void update(ProgrammingLanguage programmingLanguage) throws Exception;

    void delete(ProgrammingLanguage programmingLanguage) throws Exception;

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(ProgrammingLanguage programmingLanguage);


}
