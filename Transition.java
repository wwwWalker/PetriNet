import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Transition  {
    private String transitionName;//transition名称
    private Set <Place> placeNext;//transition的所有后继place的集合
    private Set <Place> placePrior;//transition的所有前驱place的集合
    public Transition() {
    }
    public Transition(String transitionName) {
        this.setTransitionName(transitionName);
        this.placePrior = new HashSet <Place> ();
        this.placeNext = new HashSet <Place> ();
    }
    public void setTransitionName(String transitionName){
        this.transitionName = transitionName;
    }
    public String getTransitionName(){
        return this.transitionName;
    }
    public void addPlacePrior(Place placePrior) {
        //transition增加前驱place的方法
        this.placePrior.add(placePrior);
    }

    public Set<Place> getPlacePrior() {
        return placePrior;
    }
    public void addPlaceNext(Place placeNext) {
        //transition增加后继place的方法
        this.placeNext.add(placeNext);
    }
    public Set<Place> getPlaceNext() {
        return placeNext;
    }
    private boolean enable() {
        //transition是否有条件fire的使能判断
        if(this.placePrior.size()>0&&this.placeNext.size()>0) {
            Iterator<Place> it = this.placePrior.iterator();
            while (it.hasNext()) {
                if (it.next().getTokenNumbers() < 1)
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    public void fire() {
        //transition的发射函数，
        // 在该函数内部完成各个place内部token数的增减，以及transition的所有数据域的更新
        if (this.enable()) {
            Iterator<Place> it = this.placePrior.iterator();
            while(it.hasNext() ){
                it.next().tokenSub();
            }
            //以上完成transition的前驱place的更新
            //以下完成transition的后继place的更新
            Iterator<Place> it2 = this.placeNext.iterator();
            while(it2.hasNext()){
                it2.next().tokenAdd();
            }
            }
        else{
        System.out.println("The placePrior is not enable !");
        }
    }
    public String toString(){
        //重写的toString方法
        return this.getTransitionName();
    }
    public String toString2(){
        return this.getTransitionName()+"     "+this.getPlacePrior()+"      "+this.getPlaceNext();
    }
}

