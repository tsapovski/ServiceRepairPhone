package com.service.javafx.servicerepairphone.entity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "service_repair")
public class Clients implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "number_phone")
    private Integer phone;
    @Column(name = "status")
    private String status;

    // cascade = CascadeType.ALL
    @OneToOne(mappedBy = "clients", fetch = FetchType.EAGER)
    private Service service;

    public Clients() {
    }

    public Clients(String firstName, String lastName, String address, Integer phone, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public Clients(Long id, String firstName, String lastName, String address, Integer phone, String status, Service service) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return id.equals(clients.id) && firstName.equals(clients.firstName) && lastName.equals(clients.lastName) && address.equals(clients.address) && phone.equals(clients.phone) && status.equals(clients.status) && service.equals(clients.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, phone, status, service);
    }
}
