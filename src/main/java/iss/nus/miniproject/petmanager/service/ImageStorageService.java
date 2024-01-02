package iss.nus.miniproject.petmanager.service;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
    
public interface ImageStorageService {

  public String save(MultipartFile file) throws IOException;

  
}

