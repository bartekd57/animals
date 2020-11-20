package pl.bykowski;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class AnimalControllerTest2 {

    @Mock
    AnimalRepo animalRepo;

    @InjectMocks
    AnimalController animalController;

    @BeforeEach
    public void inits() {
        MockitoAnnotations.openMocks(this);
    }
    @Before
    public void init(){
        given(animalRepo.findAll()).willReturn(prepareMockData());
    }

    @Test
    void getAnimals() {
        List<Animal> animals = animalController.getAnimals();
        //then
        Assert.assertEquals(animals.size(),2);
    }

    @Test
    void addAnimal() {
    }


    public List<Animal> prepareMockData(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cat"));
        animals.add(new Animal("dog"));
        return animals;
    }


}