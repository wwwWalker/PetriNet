public class Main {
    public static void main(String args[]){
        //将初始化结点时候的变量设置为常量
        final int tokenCapacity= 10;
        final int tokenNum = 5;
        System.out.println("Now  create a petri!");
        PetriNet myPetri = new PetriNet("PrtriNet");
        System.out.println("The petri constructed is :"+ myPetri.getPetriNetName());
        //实例化所需要连接的Place和Transition
        Place p1 = myPetri.addPlace("p1",tokenCapacity,tokenNum);
        Place p2 = myPetri.addPlace("p2",tokenCapacity,tokenNum);
        Place p3 = myPetri.addPlace("p3",tokenCapacity,tokenNum);
        Place p4 = myPetri.addPlace("p4",tokenCapacity,tokenNum);
        Place p5 = myPetri.addPlace("p5",tokenCapacity,tokenNum);
        Place p6 = myPetri.addPlace("p6",tokenCapacity,tokenNum);
        Transition t1 =  myPetri.addTransition("t1");
        Transition t2 =  myPetri.addTransition("t2");
        System.out.println("Now we should connect the petri by yourself !");
        //将所创建的结点用Arc连在一起
        myPetri.arcCreate("arc1",p1,t1);
        myPetri.arcCreate("arc2",p2,t1);
        myPetri.arcCreate("arc3",p3,t1);
        myPetri.arcCreate("arc4",t1,p4);
        myPetri.arcCreate("arc5",t1,p5);
        myPetri.arcCreate("arc6",p4,t2);
        myPetri.arcCreate("arc7",p5,t2);
        myPetri.arcCreate("arc8",t2,p6);
        //打印当前创建的petri的各个结点的连接状态
        myPetri.printBond();
        System.out.println("Before fire :The petri is :");
        myPetri.printerState();
        myPetri.randomFire();//随即发射
        System.out.println("After fire :The petri is :");
        myPetri.printerState();
        System.out.println("Now select a transition to fire !\neg:transition2");
        myPetri.selectFire(t2);//选择结点Transition2发射
        System.out.println("After fire : The petriStatus is :\n");
        myPetri.printerState();
        System.exit(0);
    }
}