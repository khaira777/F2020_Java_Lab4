package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	@FXML
    private ComboBox<String> select_subject;

    @FXML
    private RadioButton cs_radio;

    @FXML
    private ToggleGroup field;

    @FXML
    private RadioButton business_radio;

    @FXML
    private TextField nameTextfield;

    @FXML
    private TextField addressTextfield;

    @FXML
    private TextField provinceTextfield;

    @FXML
    private TextField cityTextfield;

    @FXML
    private TextField postalTextfield;

    @FXML
    private TextField numberTextfield;

    @FXML
    private TextField emailTextfield;

    @FXML
    private CheckBox studentcouncil_Checked;

    @FXML
    private CheckBox volunteerwork_Checked;

    @FXML
    private TextArea subject_textfield;

    @FXML
    private TextArea output_textfield;

    @FXML
    private Button display_button;
    
    @FXML
    private MenuButton menusubject;
    
    @FXML
    private ListView<String> course_list;

    @FXML
    void handleButtonAction() {
    	displayInfo();
    }

    ObservableList<String> cs = FXCollections.observableArrayList("Java", "C#", "Mean", "C", "C++", "Ruby");
    ObservableList<String> business = FXCollections.observableArrayList("Management", "Marketing", "Finance", "HR", "Statistics", "Accounting");
    
    @FXML
    void radiosubject() {
    	if(cs_radio.isSelected()) {
    		select_subject.setItems(cs);
        	diplaysubjects();
    	}
    	else if(business_radio.isSelected()) {
    		select_subject.setItems(business);
        	diplaysubjects();
    	}
    }
    
    @FXML
    void clear(MouseEvent event) {
    	course_list.getItems().clear();
    }
     
    public void diplaysubjects() {
    	String courses = select_subject.getSelectionModel().getSelectedItem();
    	if(courses != null) {
    	course_list.getItems().add(courses.toString());
    	}
    	
    }
    
    private void displayInfo() {
    	output_textfield.clear();
    	output_textfield.appendText(nameTextfield.getText() + ", " +
    			addressTextfield.getText() + ", " +
    			provinceTextfield.getText() + ", " +
    			cityTextfield.getText() + ", " +
    			postalTextfield.getText() + ", " +
    			numberTextfield.getText() + ", " +
    			emailTextfield.getText() + "\n");
    	if(studentcouncil_Checked.isSelected()) {
    		output_textfield.appendText("Also participated in Student Council.\n");
    	}
    	if(volunteerwork_Checked.isSelected()) {
    		output_textfield.appendText("Did volunteer work.\n");
    	}
    	if(cs_radio.isSelected()) {
    		output_textfield.appendText("Computer Science Student. Subjects include:\n" + course_list.getItems().toString());
    	}
    	if(business_radio.isSelected()) {
    		output_textfield.appendText("Business Student. Subjects include:\n" + course_list.getItems().toString());
    	}
    	
    }

}
