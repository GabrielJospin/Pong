import java.awt.*;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {

	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/

	double cx;
	double cy;
	double width;
	double height;
	Color color;
	double speedX;
	double speedY;

	public Ball(double cx, double cy, double width, double height, Color color, double speed) {
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speedX = speed;
		this.speedY = speed;
	}

	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){

		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta) {
		double moveX = this.speedX * delta;
		double moveY = this.speedY * delta;
		this.cx = cx + moveX;
		this.cy = cy + moveY;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){
		this.speedX = -this.speedX;
		this.speedY = -this.speedY;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId){
		if(wallId.toLowerCase().equals("left") || wallId.toLowerCase().equals("right"))
			this.speedX = -this.speedX;
		else
			this.speedY = -this.speedY;
	}

	/**
		Método que verifica se houve colisão da bola com uma parede.

		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/
	
	public boolean checkCollision(Wall wall){
		if(wall.getId().toLowerCase().equals("left"))
			return this.cx - wall.getWidth() <= wall.getCx();
		if(wall.getId().toLowerCase().equals("right"))
			return this.cx + wall.getWidth() >= wall.getCx();
		if(wall.getId().toLowerCase().equals("top"))
			return this.cy - wall.getHeight() <= wall.getCy();
		if(wall.getId().toLowerCase().equals("bottom"))
			return this.cy + wall.getHeight() >= wall.getCy();

		System.out.println("Wall id ="+wall.getId());
		return false;
	}

	/**
		Método que verifica se houve colisão da bola com um jogador.

		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/	

	public boolean checkCollision(Player player){
		if(this.cy + this.height/2 <= player.getCy() - player.getHeight()/2)
			return false;
		if(this.cy - this.height/2 >= player.getCy() + player.getHeight()/2)
			return false;
		if(this.cx + this.width/2 <= player.getCx() - player.getWidth()/2)
			return false;
		if(this.cx - this.width/2 >= player.getCx() + player.getWidth()/2)
			return false;

		return true;
	}

	/**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/
	
	public double getCx(){

		return this.cx;
	}

	/**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

	public double getCy(){

		return this.cy;
	}

	/**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.

	*/

	public double getSpeed(){

		return this.speedX;
	}

}
