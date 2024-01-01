
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();

        list.add(10); list.add(20); list.add(30);

        System.out.println("second value : " + list.get(2));
        list.remove(2);
        list.add(40);
        list.set(0, 100);
        System.out.println("second value : " + list.get(2));
        System.out.println(list.toString());
    }
}