package ChainOfResponibility;

public enum LoggerType {
    INFO(1),
    DEBUG(2),
    ERROR(3);

    private final int level;

     LoggerType(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }
}
