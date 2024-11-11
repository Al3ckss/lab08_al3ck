import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    


    private String name;    //TODO bisogna fare una specie di lista dove ad ogni nome sono collegati dati diversi
    private String cause;
    private String details;
    
    private Long time;
    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size()){
            throw new IllegalArgumentException();
        }

        return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.time = System.currentTimeMillis();
    }
    
    @Override
    public boolean writeDeathCause(String cause) {
        if(!isNameWritten(this.name) || cause == null){
            throw new IllegalStateException();
        }

        if((System.currentTimeMillis() - this.time) <= 40){
            this.time = System.currentTimeMillis();
            this.cause = cause;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean writeDetails(String details) {
        if (!isNameWritten(this.name) || details == null) {
            throw new IllegalStateException();
        }
        
        if ((System.currentTimeMillis() - this.time) <= 6040){
            this.details = details;
            this.time = System.currentTimeMillis();
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String getDeathCause(String name) {
        
    }
    @Override
    public boolean isNameWritten(String name) {
        return !this.name.isEmpty();
    }
}