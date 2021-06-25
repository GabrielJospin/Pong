import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestBall {

    @Test
    public void test(){
        Ball ball = new Ball(10,10,10,10, Color.BLACK,0.1);

        testMove(ball);

        testCheckCollisionWallRight(ball);
        testCheckCollisionWallLeft(ball);
        testCheckCollisionWallTop(ball);
        testCheckCollisionWallBottom(ball);

        testCheckCollisionPlayer(ball);

        testOnCollisionWall(ball);
        testOnCollisionPlayer(ball);

    }

    public void testMove(Ball ball){
        if(ball == null)
            fail("Erro ao criar construtor");

        assertEquals("Erro na posição X",10,ball.getCx(),0.0);
        assertEquals("Erro na posição Y",10,ball.getCy(),0.0);
        ball.update(10);
        assertEquals("Erro na posição X",11,ball.getCx(),0.0);
        assertEquals("Erro na posição Y",11,ball.getCy(),0.0);
        ball.update(-10);
    }

    public void testCheckCollisionWallRight(Ball ball){
        Wall wall = new Wall(21,10,2,20,Color.GRAY,"right");
        assertFalse("Erro: colidiu com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(51);
        assertTrue("Erro: nao colisao com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(-51);
    }

    public void testCheckCollisionWallLeft(Ball ball){
        Wall wall = new Wall(0,10,2,20,Color.GRAY,"left");
        assertFalse("Erro: colidiu com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(-51);
        assertTrue("Erro: nao colisao com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(51);
    }

    public void testCheckCollisionWallTop(Ball ball){
        Wall wall = new Wall(10,0,20,2,Color.GRAY,"top");
        assertFalse("Erro: colidiu com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(-51);
        assertTrue("Erro: nao colisao com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(51);
    }

    public void testCheckCollisionWallBottom(Ball ball){
        Wall wall = new Wall(10,21,20,2,Color.GRAY,"bottom");
        assertFalse("Erro: colidiu com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(51);
        assertTrue("Erro: nao colisao com a parede "+wall.getId(),ball.checkCollision(wall));
        ball.update(-51);
    }

    public void testCheckCollisionPlayer(Ball ball){
        double[] limit = {0,200};

        Player player = new Player(21,10,2,20,
                Color.GRAY,"right",limit,0.1);

        assertFalse("Erro: colidiu com a parede "+player.getId(),
                ball.checkCollision(player));

        ball.update(51);

        assertTrue("Erro: nao colisao com a parede "+player.getId(),
                ball.checkCollision(player));

        ball.update(-51);
    }

    public void testOnCollisionWall(Ball ball){
        double speedX;
        double speedY;

        //CASO DE TESTE LEFT

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onWallCollision("left");
        assertEquals("Erro na colisão left em X",-speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE RIGHT

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onWallCollision("right");
        assertEquals("Erro na colisão left em X",-speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE TOP

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onWallCollision("top");
        assertEquals("Erro na colisão left em X",speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",-speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE BOTTTOM

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onWallCollision("bottom");
        assertEquals("Erro na colisão left em X",speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",-speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE REPETIÇÂO

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onWallCollision("bottom");
        assertEquals("Erro na colisão left em X",speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);

    }

    public void testOnCollisionPlayer(Ball ball){
        double speedX;
        double speedY;

        //CASO DE TESTE NORMAL

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onPlayerCollision("player1");
        assertEquals("Erro na colisão left em X",-speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE REPETIÇÂO

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onPlayerCollision("player1");
        assertEquals("Erro na colisão left em X",speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);

        //CASO DE TESTE Player 2

        speedX = ball.getSpeed();
        speedY = ball.getSpeedY();

        ball.onPlayerCollision("player2");
        assertEquals("Erro na colisão left em X",-speedX,ball.getSpeed(),0.0);
        assertEquals("Erro na colisão left em Y",speedY,ball.getSpeedY(),0.0);
    }
}
