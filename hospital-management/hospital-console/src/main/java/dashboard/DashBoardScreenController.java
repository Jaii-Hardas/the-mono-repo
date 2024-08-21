package dashboard;

import java.io.IOException;

import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class DashBoardScreenController {

  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;
  
  @FXML private Button DashBoard;
  

  public void DashBoardButton(ActionEvent event) {
    new DashBoardScreen().show();
  }

  public void PatientsButton(ActionEvent event) throws IOException {

      new PatientManagementScreen().show();
   
  }

  public void CasesButton(ActionEvent event) throws IOException {
    
     new CaseManagementScreen().show();
   
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
   
      new AppointmentManagementScreen().show();
    
  }

  public void UsersButton(ActionEvent event) throws IOException {
   
      new UserManagementScreen().show();
    
  }

  public void LogoutButton(ActionEvent event) throws IOException {

     new LoginScreen().show();
   
  }
}
