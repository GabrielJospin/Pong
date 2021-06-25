import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestPlayer {

    @Test
    public void test(){
        double[] limit = {0,200};
        Player player = new Player(10,10,2,2,
                Color.BLACK,"player",limit,0.1);
        testMove(player);
    }

    public void testMove(Player player){

        if(player == null)
            fail("Falha na criação do objeto");

        assertEquals("Falha na posição X", 10, player.getCx(), 0.0);
        assertEquals("Falha na posição Y", 10, player.getCy(), 0.0);
        player.moveUp(10);
        assertEquals("Erro no método moveUp",9,player.getCy(),0.0);
        player.moveDown(20);
        assertEquals("Erro no método moveDown",11,player.getCy(),0.0);
    }


}
