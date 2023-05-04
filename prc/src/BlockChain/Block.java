package BlockChain;

import java.util.Date;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    private Block() {

    }

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;

        this.timeStamp = new Date().getTime();

    }

    public String getPreviosHash() {
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
}
































