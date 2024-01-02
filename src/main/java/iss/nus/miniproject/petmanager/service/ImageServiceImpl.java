package iss.nus.miniproject.petmanager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageStorageService {
  private final Path uploadDir;

    public ImageServiceImpl() {
        this.uploadDir = Path.of("uploads");
        try {
            Files.createDirectories(uploadDir);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

 

  @Override
  public String save(MultipartFile file) throws IOException  {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Path filePath = this.uploadDir.resolve(fileName).normalize();
    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    return "/uploads/" + fileName;
}

  }
