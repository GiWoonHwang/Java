package Flyweight;

import java.util.HashMap;

public class TreeFactory {
    public static final HashMap<String, Tree> treeMap = new HashMap<>();

    //Map에 입력받은 색상의 나무가 있는지 찾습니다. 있으면 그 객체를 제공합니다.
    public static Tree getTree(String treeColor){
        Tree tree = (Tree)treeMap.get(treeColor);

        if(tree == null){
            tree = new Tree(treeColor);
            treeMap.put(treeColor, tree);
            System.out.println("새 객체 생성");
        }
        return tree;

    }
}
