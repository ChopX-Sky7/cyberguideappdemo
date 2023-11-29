package Hackathon.CyberGuide.app.services;

import Hackathon.CyberGuide.app.entities.AudioObject;
import org.springframework.web.multipart.MultipartFile;

public interface AudioUploadService {

    public boolean upload(MultipartFile audio, AudioObject object);


}
