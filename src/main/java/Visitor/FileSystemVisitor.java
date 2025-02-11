package Visitor;

public interface FileSystemVisitor {
    public void visit(File file);
    public void visit(Folder Folder);
}
