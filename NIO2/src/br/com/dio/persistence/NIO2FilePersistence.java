package br.com.dio.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2FilePersistence extends FilePersistence {

    public NIO2FilePersistence(String fileName) throws IOException {
        super(fileName, "/files/NIO2/");
        var path = Paths.get(currentDir, storeDir);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        clearFile();
    }

    @Override
    public String write(String data) {
        var path = Paths.get(currentDir, storeDir, fileName);
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String findAll() {
        var path = Paths.get(currentDir, storeDir, fileName);
        var content = "";
        try (var line = Files.lines(path)) {
            content = line.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        } ;
        return content;
    }

    @Override
    public String findBy(String sentence) {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator()))
                .filter(s -> s.contains(sentence))
                .findFirst()
                .orElse("Não existe");
    }
}
