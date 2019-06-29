package xyz.randomwords.app;

import org.junit.Test;
import xyz.randomwords.app.configuration.DixConfig;
import xyz.randomwords.app.serive.RandomWordGenerator;

public class RandomWordGeneratorTest {

    private DixConfig dixConfig = new DixConfig();
    private RandomWordGenerator randomWordGenerator = new RandomWordGenerator();

    public RandomWordGeneratorTest(){
        randomWordGenerator.setDix( dixConfig );
    }

    @Test
    public void testRandomWordGenerator(){

        System.out.println( randomWordGenerator.generate("", 5) );
    }
}
