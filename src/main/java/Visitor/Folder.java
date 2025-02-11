package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FIleSystemInterface{
    private String name;
    private final List<FIleSystemInterface> arrayList = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addFile(FIleSystemInterface fIleSystemInterface){
        arrayList.add(fIleSystemInterface);
    }

    public List<FIleSystemInterface> getElements(){
        return this.arrayList;
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor) {
        fileSystemVisitor.visit(this);
    }
}
