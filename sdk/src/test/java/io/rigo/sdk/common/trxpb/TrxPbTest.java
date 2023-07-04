package io.rigo.sdk.common.trxpb;

import io.rigo.sdk.proto.TrxPb;

import static io.rigo.sdk.common.builder.TrxBuilder.decodeTrx;
import static io.rigo.sdk.common.utils.Bytes.b64ToBytes;
import static io.rigo.sdk.common.utils.TimeUtils.fromNanoSecond;
import static io.rigo.sdk.common.utils.TrxPbUtils.decodeToTrxProto;

public class TrxPbTest {

    public static void main(String[] args) {
        String hash = "CAEQgNK/h56OnLAXGNeYAiIUGWUI8d9DpWLwRGkroL0WzvmS7DcqFBtjcWpDsIyXZdC+BC8t5op+3ZtuMgEBOgEKQAFSQXi8PoURjZkP5Bcw4R+YPR7hbT8nmsyocWIjFCOWqLlXZ8IE07FRtFV39gM1fxj0CR5SYyHb5tuUCSQNhMJmERkA";
        TrxPb.TrxProto trxProto = decodeToTrxProto(b64ToBytes(hash));
        System.out.println(trxProto);
        System.out.println(decodeTrx(hash));
        System.out.println(decodeTrx(hash));
        System.out.println(fromNanoSecond(trxProto.getTime()));
    }
}