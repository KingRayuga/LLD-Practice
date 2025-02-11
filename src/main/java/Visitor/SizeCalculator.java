package Visitor;

public class SizeCalculator implements FileSystemVisitor{

    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        for(FIleSystemInterface fIleSystemInterface: folder.getElements()){
            fIleSystemInterface.accept(this);
        }
    }

    public int getTotalSize(){
        return this.totalSize;
    }
}
