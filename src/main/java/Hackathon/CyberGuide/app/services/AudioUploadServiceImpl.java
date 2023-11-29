package Hackathon.CyberGuide.app.services;

import Hackathon.CyberGuide.app.entities.AudioObject;
import Hackathon.CyberGuide.app.repos.AudioRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Service
@Slf4j
public class AudioUploadServiceImpl implements AudioUploadService {
    private final AudioRepo repo;

    public AudioUploadServiceImpl(AudioRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean upload(MultipartFile audio, AudioObject object) {
        if (!audio.isEmpty()) {
            object.setSize(audio.getSize());
            object.setAudioLink("src/main/resources/static/audio/" + audio.getOriginalFilename());
            try (BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(object.getAudioLink()))) {
                bos.write(audio.getBytes());
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


