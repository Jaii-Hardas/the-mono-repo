package appointment_management;

import java.io.IOException;

import add_appointment.AddAppointmentScreen;
import cases_management.CaseManagementScreen;
import dashboard.DashBoardScreen;
import delete_appointment.DeleteAppointmentScreen;
import edit_appointment.EditAppointmentScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class AppointmentManagementScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button add_appointment;

  @FXML private Button edit_appointment;

  @FXML private Button delete_appointment;

  @FXML private Button search_appointment;

  @FXML private Button dashboard;

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

  public void Add_Appointment(ActionEvent event) throws IOException {

      new AddAppointmentScreen().show();
  
  }

  public void Search_Appointment(ActionEvent event) throws IOException {
    
	  new EditAppointmentScreen().show();
   
  }

  public void Edit_Appointment(ActionEvent event) throws IOException {
   
	  new EditAppointmentScreen().show();
  }

  public void Delete_Appointment(ActionEvent event) throws IOException {
   
	  new DeleteAppointmentScreen().show();
    
  }

  public void LogoutButton(ActionEvent event) throws IOException {
    
	  new LoginScreen().show();
  }

  public void Dashboard(ActionEvent event) throws IOException {
    
	  new DashBoardScreen().show();
    
  }
}