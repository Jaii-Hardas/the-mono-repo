package add_user;

import java.io.IOException;

import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.UserRequest;
import dto.UserResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class AddUserScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button cancle;

  @FXML private Button save;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField email;

  @FXML private TextField mobile_number;

  @FXML private TextField role;

  @FXML private TextField password;

  @FXML private TextField confirm;

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

  public void Save_Button(ActionEvent event) throws IOException {
    UserRequest addUser = new UserRequest();

    addUser.setConfirm_password(confirm.getText());
    addUser.setEmail(email.getText());
    addUser.setMobileNumber(mobile_number.getText());
    addUser.setPassword(password.getText());
    addUser.setRole(role.getText());
    addUser.setUserName(patient_name_english.getText());

    try {
      UserResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8081/api/v1/directory/add", UserResponse.class, addUser);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("User Added ");
    alert.setContentText("User added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }

  public void Cancle_Button(ActionEvent event) {
   
    	new DashBoardScreen().show();
   
  }

  public void Dashboard(ActionEvent event) throws IOException {
   
    	new DashBoardScreen().show();
    
  }
}