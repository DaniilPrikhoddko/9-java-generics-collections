package com.example.task02;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SavedList<E super List> extends AbstractList<E> {
    private File file;
    private List<E> list;

    public SavedList(File file) {
        this.file = file;
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (ArrayList<E>) ois.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        else {
            list = new ArrayList<>();
        }
    }

    private void writeFile() {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            ous.writeObject(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        E variable = list.set(index, element);
        writeFile();
        return variable;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(int index, E element) {
        list.add(index, element);
        writeFile();
    }

    @Override
    public E remove(int index) {
        E variable = list.remove(index);
        writeFile();
        return variable;
    }
}
