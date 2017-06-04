/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursites;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;
import java.util.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class YourSitesController  {

    @FXML
    private RadioButton newsRButton;

    @FXML
    private RadioButton sportsRButton;

    @FXML
    private RadioButton techRButton;

    @FXML
    private RadioButton codingRButton;

    @FXML
    private RadioButton miscRButton;

    @FXML
    private ComboBox<?> comboBox;
    
    @FXML
    private Label messageLabel;
    
    private ArrayList<Website> sites = null;
    private ArrayList<String> siteNames = new ArrayList();
    private final Desktop desktop = Desktop.getDesktop();
    
    public void initialize() {
       sites =  WebsiteFileOperator.readFile(messageLabel);
       getSelectedCatagory("News");
       
    }
//  Listener for the radio button group    
    public void selectionGroupListener() {
        String type = "";
        if (newsRButton.isSelected()){
            type = "News";
        } else if (sportsRButton.isSelected()) {
            type = "Sports";
        } else if (techRButton.isSelected()) {
            type = "Tech";
        } else if (codingRButton.isSelected()) {
            type = "Coding";
        } else if (miscRButton.isSelected()) {
            type = "Misc.";
        }
        getSelectedCatagory(type);
    }
//  Determines which site was selected from combo box and goes to the appropriate
//  website     
    public void comboBoxSelectionListener(){
        String selected = (String)comboBox.getValue();
        
        try {
            for(Website e : sites) {
                if (selected.equalsIgnoreCase(e.getName())) {
                    desktop.browse(new URI(e.getAddress()));
                    messageLabel.setText("Opening link to " + selected);
                }
            }
        } catch (URISyntaxException | IOException ex) {
            messageLabel.setText("Error opening " + selected);
        }
    }
//  Loads the combo box with websites of the selected catagory  
    public void getSelectedCatagory(String s) {
        siteNames.clear();
        for(Website e : sites) {
            if (s.equalsIgnoreCase(e.getCatagory())){
                siteNames.add(e.getName());
            } 
        }
      
        ObservableList obList = FXCollections.observableList(siteNames);
        comboBox.setItems(obList);
        messageLabel.setText(s + " websites have been loaded.");
    }
}
