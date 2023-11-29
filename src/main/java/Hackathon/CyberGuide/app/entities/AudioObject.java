package Hackathon.CyberGuide.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class AudioObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long size;

    private String name;
    private String description;

    private Integer duration;

    private String audioLink;
    private String previewLink;
    private String uploadTime;

    public void setUploadTime() {
        this.uploadTime = new SimpleDateFormat(" dd.mm.yyyy_HH.mm").format(new Date());
    }
}
