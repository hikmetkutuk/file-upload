package com.fileupload.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileService
{
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository)
    {
        this.fileRepository = fileRepository;
    }

    public File store(MultipartFile file) throws IOException, IOException
    {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        File newFile = new File(null, fileName, Objects.requireNonNull(file.getContentType()), file.getBytes());

        return fileRepository.save(newFile);
    }

    public File getFile(Long id)
    {
        return fileRepository.findById(id).get();
    }

    public Stream<File> getFiles()
    {
        return fileRepository.findAll().stream();
    }
}
