package pkgApp.controller;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtReturnWork;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtNeedToSave;
	
	public RetirementApp getMainApp() {
		return mainApp;
	}
	
	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		txtYearsToWork.clear();
		txtReturnWork.clear();
		txtYearsRetired.clear();
		txtReturnRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		if (!validate()) {
			return;
		}
		Retirement retirement = new Retirement(Integer.parseInt(txtYearsToWork.getText()), 
				Double.parseDouble(txtReturnWork.getText()),
				Integer.parseInt(txtYearsRetired.getText()),
				Double.parseDouble(txtReturnRetired.getText()),
				Double.parseDouble(txtRequiredIncome.getText()),
				Double.parseDouble(txtMonthlySSI.getText()));
		double needToSave = retirement.TotalAmountSaved();
		double saveEachMonth = retirement.AmountToSave(needToSave);
		txtSaveEachMonth.setText(NumberFormat.getCurrencyInstance().format(saveEachMonth));
		txtNeedToSave.setText(NumberFormat.getCurrencyInstance().format(needToSave));			

	}

	private boolean validate(){
		if (txtReturnWork.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter an annual return of work");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtReturnWork.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter you work return as a decimal");
			 _alert.show();
			 return false;
		}
		
		if (txtYearsToWork.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter how many years left to work");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(txtYearsToWork.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter your years left to work as a number");
			 _alert.show();
			 return false;
		}
		
		if (txtYearsRetired.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter how many years you expect to be retired");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtYearsRetired.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Expected years retired must be a number");
			 _alert.show();
			 return false;
		}
		
		if (txtReturnRetired.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter your annual retired return");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtReturnRetired.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter a valid retired return as a decimal ");
			 _alert.show();
			 return false;
		}
		
		if (txtRequiredIncome.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter your required income");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtRequiredIncome.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter you required income as number");
			 _alert.show();
			 return false;
		}
		
		if (txtMonthlySSI.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter your monthly SSI");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtMonthlySSI.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Enter monthly SSI as a number");
			 _alert.show();
			 return false;
		}
		
		return true;
	}
}

	
