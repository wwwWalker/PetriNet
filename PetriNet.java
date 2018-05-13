import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;
public class PetriNet {
    final int arcPower = 1;
    private String PetriNetName;
    private Set<Place> placeSet;
    private Set<Transition> transitionSet;
    private Set<Arc> arcSet;
    public PetriNet() {
    }

    public PetriNet(String petriNetName) {
        //petr网的构造方法
        this.setPetriNetName(petriNetName);
        this.placeSet = new HashSet<Place>();
        this.transitionSet = new HashSet<Transition>();
        this.arcSet = new HashSet<Arc>();
    }

    public void setPetriNetName(String petriNetName) {
        this.PetriNetName = petriNetName;
    }

    public String getPetriNetName() {
        return this.PetriNetName;
    }

    public Set<Place> getPlaceSet() {
        return placeSet;
    }

    public Set<Transition> getTransitionSet() {
        return transitionSet;
    }

    public Set<Arc> getArcSet() {
        return arcSet;
    }

    public void arcCreate(String arcName, Place place, Transition transition) {
        //规定弧线创建的时候，是将前面的place和后面的transition连接在一起
        Arc arc = new Arc(arcName, place, transition, arcPower);
        place.addTransitionNext(transition);
        transition.addPlacePrior(place);
        arcSet.add(arc);
    }

    public void arcCreate(String arcName, Transition transition, Place place) {
        //规定弧线创建的时候，是将前面的transition和后面的place连接在一起
        Arc arc = new Arc(arcName, transition, place, arcPower);
        transition.addPlaceNext(place);
        place.addTransitionPrior(transition);
        arcSet.add(arc);
    }

    public Place addPlace(String placeName, int tokenCapacity, int tokenNumbers) {
        //创建一个place,但不连接到petriNet
        Place placeNew = new Place(placeName, tokenCapacity, tokenNumbers);
        System.out.print(placeNew.toString());
        this.placeSet.add(placeNew);
        return placeNew;
    }

    public Transition addTransition(String transitionName) {
        //创建一个transition，但不连接到petriNet
        Transition transitionNew = new Transition(transitionName);
        System.out.println(transitionNew.toString());
        this.transitionSet.add(transitionNew);
        return transitionNew;
    }

    public void randomFire() {
        //随机发射函数，从petriNet的随机某一个transition结点开始发射
        int size = this.getTransitionSet().size();
        Transition[] transitionArray = new Transition[size];
        transitionArray = this.getTransitionSet().toArray(transitionArray);
        Random random = new Random();
        int num = random.nextInt(size);
        System.out.println("The transition to fire is " + transitionArray[num]);
        transitionArray[num].fire();
    }

    public void selectFire(Transition transitionSelected) {
        transitionSelected.fire();
    }

    public void printerState() {
        //打印当前时间，petri所有place的token数量，以及所有 transition
        System.out.println("The place is :\n" + this.getPlaceSet());
    }

    public void printBond() {
        System.out.println("Place数目    " + this.getPlaceSet().size() +
                "     Transition数目    " + this.getTransitionSet().size() + "    Arc数目" + this.getArcSet().size());
        Iterator<Place> it = this.placeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString2());
        }
        System.out.println("******************************");
        Iterator<Transition> it2 = this.transitionSet.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().toString2());
        }
        System.out.println("******************************");
        Iterator<Arc> it3 = this.arcSet.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next().toString());
        }
    }
}
