package BlockChain;

public class Test {
    public static void test(String[] args){
        Block genesisBlock = new Block("Genesis Block", "0"); // 첫 블록이기 때문에 해쉬는 0
        System.out.println("Genesis Block : " + genesisBlock.getHash());
    }
}
