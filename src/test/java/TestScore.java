import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScore {

    @Test
    public void test(){
        Score score = new Score("player1");

        for(int i = 0; i<100; i++){
            score.getScore();
            assertEquals("Erro no incremento "+i,i,score.getScore(),0.0);
            score.inc();
            score.getScore();
        }

    }
}
