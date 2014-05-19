package asteroid;

import java.awt.Color;
import java.awt.Dimension;

import scenes.AsteroidScene;
import scenes.levels.Level1;
import boards.LivesBoard;
import boards.ScoreBoard;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

import config.Configuration;

public class AsteroidGame extends Game {
	private AsteroidScene defaultScene = new Level1();
	private String defaultConfigurationFile = "application.xml";
	
	public final ScoreBoard BOARD = new ScoreBoard(20, 0, Color.WHITE);
	public final LivesBoard LIVES = new LivesBoard(620, 0, Color.WHITE);

	public AsteroidGame() {
		super();
		Configuration.LOAD(defaultConfigurationFile);
		setCurrentScene(defaultScene);
	}
	
	@Override
	protected void initializeResources() {
//		Configuration.LOAD(defaultConfigurationFile);
	}

	@Override
	protected void setUpScenes() {
//		setCurrentScene(defaultScene);
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(Configuration.getDisplayWidth(), Configuration.getDisplayHeight());
	}

	@Override
	public String getTitle() {
		return "Asteroid";
	}

	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new AsteroidGame()).launch();
	}

}
