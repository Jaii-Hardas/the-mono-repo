package edit_case;

import java.io.IOException;
import java.time.LocalDate;

import appointment_management.AppointmentManagementScreen;
import cases_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseRequest;
import dto.CaseResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;

public class EditCaseScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_id;

  @FXML private TextField case_number;

  @FXML private DatePicker examination_date;

  @FXML private TextField symptoms;

  @FXML private TextField prescription;

  @FXML private Button cancle;

  @FXML private Button save;

  @FXML private Button search;

  @FXML private TextField case_id;

  @FXML private TextField patient_id_search;

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

  public void Cancle_Button(ActionEvent event) {
    
      new DashBoardScreen().show();
   
  }

  public void Dashboard(ActionEvent event) throws IOException {
   
      new DashBoardScreen().show();
    
  }

  public void Search_Button(ActionEvent event) throws IOException {
    String patientId = patient_id_search.getText().trim();
    String caseId = case_id.getText().trim();

    CaseResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8083/api/v1/case/" + patientId, CaseResponse.class);
      } else if (!caseId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8083/api/v1/case/patient/" + caseId, CaseResponse.class);
      }
      if (response != null && response.getStatus().equals("Success")) {
        patient_name_english.setText(response.getPatientNameEnglish());
        patient_id.setText(response.getPatientId());
        case_number.setText(response.getCase_number());
        examination_date.setValue(LocalDate.parse(response.getExamination_date()));
        symptoms.setText(response.getSymptoms());
        prescription.setText(response.getPrescription());

      } else {
        showAlert("Error", "Casen not found", "Please enter valid patient Id or case Id");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to fetch case details",
          "An error occurred while fetching the case details.");
    }
  }

  public void Save_Button(ActionEvent event) throws IOException {
    CaseRequest updateCase = new CaseRequest();
    updateCase.setCase_number(case_number.getText());
    updateCase.setExamination_date(examination_date.getValue().toString());
    updateCase.setPatientId(patient_id.getText());
    updateCase.setPatientNameEnglish(patient_name_english.getText());
    updateCase.setPrescription(prescription.getText());
    updateCase.setSymptoms(symptoms.getText());

    String caseId = case_id.getText();

    try {
      CaseResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8084/api/v1/case/" + caseId, CaseResponse.class, updateCase);

      if (response != null && response.getStatus().equals("Success")) {
        showAlert("Success", "Case updated", "Case details have been updated successfully.");
      } else {
        showAlert(
            "Error", "Failed to update case", "An error occurred while updating the case details.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to update patient",
          "An error occurred while updating the case details.");
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