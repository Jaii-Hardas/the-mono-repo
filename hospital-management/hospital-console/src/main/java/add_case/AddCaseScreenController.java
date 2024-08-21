package add_case;

import java.io.IOException;

import appointment_management.AppointmentManagementScreen;
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

public class AddCaseScreenController {
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
    CaseRequest addCase = new CaseRequest();

    addCase.setCase_number(case_number.getText());
    addCase.setExamination_date(examination_date.getValue().toString());
    addCase.setPatientId(patient_id.getText());
    addCase.setPatientNameEnglish(patient_name_english.getText());
    addCase.setPrescription(prescription.getText());
    addCase.setSymptoms(symptoms.getText());

    try {
      CaseResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8083/api/v1/case/add", CaseResponse.class, addCase);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Case Added ");
    alert.setContentText("Case added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }

  public void Cancle_Button(ActionEvent event) {
    
  }

  public void Dashboard(ActionEvent event) throws IOException {
   
  }
}