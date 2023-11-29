package Hackathon.CyberGuide.app.services;

import Hackathon.CyberGuide.app.entities.AudioObject;
import Hackathon.CyberGuide.app.entities.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {


    public boolean upload(MultipartFile preview, Image image, Long id);
}
