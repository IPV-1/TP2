package asteroid;

import java.awt.Color;
import java.awt.Dimension;

import scenes.statics.TitleScene;
import boards.LivesBoard;
import boards.ScoreBoard;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;

import config.Configuration;

public class AsteroidGame extends Game {
	private GameScene defaultScene;
	private String defaultConfigurationFile = "application.xml";
	
	public final ScoreBoard BOARD = new ScoreBoard(20, 0, Color.WHITE);
	public final LivesBoard LIVES = new LivesBoard(620, 0, Color.WHITE);

	public AsteroidGame() {
		super();
		Configuration.LOAD(defaultConfigurationFile);
		defaultScene = new TitleScene();
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
