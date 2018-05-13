public class Arc {
    private String arcName;
    private Place placePrior;//弧线的前驱place
    private Place placeNext;//弧线的后继place
    private Transition tranNext;//弧线的后继transition
    private Transition tranPrior;//弧线的前驱transition
    private int arcPower;//弧线的权值
    public Arc(){
    }
    public Arc(String arcName,Place placePrior,Transition transitionNext,int power){
        //构建从place到transition的弧线，power为权值
        this.setArcName(arcName);
        this.setPlacePrior(placePrior);
        this.setTransitionNext(transitionNext);
        this.setArcPower(power);
    }
    public Arc(String arcName,Transition transitionPrior,Place placeNext,int power){
        //构建从transition的弧线，power为权值
        this.setArcName(arcName);
        this.setTransitionPrior(transitionPrior);
        this.setPlaceNext(placeNext);
        this.setArcPower(power);
    }
    public void setArcName(String arcName) {
        this.arcName = arcName;
    }
    public String getArcName() {
        return arcName;
    }
    public void setPlacePrior(Place placePrior) {
        this.placePrior = placePrior;
    }
    public Place getPlacePrior() {
        return placePrior;
    }
    public void setPlaceNext(Place placeNext){
        this.placeNext = placeNext;
    }

    public Place getPlaceNext() {
        return placeNext;
    }
    public void setTransitionNext(Transition transitionNext) {
        this.tranNext = transitionNext;
    }
    public Transition getTransitionNext() {
        return tranNext;
    }
    public void setTransitionPrior(Transition transitionPrior) {
        this.tranPrior = transitionPrior;
    }
    public Transition getTransitionPrior() {
        return tranPrior;
    }
    public void setArcPower(int arcPower) {
        this.arcPower = arcPower;
    }
    public int getArcPower() {
        return arcPower;
    }
    @Override
    public String toString() {
        return this.getArcName() +"      ArcPower=  "+this.getArcPower()+"\n    placePrior    "+
                this.getPlacePrior()+"      PlaceNext "+this.getPlaceNext()+"\n     TransitionPrior  "+
                this.getTransitionPrior()+"     TransitionNext "+this.getTransitionNext();
    }
}
