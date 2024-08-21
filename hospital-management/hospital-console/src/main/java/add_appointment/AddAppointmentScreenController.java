package add_appointment;

import java.io.IOException;

import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class AddAppointmentScreenController {

  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_id;

  @FXML private TextField appointment_id;

  @FXML private DatePicker examination_date;

  @FXML private TextField appointment_time;

  @FXML private Button cancle;

  @FXML private Button save;

  public void PatientsButton(ActionEvent event){

      new PatientManagementScreen().show();
  }

  public void CasesButton(ActionEvent event){
   
      new CaseManagementScreen().show();
  }

  public void AppointmentButton(ActionEvent event){
   
      new AppointmentManagementScreen().show();
  }

  public void UsersButton(ActionEvent event){
   
      new UserManagementScreen().show();
  
  }

  public void LogoutButton(ActionEvent event){

     new LoginScreen().show();
  }

  public void Save_Button(ActionEvent event) throws IOException {
    AppointmentRequest addAppointment = new AppointmentRequest();

    addAppointment.setAppointment_time(appointment_time.getText());
    addAppointment.setAppointmentId(appointment_id.getText());
    addAppointment.setExamination_date(examination_date.getValue().toString());
    addAppointment.setPatientId(patient_id.getText());
    addAppointment.setPatientNameEnglish(patient_name_english.getText());

    try {
      AppointmentResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8085/api/v1/appointment/add",
              AppointmentResponse.class,
              addAppointment);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Appointment Added ");
    alert.setContentText("Appointment added!");
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