package br.com.dio.persistence;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Stream;

public class NIOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir");

    private final String storeDir = "/files/NIO/";

    private final String fileName;

    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storeDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storeDir + fileName), "rw")) {
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
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

        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentDir + storeDir + fileName), "r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(1024);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        try (
                var file = new RandomAccessFile(new File(currentDir + storeDir + fileName), "r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    var content = new StringBuilder();
                    while (!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get());
                    }
                    if(content.toString().contains(sentence)){
                        return content.toString();
                    } else {
                        content.setLength(0);
                    }
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void clearFile() {
        var filePath = currentDir + storeDir + fileName;
        try (OutputStream out = new FileOutputStream(filePath)) {
            System.out.printf("Inicializando recursos (%s)\n", filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> toListString() {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator())).toList();
    }
}
