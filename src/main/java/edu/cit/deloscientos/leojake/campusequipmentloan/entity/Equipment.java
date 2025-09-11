package edu.cit.deloscientos.leojake.campusequipmentloan.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Equipment name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Equipment type is required")
    @Column(nullable = false)
    private String type;

    @NotBlank(message = "Serial number is required")
    @Column(nullable = false, unique = true)
    private String serialNumber;

    @NotNull(message = "Availability status is required")
    @Column(nullable = false)
    private Boolean availability = true;

    // Default constructor
    public Equipment() {}

    // Constructor with parameters
    public Equipment(String name, String type, String serialNumber, Boolean availability) {
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.availability = availability;
    }

    //Getters and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public boolean getAvailability(){
        return availability;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }

    //methods
    public boolean isAvailable(){
        return availability != null && availability;
    }

    public void setAvailability(){
        this.availability = true;
    }

    public void setUnavailable(){
        this.availability = false;
    }

    @Override
    public String toString(){
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", availability=" + availability +
                '}';
    }
}
