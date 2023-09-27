package kodlama.io.programminglanguages.dataAccess.concretes;


import kodlama.io.programminglanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programminglanguages.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguagesRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguageList;

    public InMemoryProgrammingLanguagesRepository() {
        programmingLanguageList = new ArrayList<ProgrammingLanguage>();
        programmingLanguageList.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguageList.add(new ProgrammingLanguage(2, "java"));
        programmingLanguageList.add(new ProgrammingLanguage(3, "Python"));
        programmingLanguageList.add(new ProgrammingLanguage(4, "C++"));

    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguageList.add(programmingLanguage);
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
        if(getById(programmingLanguage) != null){
            programmingLanguageList.remove(programmingLanguage);
            System.out.println("deleted");
        }
        else{
            throw new Exception("no language found to delete");
        }


    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {
        if(getById(programmingLanguage) != null) {
            programmingLanguage.setLanguage(programmingLanguage.getLanguage());
            System.out.println("updated");
        }
        else{
            throw  new Exception("language for id not found");
        }

    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageList;
    }

    @Override
    public ProgrammingLanguage getById(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage value : programmingLanguageList){
            if(value.getId()== programmingLanguage.getId()){
                return programmingLanguage;
            }
        }
        return null;
    }
}
