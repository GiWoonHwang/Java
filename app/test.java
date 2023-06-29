class parent{
    public int compute(int num){
        if(num <=1) return num;
        return compute(num-1) + compute(num-2);
    }
}

class Child extends parent {
    public int compute(int num){
        if(num<=1) return num;
        return compute(num-1) + compute(num-3);
    }
}

class good{
    public static void main (String[] args){
        parent obj = new Child();
        System.out.print(obj.compute(4));
    }
}
 
  