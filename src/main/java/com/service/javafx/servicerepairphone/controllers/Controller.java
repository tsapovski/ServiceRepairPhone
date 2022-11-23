package com.service.javafx.servicerepairphone.controllers;

import com.service.javafx.servicerepairphone.dao.ClientsDao;
import com.service.javafx.servicerepairphone.dao.ServiceDao;
import com.service.javafx.servicerepairphone.entity.Clients;
import com.service.javafx.servicerepairphone.entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    private Clients clients;
    private Service service;
    private ObservableList<Clients> clientsList = FXCollections.observableArrayList();
    private ObservableList<Service> serviceList = FXCollections.observableArrayList();
    private String[] statusValue = {"in work", "readily"};

    @FXML
    protected TableView<Clients> ClientsTableID;
    @FXML
    private TableColumn<Clients, Long> id;
    @FXML
    private TableColumn<Clients, String> firstName;
    @FXML
    private TableColumn<Clients, String> lastName;
    @FXML
    private TableColumn<Clients, String> address;
    @FXML
    private TableColumn<Clients, Integer> phone;
    @FXML
    private TableColumn<Clients, String> status;
    @FXML
    public TableView<Service> ServiceTableID;
    @FXML
    public TableColumn<Service, Long> serviceId;
    @FXML
    public TableColumn<Service, String> modelPhone;
    @FXML
    public TableColumn<Service, String> typeRepair;
    @FXML
    public TableColumn<Service, Integer> costOfParts;
    @FXML
    public TableColumn<Service, Integer> costOfRepair;
    @FXML
    public TableColumn<Service, Integer> totalCost;
    @FXML
    public TextField firstNameID, lastNameID, addressID, phoneID, modelId,
            typeRepairId, costPartsID, costRepairID, enterTextID;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initStatus();
        refreshTable();

        /*
         update data table
        */
        ClientsTableID.setEditable(true);

        firstName.setCellFactory(TextFieldTableCell.<Clients>forTableColumn());
        firstName.setOnEditCommit((TableColumn.CellEditEvent<Clients, String> event) -> {
            TablePosition<Clients, String> pos = event.getTablePosition();
            String newFirstName = event.getNewValue();
            int row = pos.getRow();
            clients = event.getTableView().getItems().get(row);
            clients.setFirstName(newFirstName);
        });
        lastName.setCellFactory(TextFieldTableCell.<Clients>forTableColumn());
        lastName.setOnEditCommit((TableColumn.CellEditEvent<Clients, String> event) -> {
            TablePosition<Clients, String> pos = event.getTablePosition();
            String newLastName = event.getNewValue();
            int row = pos.getRow();
            clients = event.getTableView().getItems().get(row);
            clients.setLastName(newLastName);
        });
        address.setCellFactory(TextFieldTableCell.<Clients>forTableColumn());
        address.setOnEditCommit((TableColumn.CellEditEvent<Clients, String> event) -> {
            TablePosition<Clients, String> pos = event.getTablePosition();
            String newAddress = event.getNewValue();
            int row = pos.getRow();
            clients = event.getTableView().getItems().get(row);
            clients.setAddress(newAddress);
        });

        phone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        phone.setOnEditCommit((TableColumn.CellEditEvent<Clients, Integer> event) -> {
            TablePosition<Clients, Integer> pos = event.getTablePosition();
            Integer newPhone = (event.getNewValue());
            int row = pos.getRow();
            clients = event.getTableView().getItems().get(row);
            clients.setPhone(newPhone);
        });


        /*
        update data service
        */
        ServiceTableID.setEditable(true);

        modelPhone.setCellFactory(TextFieldTableCell.<Service>forTableColumn());
        modelPhone.setOnEditCommit((TableColumn.CellEditEvent<Service, String> event) -> {
            TablePosition<Service, String> pos = event.getTablePosition();
            String newPhone = event.getNewValue();
            int row = pos.getRow();
            service = event.getTableView().getItems().get(row);
            service.setModelPhone(newPhone);
        });
        typeRepair.setCellFactory(TextFieldTableCell.<Service>forTableColumn());
        typeRepair.setOnEditCommit((TableColumn.CellEditEvent<Service, String> event) -> {
            TablePosition<Service, String> pos = event.getTablePosition();
            String newTypeRepair = event.getNewValue();
            int row = pos.getRow();
            service = event.getTableView().getItems().get(row);
            service.setTypeRepair(newTypeRepair);
        });
        costOfParts.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        costOfParts.setOnEditCommit((TableColumn.CellEditEvent<Service, Integer> event) -> {
            TablePosition<Service, Integer> pos = event.getTablePosition();
            Integer costOfParts = event.getNewValue();
            int row = pos.getRow();
            service = event.getTableView().getItems().get(row);
            service.setCostOfParts(costOfParts);
        });

        costOfRepair.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        costOfRepair.setOnEditCommit((TableColumn.CellEditEvent<Service, Integer> event) -> {
            TablePosition<Service, Integer> pos = event.getTablePosition();
            Integer newCostOfRepair = (event.getNewValue());
            int row = pos.getRow();
            service = event.getTableView().getItems().get(row);
            service.setCostOfRepair(newCostOfRepair);
        });
        totalCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        totalCost.setOnEditCommit((TableColumn.CellEditEvent<Service, Integer> event) -> {
            TablePosition<Service, Integer> pos = event.getTablePosition();
            Integer newTotalCost = (event.getNewValue());
            int row = pos.getRow();
            service = event.getTableView().getItems().get(row);
            service.setTotalCost(newTotalCost);
        });

    }

    private ObservableList<Clients> getClientsList() {

        ClientsDao clientsDao = new ClientsDao();
        List<Clients> listClients = clientsDao.getAll();
        clientsDao.closeSession();
        for (Clients temp : listClients) {
            clientsList.addAll(temp);
        }
        return clientsList;

    }

    private ObservableList<Service> getServiceList() {
        ServiceDao serviceDao = new ServiceDao();
        List<Service> listService = serviceDao.getAll();
        serviceDao.closeSession();
        for (Service temp : listService) {
            serviceList.addAll(temp);
        }
        return serviceList;
    }

    private void initTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        serviceId.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        modelPhone.setCellValueFactory(new PropertyValueFactory<>("modelPhone"));
        typeRepair.setCellValueFactory(new PropertyValueFactory<>("typeRepair"));
        costOfParts.setCellValueFactory(new PropertyValueFactory<>("costOfParts"));
        costOfRepair.setCellValueFactory(new PropertyValueFactory<>("costOfRepair"));
        totalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

    }

    private void refreshTable() {
        ClientsTableID.getItems().clear();
        ServiceTableID.getItems().clear();
        initTable();
        ClientsTableID.setItems(getClientsList());
        ServiceTableID.setItems(getServiceList());
    }

    public void AddClientButton(ActionEvent actionEvent) {
        String fistName = firstNameID.getText();
        String lastName = lastNameID.getText();
        String address = addressID.getText();
        String phone = phoneID.getText();
        Integer temp = Integer.parseInt(phone);

        String modelPhone = modelId.getText();
        String typeRepair = typeRepairId.getText();
        String costOfParts = costPartsID.getText();
        String costOfRepair = costRepairID.getText();
        Integer tempCostOfParts = Integer.parseInt(costOfParts);
        Integer tempCostOfRepair = Integer.parseInt(costOfRepair);
        Integer totalCost = tempCostOfParts + tempCostOfRepair;

        ClientsDao cd = new ClientsDao();

        ServiceDao sd = new ServiceDao();

        Clients clients = new Clients(fistName, lastName, address, temp, "in work");
        Long tempId = cd.insert(clients);
        cd.closeSession();
        firstNameID.setText("");
        lastNameID.setText("");
        addressID.setText("");
        phoneID.setText("");
        Service service = new Service(tempId, modelPhone, typeRepair, tempCostOfParts, tempCostOfRepair, totalCost);
        sd.insert(service);
        sd.closeSession();
        modelId.setText("");
        typeRepairId.setText("");
        costPartsID.setText("");
        costRepairID.setText("");
        refreshTable();
    }

    public void Search(ActionEvent actionEvent) {
        String phoneN = enterTextID.getText();
        // Integer phoneNumber = Integer.parseInt(phoneN);
        ClientsDao clientsDao = new ClientsDao();
        List<Clients> listClients = clientsDao.getAll();
        clientsDao.closeSession();
       // super.updateItem(item, empty);



        boolean bool = true;
        for (Clients temp : listClients) {
            if (phoneN != null && temp.getPhone().equals(phoneN)) {
                bool = true;
                System.out.println();
                ClientsTableID.getSelectionModel().getSelectedItem();

            }
            refreshTable();
        }
    }
