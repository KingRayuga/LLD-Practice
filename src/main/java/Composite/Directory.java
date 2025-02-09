package Composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{

    private final String name;
    List<FileSystemComponent> fileSystemComponentList = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    public void addComponent(FileSystemComponent fileSystemComponent){
        fileSystemComponentList.add(fileSystemComponent);
    }

    public void removeComponent(FileSystemComponent fileSystemComponent){
        fileSystemComponentList.remove(fileSystemComponent);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory name is " + name);
        for(FileSystemComponent fileSystemComponent: fileSystemComponentList){
            fileSystemComponent.showDetails();
        }
    }
}
