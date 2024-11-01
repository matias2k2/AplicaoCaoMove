package ao.co.isptec.aplm.laboratorio4.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trajetoria")
public class Trajetoria {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private Integer name;
    private Integer details;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getName() { return name; }
    public void setName(Integer name) { this.name = name; }
    public Integer getDetails() { return details; }
    public void setDetails(Integer details) { this.details = details; }
}
