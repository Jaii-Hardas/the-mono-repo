package edit_patient;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
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

public class EditPatientScreenController implements Initializable {
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

  @FXML private TextField patient_name_search;

  @FXML private TextField patient_id;

  @FXML private Button search;

  public void initialize(URL location, ResourceBundle resources) {

    ObservableList<String> lines = FXCollections.observableArrayList("Male", "Female");
    gender.setItems(lines);
  }

  public void PatientsButton(ActionEvent event) throws IOException {

   
      new PatientManagementScreen().show();
    
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

  public void LogoutButton(ActionEvent event) throws IOException {

    try {
      new LoginScreen().show();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_Button(ActionEvent event) throws IOException {
    String patientId = patient_id.getText().trim();
    String patientNameEnglish = patient_name_search.getText().trim();

    PatientResponse response = null;

    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/patient/" + patientId, PatientResponse.class);
      } else if (!patientNameEnglish.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/patient/name/" + patientNameEnglish,
                PatientResponse.class);
      }

      if (response != null && response.getStatus().equals("Success")) {
        patient_name_english.setText(response.getPatientNameEnglish());
        patient_name_marathi.setText(response.getPatient_name_marathi());
        mobile_number.setText(response.getMobile());
        gender.setValue(response.getGender());
        birth_date.setValue(LocalDate.parse(response.getBirth_date()));
        first_examination_date.setValue(LocalDate.parse(response.getFirst_examination_date()));
        address.setText(response.getAddress());
      } else {
        showAlert("Error", "Patient not found", "Please enter a valid patient ID or Name.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to fetch patient details",
          "An error occurred while fetching the patient details.");
    }
  }

  public void Save_Button(ActionEvent event) throws IOException {
    PatientRequest updatePatient = new PatientRequest();
    updatePatient.setAddress(address.getText());
    updatePatient.setMobile(mobile_number.getText());
    updatePatient.setPatient_name_marathi(patient_name_marathi.getText());
    updatePatient.setPatientNameEnglish(patient_name_english.getText());
    updatePatient.setBirth_date(birth_date.getValue().toString());
    updatePatient.setFirst_examination_date(first_examination_date.getValue().toString());
    updatePatient.setGender(gender.getValue());

    String patientId = patient_id.getText();

    try {
      PatientResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8082/api/v1/patient/" + patientId,
              PatientResponse.class,
              updatePatient);

      if (response != null && response.getStatus().equals("Success")) {
        showAlert("Success", "Patient updated", "Patient details have been updated successfully.");
      } else {
        showAlert(
            "Error",
            "Failed to update patient",
            "An error occurred while updating the patient details.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to update patient",
          "An error occurred while updating the patient details.");
    }
  }

  public void Cancle_Button(ActionEvent event) {
    try {
      new DashBoardScreen().show();
    } catch (Exception e) {
      // TODO Auto-generated catch block
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

  private void showAlert(String title, String header, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.show();
  }
}