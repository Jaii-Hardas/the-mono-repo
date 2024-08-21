package add_patient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import appointment_management.AppointmentManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.PatientRequest;
import dto.PatientResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class AddPatientScreenController implements Initializable {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button cancle;

  @FXML private Button save;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_name_marathi;

  @FXML private TextField mobile_number;

  @FXML private ComboBox<String> gender;

  @FXML private DatePicker birth_date;

  @FXML private DatePicker first_examination_date;

  @FXML private TextField address;

  public void initialize(URL location, ResourceBundle resources) {

    ObservableList<String> lines = FXCollections.observableArrayList("Male", "Female");
    gender.setItems(lines);
  }

  public void PatientsButton(ActionEvent event) throws IOException {

  }

  public void CasesButton(ActionEvent event) throws IOException {
   
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
   
  }

  public void UsersButton(ActionEvent event) throws IOException {
    
  }

  public void LogoutButton(ActionEvent event) throws IOException {

   
  }

  public void Save_Button(ActionEvent event) throws IOException {

    PatientRequest addPatient = new PatientRequest();

    addPatient.setAddress(address.getText());
    addPatient.setMobile(mobile_number.getText());
    addPatient.setPatient_name_marathi(patient_name_marathi.getText());
    addPatient.setPatientNameEnglish(patient_name_english.getText());
    addPatient.setBirth_date(birth_date.getValue().toString());
    addPatient.setFirst_examination_date(first_examination_date.getValue().toString());
    addPatient.setGender(gender.getValue());

    try {
      PatientResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8082/api/v1/patient/add", PatientResponse.class, addPatient);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Patient Added ");
    alert.setContentText("Patient added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }

  public void Cancle_Button(ActionEvent event) {
    
  }

  public void Dashboard(ActionEvent event) throws IOException {
  }
}