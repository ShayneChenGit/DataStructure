package mysequence;

import common.IPosition;
import myException.ExceptionBoundaryViolation;
import myException.ExceptionPositionInvalid;
import myList.DLNode;
import myList.List_DLNode;

import javax.swing.text.Position;

public class Sequence_DLNode extends List_DLNode implements ISequence {

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return rank2Pos(r).getElem();
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return replace(rank2Pos(r), obj);
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        if (getSize() == r) {
            insertLast(obj);
        } else {
            insertBefore(rank2Pos(r), obj);
        }
        return obj;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return remove(rank2Pos(r));
    }

    @Override
    public IPosition rank2Pos(int r) throws ExceptionBoundaryViolation {
        DLNode node;
        checkRank(r, getSize());
        if (r <= getSize() / 2) {
            node = header.getNext();
            for (int i = 0; i < r; i++) {
                node = node.getNext();
            }
        } else {
            node = trailer.getPrev();
            for (int i = 1; i < getSize() - r; i++) {
                node = node.getPrev();
            }
        }
        return node;
    }

    @Override
    public int pos2Rank(Position p) throws ExceptionPositionInvalid {
        DLNode node = header.getNext();
        int r = 0;
        while (node != trailer) {
            if (node == p) {
                return r;
            }
            node = node.getNext();
            r++;
        }
        throw new ExceptionPositionInvalid("position not in sequence");
    }

    protected void checkRank(int r, int n) {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("invalid rank, out of boundary");
        }
    }
}
