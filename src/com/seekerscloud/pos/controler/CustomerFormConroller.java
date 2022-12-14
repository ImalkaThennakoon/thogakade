package com.seekerscloud.pos.controler;

import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.Customer;
import com.seekerscloud.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerFormConroller {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOptions;

    public void initialize(){
       colId.setCellValueFactory(new PropertyValueFactory<>("id"));
       colName.setCellValueFactory(new PropertyValueFactory<>("name"));
       colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
       colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
       colOptions.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchCustomers();
    }

    private void searchCustomers() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        for(Customer c:Database.customerTable){
            Button btn = new Button("Delete");
            CustomerTm tm =new CustomerTm(c.getId(),c.getName(),c.getAddress(),c.getSalary(),btn);
            tmList.add(tm);

        }
        tblCustomer.setItems(tmList);
    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(txtId.getText(),txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText()));

       boolean isSaved = Database.customerTable.add(c1);
       if(isSaved){
           searchCustomers();
           new Alert(Alert.AlertType.INFORMATION,"Customer Saved!").show();

       }else{
           new Alert(Alert.AlertType.INFORMATION,"Try Again").show();
       }

    }
}
