package Hackathon.CyberGuide.app.controllers;

import Hackathon.CyberGuide.app.entities.AudioObject;
import Hackathon.CyberGuide.app.repos.AudioRepo;
import Hackathon.CyberGuide.app.services.AudioUploadService;
import Hackathon.CyberGuide.app.services.AudioUploadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/upload")
public class AudioUploadController {

   // private final AudioObject audio;
    private final AudioUploadServiceImpl service;
    private final AudioRepo repo;

    @Autowired
    public AudioUploadController(AudioUploadServiceImpl service, AudioRepo repo ) {
        this.repo = repo;
        this.service = service;
    }

    @ModelAttribute(name = "audio")
    public AudioObject audioObject(){
        return new AudioObject();
    }

@GetMapping
public String showForm(){
        return "audioUpload";
}


@PostMapping
    public String uploadAudio(@RequestParam(name = "content") MultipartFile file,
                              @ModelAttribute AudioObject audio){
    if(service.upload(file, audio)){
        repo.save(audio);
    log.info("saved: {}", audio.toString());
    }
    return "redirect:/";
}


}
