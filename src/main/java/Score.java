import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {

	/**
		Construtor da classe Score.

		@param playerId uma string que identifica o player ao qual este placar está associado.
	*/

	private String playerId;
	private int score;
	private int align;
	private Color color;

	public Score(String playerId) {
		this.playerId = playerId;

		if(playerId.toLowerCase().equals("player 1")) {
			align = GameLib.ALIGN_LEFT;
			color = Color.GREEN;
		}
		else{
			align = GameLib.ALIGN_RIGHT;
			color = Color.BLUE;
		}
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.drawText(this.playerId+": "+score, 70, align);
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		this.score++;
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){

		return this.score;
	}
}
