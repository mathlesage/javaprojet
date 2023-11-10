package Representation;
public abstract class Scenario {
    private String histoire;
    public Scenario(String histoire) {
    this.histoire = histoire;
    }
    public void getHistoire(){
        System.out.println(histoire);
    }

}

