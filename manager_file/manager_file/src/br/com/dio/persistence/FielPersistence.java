package br.com.dio.persistence;

public interface FielPersistence {

    String write(final String data);

    boolean removeContent(final String sentence);

    String replace(final String oldContent, final String newContent);

    String findAll();

    String findBy(final String sentence);
}
