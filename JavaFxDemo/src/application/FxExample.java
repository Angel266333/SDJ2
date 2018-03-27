package application;


import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxExample extends Application {

	private Stage primaryStage;
	private MenuBar menu;
	private Menu menuSettings;
	private Menu menuStats;
	private Menu menuHelp;
	private MenuItem setupTabata;
	private MenuItem font;
	private MenuItem comingSoon;
	private MenuItem about;
	private MenuItem examples;
	private Button start;
	private Button restart;
	private Button round;
	private Label time;
	private Label roundLabel;
	private Label tabataLabel;
	
	

	public static void main(String[] args) {
		launch(args); // this method will call JavaFX application constructor

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;	
		primaryStage.setTitle("Tabata");
		primaryStage.show();
		createComponents();
		initializePanels();

	}

	public void createComponents() {
		//component's Items
		setupTabata = new MenuItem("Setup Tabata");
		font = new MenuItem("Change font size");
		comingSoon = new MenuItem("Coming soon");
		about = new MenuItem("About");
		examples = new MenuItem("Example");	
		//menu Components
		menuSettings = new Menu("Settings");
		menuSettings.getItems().addAll(setupTabata, font);
		menuStats = new Menu("Stats");
		menuStats.getItems().add(comingSoon);
		menuHelp = new Menu("Help");
		menuHelp.getItems().addAll(about, examples);
		//menuBar
		menu = new MenuBar();
		menu.getMenus().addAll(menuSettings, menuStats, menuHelp);
		menu.setId("menuBar");
		
		start = new Button("START");
		restart = new Button("RESTART");
		round = new Button("RESTART ROUND");
		
		time = new Label("20");
		time.setId("time");
		roundLabel = new Label("Round :");		
		
	}

	public void initializePanels() {
		//Group root = new Group();
		//root.setId("root");
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(restart, start, round);
		
		Pane timePane = new Pane();
		timePane.getChildren().add(time);
		timePane.setPadding(new Insets(40,0,10,220));
		
		
		Pane labelPane = new Pane();
		labelPane.getChildren().add(roundLabel);
		labelPane.setPadding(new Insets(500,0,0,150));
		
		
		BorderPane menuPane = new BorderPane();
		menuPane.setTop(menu);
		menuPane.setCenter(timePane);
		menuPane.setLeft(labelPane);
		menuPane.setId("pane");
		
		
		
		//root.getChildren().addAll(menuPane, main);
		
		Scene scene = new Scene(menuPane, 650, 900);// here we are adding width and height of window
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);

	}

}
