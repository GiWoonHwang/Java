package io.dustin.board.common.exception;

public class DuplicatedVoteException extends RuntimeException {
    public DuplicatedVoteException(String message) {
        super(message);
    }
}
