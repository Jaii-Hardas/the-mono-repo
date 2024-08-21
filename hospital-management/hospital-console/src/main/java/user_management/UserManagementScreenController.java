package user_management;

import java.io.IOException;
import add_user.AddUserScreen;
import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
import dashboard.DashBoardScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import patient_management.PatientManagementScreen;

public class UserManagementScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button add_user;

  @FXML private Button edit_user;

  @FXML private Button delete_user;

  @FXML private Button search_user;

  @FXML private Button dashboard;

  public void PatientsButton(ActionEvent event) {
	  try {
		  new PatientManagementScreen().show();
	    } catch (Exception e) { // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
  }

  public void CasesButton(ActionEvent event) throws IOException {
    try {
      new CaseManagementScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
    try {
      new AppointmentManagementScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void UsersButton(ActionEvent event) throws IOException {
	  try {
	      new UserManagementScreen().show();
	    } catch (Exception e) { // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
  }

  public void Add_User(ActionEvent event) throws IOException {
    try {
      new AddUserScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_User(ActionEvent event) throws IOException {}

  public void Edit_User(ActionEvent event) throws IOException {}

  public void Delete_User(ActionEvent event) throws IOException {}

  public void LogoutButton(ActionEvent event) throws IOException {
    try {
      new LoginScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Dashboard(ActionEvent event) throws IOException {
    try {
      new DashBoardScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}