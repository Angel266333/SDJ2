public class FootballFan implements Observer {
	private FootballGame game;
	private boolean homeTeamFan;

	public FootballFan(FootballGame game, boolean homeTeamFan) {
		this.game = game;
		this.homeTeamFan = homeTeamFan;
		cheer();
	}

	public void cheer() {
		if (homeTeamFan) {
			System.out.println("Come on " + game.getHomeTeam());
		} else {
			System.out.println("Come on " + game.getAwayTeam());
		}
	}

	public void reactOnGoal(boolean isHomeTeam) {
		if (isHomeTeam == homeTeamFan) {
			System.out.println("Jubiiii (my team scored)");
		} else {
			System.out.println("Boooo (the other team scored)");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
			Boolean homeTeamScored = (Boolean) arg;
			reactOnGoal(homeTeamScored);
		}
	}
