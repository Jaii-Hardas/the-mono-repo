package cases_management;

import add_case.AddCaseScreen;
import appointment_management.AppointmentManagementScreen;
import dashboard.DashBoardScreen;
import delete_case.DeleteCaseScreen;
import edit_case.EditCaseScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management.PatientManagementScreen;
import user_management.UserManagementScreen;


public class CaseManagementScreenController {

  @FXML private Button SearchCases;

  @FXML private Button Logout;

  @FXML private Button Appointments;

  @FXML private Button Cases;

  @FXML private Button AddCases;

  @FXML private Button Patients;

  @FXML private Button DeleteCases;

  @FXML private Button DashBoard;

  @FXML private Button Users;

  @FXML private Button EditCase;

  @FXML
  void LogoutButton(ActionEvent event) {
    new DashBoardScreen().show();
  }

  @FXML
  void DashBoardButton(ActionEvent event) {
    new DashBoardScreen().show();
  }

  @FXML
  void PatientsButton(ActionEvent event) {
    new PatientManagementScreen().show();
  }

  @FXML
  void UsersButton(ActionEvent event) {
    new UserManagementScreen().show();
  }

  @FXML
  void AppointmentsButton(ActionEvent event) {
    new AppointmentManagementScreen().show();
  }

  @FXML
  void CasesButton(ActionEvent event) {
	  new CaseManagementScreen().show();
  }

  @FXML
  void EditCaseButton(ActionEvent event) {
    new EditCaseScreen().show();
  }

  @FXML
  void SearchCaseButton(ActionEvent event) {}

  @FXML
  void DeleteCaseButton(ActionEvent event) {
    new DeleteCaseScreen().show();
  }

  @FXML
  void AddCaseButton(ActionEvent event) {
    new AddCaseScreen().show();
  }
}