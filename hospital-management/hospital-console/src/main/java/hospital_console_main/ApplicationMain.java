package hospital_console_main;

import javafx.application.Application;
import javafx.stage.Stage;
import common.StageFactory;
import dashboard.DashBoardScreen;
import login.LoginScreen;

public class ApplicationMain extends Application {

  public static void main(String args[]) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    StageFactory.stage = stage;
    new LoginScreen().show();
    //new DashBoardScreen().show();
  }
}