//     tableView.setRowFactory((TableView row) -> {
//        return new TableRow(){
//            @Override
//            public void updateItem(MainTable item, boolean empty){
//                // Сначала обязательно сбрасываем стиль.
//                setStyle(«»);
//                // и только после этого вызываем метод super.updateItem
//                super.updateItem(item, empty);
//                if (item == null || empty) {
//                    setStyle(«»);
//                } else {
//                    Iterator it = tableZakaz.getItems().iterator();
//                    while (it.hasNext()) {
//                        Long zakazIndex = it.next().getProductIndex();
//                        Long pIndex = item.getIndex();
//                        if ( Objects.equals(zakazIndex, pIndex) )   {
//                            setStyle(«-fx-background-color:lightgreen»);
//                        }
//                    }
//                }
//            }
//        };
//    });

    public void DeleteButton(ActionEvent actionEvent) {
        ClientsDao cd = new ClientsDao();
        ServiceDao sd = new ServiceDao();

        clients = ClientsTableID.getSelectionModel().getSelectedItem();
        if (clients != null) {
            sd.delete(clients.getService());
            cd.delete(clients);
            sd.closeSession();
            cd.closeSession();
        }
        service = ServiceTableID.getSelectionModel().getSelectedItem();
        if (service != null) {
            sd.delete(service);
            cd.delete(service.getClients());

            sd.closeSession();
            cd.closeSession();
        }

        refreshTable();
    }

    public void UpdateButton(ActionEvent actionEvent) {
        ServiceDao sd = new ServiceDao();
        ClientsDao cd = new ClientsDao();
        clients = ClientsTableID.getSelectionModel().getSelectedItem();

        if (clients != null) {
            cd.update(clients);
            cd.closeSession();
        }
        service = ServiceTableID.getSelectionModel().getSelectedItem();
        if (service != null) {
            sd.update(service);
            sd.closeSession();
        }
        refreshTable();
    }

    private void initStatus() {
        List<String> list = new ArrayList<String>();

        for (String temp : statusValue) {
            list.add(temp);
        }

        ObservableList<String> statusList = FXCollections.observableArrayList(list);
        status.setCellFactory(ComboBoxTableCell.forTableColumn(statusList));
        status.setOnEditCommit((TableColumn.CellEditEvent<Clients, String> event) -> {
            TablePosition<Clients, String> pos = event.getTablePosition();
            String newStatus = event.getNewValue();
            int row = pos.getRow();
            clients = event.getTableView().getItems().get(row);
            clients.setStatus(newStatus);
        });


    }
    public void PrintButton (ActionEvent actionEvent){
    }
}