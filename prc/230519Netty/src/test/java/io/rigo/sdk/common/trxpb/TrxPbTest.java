package io.rigo.sdk.common.trxpb;

import io.rigo.sdk.proto.TrxPb;

import static io.rigo.sdk.common.builder.TrxBuilder.decodeTrx;
import static io.rigo.sdk.common.utils.Bytes.b64ToBytes;
import static io.rigo.sdk.common.utils.TrxPbUtils.decodeToTrxProto;

public class TrxPbTest {

    public static void main(String[] args) {
        String hash = "CAEQgPyK2JuJ3qAXGAMiFCkDarANGLG3J0RIL1oJ/d6MbxluKhSNxBqGuR64jYJInE0Deun/ymXPvzIBAToBCkABUkGJEiY4/vDieToPP7oY+piEaQ2PGslX+xQ36bKC90kJwEqudYvRGOfzJPJfvs7fxh6ckP5nSf0fCQWUVXH4Ng0FAA==";
        TrxPb.TrxProto trxProto = decodeToTrxProto(b64ToBytes(hash));
        System.out.println(trxProto);
        System.out.println(decodeTrx(hash));
    }
}