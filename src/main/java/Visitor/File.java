package Visitor;

public class File implements FIleSystemInterface{

    private String name;
    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor) {
        fileSystemVisitor.visit(this);
    }
}
