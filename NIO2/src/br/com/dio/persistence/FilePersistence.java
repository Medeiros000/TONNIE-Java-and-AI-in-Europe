package br.com.dio.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

public abstract class FilePersistence {

    protected final String currentDir = System.getProperty("user.dir");

    protected final String storeDir;

    protected final String fileName;

    public FilePersistence(String fileName, final String storeDir) {
        this.fileName = fileName;
        this.storeDir = storeDir;
    }

    public abstract String write(final String data);

    public boolean removeContent(String sentence) {
        var contentList = toListString();
        if (contentList.contains(sentence)) return false;
        clearFile();
        contentList.stream().filter(c -> !c.contains(sentence)).forEach(this::write);
        return true;
    }

    public String replace(String oldContent, String newContent) {
        var contentList = toListString();
        if (contentList.contains(oldContent)) return "";
        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);
        return newContent;
    }

    public abstract String findAll();

    public abstract String findBy(final String sentence);

    protected void clearFile() {
        var filePath = currentDir + storeDir + fileName;
        try (OutputStream out = new FileOutputStream(filePath)) {
//            System.out.printf("Inicializando recursos (%s)\n", filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected List<String> toListString() {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator())).toList();
    }
}
