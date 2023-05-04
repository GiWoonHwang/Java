package BlockChain;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    private int nonce;

    private Block() {

    }

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;

        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    public String calculateHash(){
        return BlockUtils.generateHash(previousHash, Long.toString(timeStamp), Integer.toString(nonce), data);
    }

    public void mineBlock(){
        char[] targetChar  = new char[BlockChain.DIFFICULTY]; // DIFFICULTY 만큼 배열의 길이 지정
        Arrays.fill(targetChar, '0'); // 0으로 채움
        String target = String.valueOf(targetChar); // 배열을 문자열로 변환 ?
        System.out.println(hash.substring(0, BlockChain.DIFFICULTY));

        while (hash.substring(0, BlockChain.DIFFICULTY).equals(target) == false) {
            nonce++;
            hash = calculateHash();
        }

        System.out.println("Block Mined!!! : " + hash);
    }
}
































