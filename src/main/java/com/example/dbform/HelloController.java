package com.example.dbform;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    @FXML
    private TextField label;

    @FXML
    private TextField volume;

    @FXML
    private TextField category;
    @FXML
    private TextField subcategory;

    @FXML
    private TextField country;
  //  @FXML
  //  private TextField id;

    @FXML
    private TextField strength;
    @FXML
    private TextField sugar;

    @FXML
    private TextField year;

    @FXML
    private TextField age;

    @FXML
    TableView<Liquer> table;

    @FXML
    void onKeyPressed(KeyEvent event)
    {
        if (event.getCode().toString().equals("DELETE"))
        {
            int i = table.getSelectionModel().getSelectedItem().getId();
            try {
                LiquerProcess.delLiq(i);}
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            alcohol.remove(table.getSelectionModel().getSelectedItem());
        }
    }
    ObservableList<Liquer> alcohol = FXCollections.observableArrayList();

    public void initialize() {
        table.setItems(alcohol);
        TableColumn<Liquer, String> col1 = new TableColumn<>("label");
        col1.setCellValueFactory(new PropertyValueFactory<>("label"));
        table.getColumns().add(col1);
        TableColumn<Liquer, Float> col2 = new TableColumn<>("volume");
        col2.setCellValueFactory(new PropertyValueFactory<>("volume"));
        table.getColumns().add(col2);
        TableColumn<Liquer, AlcoCategory> col3 = new TableColumn<>("category");
        col3.setCellValueFactory(new PropertyValueFactory<>("category"));
        table.getColumns().add(col3);
        TableColumn<Liquer, String> col4 = new TableColumn<>("subcategory");
        col4.setCellValueFactory(new PropertyValueFactory<>("subcategory"));
        table.getColumns().add(col4);
        TableColumn<Liquer, String> col5 = new TableColumn<>("country");
        col5.setCellValueFactory(new PropertyValueFactory<>("country"));
        table.getColumns().add(col5);
        TableColumn<Liquer, Float> col6 = new TableColumn<>("strength");
        col6.setCellValueFactory(new PropertyValueFactory<>("strength"));
        table.getColumns().add(col6);
        TableColumn<Liquer, Float> col7 = new TableColumn<>("sugar");
        col7.setCellValueFactory(new PropertyValueFactory<>("sugar"));
        table.getColumns().add(col7);
        TableColumn<Liquer, Integer> col8 = new TableColumn<>("year");
        col8.setCellValueFactory(new PropertyValueFactory<>("year"));
        table.getColumns().add(col8);
        TableColumn<Liquer, Integer> col9 = new TableColumn<>("age");
        col9.setCellValueFactory(new PropertyValueFactory<>("age"));
        table.getColumns().add(col9);
        TableColumn<Liquer, Integer> col10 = new TableColumn<>("id");
        col10.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(col10);

    }
    @FXML
    void saveToDB(ActionEvent event) {
        try {
          int id=2;
            String l = String.valueOf(label.getText());
            Float v = Float.parseFloat(volume.getText());
            AlcoCategory c = AlcoCategory.valueOf(category.getText());
            String s = String.valueOf(subcategory.getText());
            String cn = String.valueOf(country.getText());
            Float st = Float.parseFloat(strength.getText());
            Float sg = Float.parseFloat(sugar.getText());
            Integer y = Integer.parseInt(year.getText());
            Integer a = Integer.parseInt(age.getText());

            Liquer t = new Liquer(id,l,v,c,s,cn,st,sg,y,a);
            LiquerProcess.saveLiq(t);

        } catch (Exception e) {
            System.out.println("ошибка записи " + e.getMessage()+ "..." + Arrays.toString(e.getStackTrace()));
        }
    }

    @FXML
    void reloadFromBD() {
        try {
            List<Liquer> lst = LiquerProcess.readLiq();
            alcohol.clear();
            alcohol.addAll(lst);
        } catch (Exception e) {
            System.out.println("ошибка чтения " + e.getMessage());
        }
    }
}