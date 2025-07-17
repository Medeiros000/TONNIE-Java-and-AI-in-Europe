package br.com.dio.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2FilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir");

    private final String storeDir = "/files/NIO2/";

    private final String fileName;

    public NIO2FilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
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
    public boolean removeContent(String sentence) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "Não encontrado";

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);
        return newContent;
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

    private void clearFile() {
        var filePath = currentDir + storeDir + fileName;
        try (OutputStream out = new FileOutputStream(filePath)) {
//            System.out.printf("Inicializando recursos (%s)\n", filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> toListString() {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator())).toList();
    }
}
