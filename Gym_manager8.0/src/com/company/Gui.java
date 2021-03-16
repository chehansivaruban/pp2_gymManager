package com.company;

//import
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gui extends Application {


    //Initialize table view
    private TableView<DefaultMember> memberTable = new TableView<DefaultMember>();

    //method to insert the default member list elements into the Observable list
    public ObservableList<DefaultMember> getMember() {
        ObservableList<DefaultMember> members = FXCollections.observableArrayList();
        //enhanced for Loop to iterate through the list
        for (DefaultMember member : Manager.memberList) {
            members.add(member);
        }
        return members;// returns the ObservableList
    }


    @Override
    public void start(Stage stage) {
        FilteredList<DefaultMember> flPerson = new FilteredList(getMember(), p -> true);//insert the elements of the observable list to the filtered list

        final Label titleLbl = new Label("Member Details"); // a label for the title.
        titleLbl.setFont(new Font("Arial", 25)); // change the font style and size.

        memberTable.setEditable(true);// enables the table to be editable

        TableColumn idCol; // initialize the ID column
        idCol = new TableColumn("Member ID");//Naming the column
        idCol.setMinWidth(90);//set column width
        idCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("memberId"));

        TableColumn nameCol; // initialize the Name column
        nameCol = new TableColumn("Member Name");//Naming the column
        nameCol.setMinWidth(200);//set column width
        nameCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("name"));

        TableColumn dateCol; // initialize the date column
        dateCol = new TableColumn("Membership Start Date");//Naming the column
        dateCol.setMinWidth(100);//set column width
        dateCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, Date>("startDate"));//Naming the column

        TableColumn schoolCol; // initialize the school column
        schoolCol = new TableColumn("School");//Naming the column
        schoolCol.setMinWidth(100);//set column width
        schoolCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("school"));

        TableColumn ageCol; // initialize the age column
        ageCol = new TableColumn("Member Age");//Naming the column
        ageCol.setMinWidth(60);//set column width
        ageCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("age"));


        memberTable.setItems(flPerson); //insert the filtered list data to the table
        memberTable.getColumns().addAll(idCol, nameCol, dateCol,schoolCol,ageCol);

        // ChoiceBox for the search type and TextField to enter the search
        ChoiceBox<String> searchBox = new ChoiceBox();
        searchBox.getItems().addAll("Member ID", "Name");//choice box options
        searchBox.setValue("Member ID");//default search type

        TextField textField = new TextField();//textField to search
        textField.setPromptText("Search Member!");
        textField.setOnKeyReleased(keyEvent ->
        {
            switch (searchBox.getValue())//choose on the choiceBox value
            {
                case "Member ID":
                    flPerson.setPredicate(p -> p.getMemberId().toLowerCase().contains(textField.getText().toLowerCase().trim()));//search by member ID
                    break;
                case "Name":
                    flPerson.setPredicate(p -> p.getName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//search by member Name
                    break;

            }
        });

        searchBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {//default table and search field when new search type is selected
            if (newVal != null) {
                textField.setText("");
                flPerson.setPredicate(null);
            }
        });

        HBox hSearch = new HBox(searchBox, textField);//horizontally group the search type and the search field
        hSearch.setAlignment(Pos.CENTER);//Center allign the HBox

        final VBox vbox = new VBox();//vertically group the all the elements of the Gui
        vbox.setSpacing(15);//Add spacing
        vbox.setPadding(new Insets(5, 2, 5, 20));//Add padding
        vbox.getChildren().addAll(titleLbl, hSearch, memberTable);// add the elements to the vbox
        vbox.setMinWidth(650);

        Scene gymScene = new Scene(new Group());//initialize the scene
        stage.setTitle("Gym Manger - Member Details");//set the title
        stage.setWidth(700);
        stage.setHeight(600);

        ((Group) gymScene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(gymScene);
        stage.show();
    }
}