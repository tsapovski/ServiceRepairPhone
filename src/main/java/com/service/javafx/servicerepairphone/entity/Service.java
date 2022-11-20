package com.service.javafx.servicerepairphone.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "service", schema = "service_repair")
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long serviceId;
    @Column(name = "model_phone")
    private String modelPhone;
    @Column(name = "type_repair")
    private String typeRepair;
    @Column(name = "cost_parts")
    private Integer costOfParts;
    @Column(name = "cost_repair")
    private Integer costOfRepair;
    @Column(name = "total_cost")
    private Integer totalCost;
    @Column(name = "client_id")
    private Long clientId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Clients clients;

    public Service() {
    }


    public Service(Long clientId, String modelPhone, String typeRepair, Integer costOfParts, Integer costOfRepair,
                   Integer totalCost) {

        this.clientId = clientId;
        this.modelPhone = modelPhone;
        this.typeRepair = typeRepair;
        this.costOfParts = costOfParts;
        this.costOfRepair = costOfRepair;
        this.totalCost = totalCost;

    }

    public Service(long serviceId, String modelPhone, String typeRepair, Integer costOfParts, Integer costOfRepair,
                   Integer totalCost, Long clientId, Clients clients) {

        this.serviceId = serviceId;
        this.modelPhone = modelPhone;
        this.typeRepair = typeRepair;
        this.costOfParts = costOfParts;
        this.costOfRepair = costOfRepair;
        this.totalCost = totalCost;
        this.clientId = clientId;
        this.clients = clients;
    }


    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }


    public String getModelPhone() {
        return modelPhone;
    }

    public void setModelPhone(String modelPhone) {
        this.modelPhone = modelPhone;
    }



    public String getTypeRepair() {
        return typeRepair;
    }

    public void setTypeRepair(String typeRepair) {
        this.typeRepair = typeRepair;
    }



    public Integer getCostOfParts() {
        return costOfParts;
    }

    public void setCostOfParts(Integer costOfParts) {
        this.costOfParts = costOfParts;
    }



    public Integer getCostOfRepair() {
        return costOfRepair;
    }

    public void setCostOfRepair(Integer costOfRepair) {
        this.costOfRepair = costOfRepair;
    }



    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }



    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return serviceId.equals(service.serviceId) && modelPhone.equals(service.modelPhone) && typeRepair.equals(service.typeRepair) && costOfParts.equals(service.costOfParts) && costOfRepair.equals(service.costOfRepair) && totalCost.equals(service.totalCost) && clientId.equals(service.clientId) && clients.equals(service.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, modelPhone, typeRepair, costOfParts, costOfRepair, totalCost, clientId, clients);
    }
}
