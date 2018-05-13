import java.util.HashSet;
import java.util.Set;
public  class Place {
    private String placeName;
    private int tokenCapacity ;//place的容量
    private int tokenNumbers;//place的token数量
    private Set <Transition> tranPrior ;//place的前驱transition的集合
    private Set <Transition> tranNext ;//place的后继transition的集合
    public Place(){
    }
    public Place(String placeName,int tokenCapacity,int tokenNumbers){
        this.setPlaceName(placeName);
        this.setTokenCapacity(tokenCapacity);
        this.setTokenNumbers(tokenNumbers);
        this.tranPrior = new  HashSet<Transition>();
        this.tranNext = new HashSet<Transition>();
    }
    protected void setPlaceName(String placeName){
        this.placeName = placeName;
    }
    protected String getPlaceName(){
        return this.placeName;
    }
    public void setTokenNumbers(int numOfToken){
        this.tokenNumbers = numOfToken;
    }
    public int getTokenNumbers(){
        return this.tokenNumbers;
    }
    public void setTokenCapacity(int CAPACITY){
        this.tokenCapacity = CAPACITY;
    }
    public int getTokenCapacity(){
        return this.tokenCapacity;
    }
    public void addTransitionPrior(Transition transitionPrior) {
        this.tranPrior.add(transitionPrior);
    }
    public Set<Transition> getTransitionPrior() {
        return tranPrior;
    }
    public void addTransitionNext(Transition transitionNext) {
        this.tranNext.add(transitionNext);
    }
    public Set<Transition>  getTransitionNext() {
        return tranNext;
    }
    public void tokenAdd(){
        if(this.getTokenNumbers()==this.getTokenCapacity()) {
            //如果下一个Place容量满了，则不可fire()
            System.out.println("The next place is filled !");
            System.exit(0);
        }
        else
            this.tokenNumbers++;
    }
    public void tokenSub(){
        this.tokenNumbers--;
    }
    public String toString(){
        //重写的toString函数
        return this.getPlaceName()+"     TokenNumbers:        "+this.getTokenNumbers()+"\n";
    }
    public String toString2(){
        return this.getPlaceName()+"    transitionPrior:  "+this.getTransitionPrior()+
          "   transitionNext:    "+this.getTransitionNext();
    }
}
