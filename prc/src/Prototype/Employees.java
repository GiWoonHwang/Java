package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    private List < String > empList;

    // 생성자
    public Employees() {
        empList = new ArrayList <String > ();
    }
    public Employees(List < String > list) {
        this.empList = list;
    }

    public void loadData() {
        empList.add("Ann");
        empList.add("David");
        empList.add("John");
        empList.add("Methew");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.empList){
            temp.add(s);
        }
        return new Employees(temp);
    }
}