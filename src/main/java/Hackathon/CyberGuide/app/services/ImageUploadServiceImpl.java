package Hackathon.CyberGuide.app.services;

import Hackathon.CyberGuide.app.entities.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Service
@Slf4j
public class ImageUploadServiceImpl implements ImageUploadService {


    @Override
    public boolean upload(MultipartFile preview, Image object, Long audioId) {
        if (!preview.isEmpty()) {
            object.setSize(preview.getSize());
            object.setAudioId(audioId);
            object.setPreviewLink("src/main/resources/static/previews/" + preview.getOriginalFilename());
            try (BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(object.getPreviewLink()))) {
                bos.write(preview.getBytes());
                log.info("Added audioObject: {}", object);
                return true;
            } catch (Exception e) {
                log.info("Catched exception: {}", e.getMessage());
                return false;
            }
        }
        return false;
    }
}
