package BlockChain;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    public static List<Block> BLOCK_CHAIN = new LinkedList<>();

    public static void main(String[] args){
        BLOCK_CHAIN.add(new Block("이건 Genesis Block 입니다.", "0"));
        BLOCK_CHAIN.add(new Block("이건 두번째 블럭 입니다.", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
        BLOCK_CHAIN.add(new Block("이건 세번째 블럭 입니다.", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));

        for (Block block : BLOCK_CHAIN){
            System.out.println("=========");

            System.out.println("hash : " + block.getHash());
            System.out.println("previousHash : " + block.getPreviousHash());
            System.out.println("timeStamp : " + block.getTimeStamp());
            System.out.println("Data : " + block.getData());
        }
        System.out.println("=========");
    }

    private static boolean isValidBlockChain() {
        Block currentBlock;
        Block previousBlock;

        for(int i = 1; i<BLOCK_CHAIN.size(); i++){ // 제네시스 블록은 제외한다.
            currentBlock = BLOCK_CHAIN.get(i); // 인덱스를 해당하는 값 가져온다.
            previousBlock = BLOCK_CHAIN.get(i-1);

            if(currentBlock.getHash().equals(currentBlock.calculateHash()) == false){ // 이 부분이 왜 필요한지 모르겠다.
                System.out.println("Not Equals Current Block Hash!!");
                return false;

            }

            if(currentBlock.getPreviousHash().equals(previousBlock.getHash()) == false){
                System.out.println("Not Equals Previous Block Hash!!");
                return false;
            }
        }

        return true;
    }
}
