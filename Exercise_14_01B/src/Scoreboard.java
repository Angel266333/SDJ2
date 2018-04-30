public class Scoreboard implements Observer {
	private FootballGame game;

	public Scoreboard(FootballGame game) {
		this.game = game;
		showScore();
	}

	public void showScore() {

		System.out.println("SCOREBOARD: " + game.getScore());
	}

	@Override
	public void update(Observable o, Object arg) {
		//TODO
	}
}