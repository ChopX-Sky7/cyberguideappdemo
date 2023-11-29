package Hackathon.CyberGuide.app.repos;

import Hackathon.CyberGuide.app.entities.AudioObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AudioRepo extends JpaRepository<AudioObject, Long> {

AudioObject getById(Long id);


}
