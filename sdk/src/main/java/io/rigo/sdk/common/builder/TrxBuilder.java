package io.rigo.sdk.common.builder;

import io.rigo.sdk.domain.transaction.model.Trx;
import io.rigo.sdk.proto.TrxPb;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bouncycastle.util.encoders.Hex;

import static io.rigo.sdk.common.utils.Bytes.b64ToBytes;
import static io.rigo.sdk.common.utils.Bytes.toHex;
import static io.rigo.sdk.common.utils.NumberUtils.numberFromByteString;
import static io.rigo.sdk.common.utils.TrxPbUtils.decodeToTrxProto;
import static org.web3j.crypto.Hash.sha256;

/**
 * RigoWeb3 TrxBuilder
 * created by basquiat
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrxBuilder {

    public static Trx decodeTrx(String hash) {
        byte[] byteHash = b64ToBytes(hash);
        TrxPb.TrxProto trxProto = decodeToTrxProto(byteHash);
        //TrxPb.TrxPayloadUnstakingProto trxPayloadUnstakingProto = decodeTrxPayloadUnstakingProto(trxProto.getPayload().toByteArray());
        return Trx.builder()
                  .hash(Hex.toHexString(sha256(byteHash)))
                  .version(trxProto.getVersion())
                  .time(trxProto.getTime())
                  .nonce(trxProto.getNonce())
                  .from(toHex(trxProto.getFrom().toByteArray()))
                  .to(toHex(trxProto.getTo().toByteArray()))
                  .amount(numberFromByteString(trxProto.getAmount()))
                  .gas(numberFromByteString(trxProto.getGas()))
                  .type(trxProto.getType())
                  .payload(trxProto.getPayload())
                  .sig(toHex(trxProto.getSig().toByteArray()))
                  .build();
    }

}
